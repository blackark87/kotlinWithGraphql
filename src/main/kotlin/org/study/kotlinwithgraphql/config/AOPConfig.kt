package org.study.kotlinwithgraphql.config

import jakarta.servlet.http.HttpServletRequest
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.json.JSONObject
import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Pointcut
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*

@Component
@Aspect
class AOPConfig {
    val log = KotlinLogging.logger {}

    fun getParamsByRequest(request: HttpServletRequest): JSONObject {
        lateinit var jsonObject: JSONObject
        val params: Enumeration<String> = request.parameterNames

        while (params.hasMoreElements()) {
            val paramName: String = params.nextElement()
            val replaceParams: String = paramName.replace("\\.","-")
            jsonObject.put(replaceParams, request.getParameter(paramName))
        }

        return jsonObject
    }

    @Pointcut("within(org.study.kotlinwithgraphql.controller..*)")
    fun onRequest() {}
    
    private fun paramMapToString(paramStringMap: Map<String, Array<String>> ): String {
        return paramStringMap.flatMap { (key, value) -> value.map { "$key=$it" } }.joinToString(", ")
    }

    private fun anyToString(objectArray: Any): String {
        return objectArray.toString()
    }

    @Around("onRequest()")
    fun doLogging(proceedingJoinPoint: ProceedingJoinPoint): Any? {
        lateinit var request: HttpServletRequest
        try{
            request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        } catch (e: Exception) {
            return proceedingJoinPoint.proceed(proceedingJoinPoint.args)
        }

        val paramMap: Map<String, Array<String>>? = request.parameterMap
        val args: Any? = proceedingJoinPoint.args[0]

        lateinit var param: String

        try{
            if (request.requestURI.equals("/graphql")){
                args?.let{
                    param = "[" + anyToString(it) + "]"
                }
            } else{
                paramMap?.let {
                    param = "[" + paramMapToString(it) + "]"
                } ?: run {
                    if(request.contentType == "application/json") {
                        param = getParamsByRequest(request).toString().ifEmpty { "" }
                    }
                }
            }

        } catch(e: Exception) {
            e.printStackTrace()
        }

        val startTime: Long = System.currentTimeMillis()

        try {
            return proceedingJoinPoint.proceed(proceedingJoinPoint.args)
        } finally {
            val endTime: Long = System.currentTimeMillis()
            val elapsedTime: Long = endTime - startTime

            if (request.requestURI.equals("/graphql")){
                log.info("Request: {} {}{} < {} ({}ms) {}", request.method, proceedingJoinPoint.signature.name,
                    param, request.remoteHost, elapsedTime, request.getHeader("User-Agent"))
            } else{
                log.info("Request: {} {}{} < {} ({}ms) {}", request.method, request.requestURI,
                    param, request.remoteHost, elapsedTime, request.getHeader("User-Agent"))
            }

        }
    }
    
}
