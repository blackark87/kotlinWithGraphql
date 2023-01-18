create sequence if not exists bank_account_seq start with 1 increment by 1;
create sequence if not exists bank_transaction_seq start with 1 increment by 1;

create table BANK_USER (
                           id long primary key,
                           name varchar(50),
                           age int,
                           reg_date date
);

create table BANK_ACCOUNT (
                              ROW_ID long default bank_account_seq.nextval,
                              id long,
                              ACCOUNT_NO varchar(50)
);


create table BANK_TRANSACTION (
                                  ROW_ID long default bank_transaction_seq.nextval,
                                  ACCOUNT_NO varchar(50),
                                  DEPOSIT_YN char,
                                  AMOUNT int,
                                  TRANSACTION_DATE date
);
