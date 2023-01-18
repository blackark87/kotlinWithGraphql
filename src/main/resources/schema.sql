create sequence if not exists bank_account_seq start with 1 increment by 1;
create sequence if not exists bank_transaction_seq start with 1 increment by 1;

create table BANK_USER (
                           id long primary key,
                           name varchar(50),
                           age int,
                           reg_date date
);

create table BANK_ACCOUNT (
                              ROW_ID long not null default bank_account_seq.nextval,
                              id long,
                              ACCOUNT_NO varchar(50)
);

alter table BANK_ACCOUNT add constraint BANK_ACCOUNT_PK primary key (ROW_ID);
alter table BANK_ACCOUNT add constraint BANK_ACCOUNT_FK foreign key (id) references BANK_USER(id);



create table BANK_TRANSACTION (
                                  ROW_ID long not null default bank_transaction_seq.nextval,
                                  ACCOUNT_NO varchar(50),
                                  DEPOSIT_YN char,
                                  AMOUNT int,
                                  TRANSACTION_DATE date
);

alter table BANK_TRANSACTION add constraint BANK_TRANSACTION_PK primary key (ROW_ID);
alter table BANK_TRANSACTION add constraint BANK_TRANSACTION_FK foreign key (ACCOUNT_NO) references BANK_ACCOUNT(ACCOUNT_NO);