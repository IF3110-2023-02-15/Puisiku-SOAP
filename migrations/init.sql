DROP TABLE IF EXISTS logs;
DROP TABLE IF EXISTS subscription;

CREATE TABLE IF NOT EXISTS logs (
    id                  INT             AUTO_INCREMENT PRIMARY KEY,
    description         TEXT            NOT NULL,
    ipAddress           VARCHAR(15)     NOT NULL,
    endpoint            VARCHAR(255)    NOT NULL,
    requester           VARCHAR(50)     NOT NULL,
    timestamp           TIMESTAMP       DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS subscription (
    id                  INT             AUTO_INCREMENT PRIMARY KEY,
    email               VARCHAR(255)    NOT NULL,
    creatorId           INT             NOT NULL,
    timestamp           TIMESTAMP       DEFAULT CURRENT_TIMESTAMP
);
