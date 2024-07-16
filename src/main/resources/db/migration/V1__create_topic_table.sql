CREATE TABLE IF NOT EXISTS `tb_topic` (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    message VARCHAR(255),
    creation_time TIMESTAMP,
    topic_status VARCHAR(255),
    author VARCHAR(255),
    course VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

