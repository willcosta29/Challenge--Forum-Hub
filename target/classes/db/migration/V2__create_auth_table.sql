
CREATE TABLE IF NOT EXISTS auth
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL
);

INSERT INTO auth (username, password) VALUES ('admin', '123456');