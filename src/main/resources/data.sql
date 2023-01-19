insert into
    bank_user(id, name, age, REG_DATE)
    (select * from csvread('src/main/resources/data/bankUser.csv',null,'charset=UTF-8 fieldSeparator=,'));

insert into
    bank_account(user_id, account_no)
    (select * from csvread('src/main/resources/data/bankAccount.csv',null,'charset=UTF-8 fieldSeparator=,'));

insert into
    bank_transaction( account_no, deposit_yn, amount, transaction_date)
    (select * from csvread('src/main/resources/data/bankTransaction.csv',null,'charset=UTF-8 fieldSeparator=,'));