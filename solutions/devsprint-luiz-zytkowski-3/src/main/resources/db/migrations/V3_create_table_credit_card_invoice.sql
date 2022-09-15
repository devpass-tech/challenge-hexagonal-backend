CREATE TABLE credit_card_invoice
(
    id VARCHAR(32) PRIMARY KEY NOT NULL,
    owner VARCHAR (11) NOT NULL,
    number VARCHAR (16) NOT NULL,
    security_code VARCHAR (3) NOT NULL,
    printed_name VARCHAR (25) NOT NULL,
    credit_limit DOUBLE NOT NULL,
    available_credit_limit DOUBLE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
);