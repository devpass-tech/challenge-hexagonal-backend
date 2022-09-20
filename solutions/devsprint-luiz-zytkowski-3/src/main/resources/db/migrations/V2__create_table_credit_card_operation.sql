CREATE TABLE credit_card_operation (
    id VARCHAR(32) PRIMARY KEY NOT NULL,
    credit_card VARCHAR(32) NOT NULL,
    type VARCHAR(10) NOT NULL,
    value DOUBLE NOT NULL,
    description TEXT NOT NULL,
    created_at DATETIME NOT NULL
);