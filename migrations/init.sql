DROP TABLE IF EXISTS logs;

CREATE TABLE IF NOT EXISTS logs (
    id                  INT             AUTO_INCREMENT PRIMARY KEY,
    description         TEXT            NOT NULL,
    ip_address          VARCHAR(15)     NOT NULL,
    endpoint            VARCHAR(255)    NOT NULL,
    requester           VARCHAR(50)     NOT NULL,
    timestamp           TIMESTAMP       DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS subscription (
    id                  INT             AUTO_INCREMENT PRIMARY KEY,
    email               TEXT            NOT NULL,
    creatorId           TEXT            NOT NULL
);
