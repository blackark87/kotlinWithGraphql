create table BANK_USER (
    id long primary key,
    name varchar(50),
    age int,
    reg_date date
);

create table BANK_ACCOUNT (
    row_id long AUTO_INCREMENT,
    user_id long,
    account_no varchar(50),
    PRIMARY KEY (row_id),
    UNIQUE (account_no),
    FOREIGN KEY (user_id) REFERENCES BANK_USER(id)

);

create table BANK_TRANSACTION (
    row_id long AUTO_INCREMENT,
    account_no varchar(50) not null,
    deposit_yn char,
    amount int,
    transaction_date date,
    PRIMARY KEY (row_id),
    FOREIGN KEY (account_no) REFERENCES BANK_ACCOUNT(account_no)
);