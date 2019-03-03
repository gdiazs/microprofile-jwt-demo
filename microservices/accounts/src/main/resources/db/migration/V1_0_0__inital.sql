create table ACCOUNTS (
    USER_ID varchar(100) not null,
    IBAN varchar(100) not null,
    BALANCE DECIMAL(13,2) not null,
    CURRENCY VARCHAR(3) not null,
    COUNTRY VARCHAR(2) not null,
    CREATED_AT TIMESTAMP not null,
    UPDATED_AT TIMESTAMP not null,
    VERSION INT default 1,
    PRIMARY KEY (USER_ID, IBAN)
);