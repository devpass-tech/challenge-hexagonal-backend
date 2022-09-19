CREATE TABLE credit_card_invoice
(
    id          VARCHAR(32) PRIMARY KEY NOT NULL,
    credit_card VARCHAR(11)             NOT NULL,
    month       INT                     NOT NULL,
    year        INT                     NOT NULL,
    value       DOUBLE                  NOT NULL,
    created_at  TIMESTAMP               NOT NULL,
    paid_at     TIMESTAMP,
);