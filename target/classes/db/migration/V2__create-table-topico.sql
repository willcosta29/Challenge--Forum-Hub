CREATE TABLE topico (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(255) NOT NULL,
    autor_id BIGINT,
    curso VARCHAR(255) NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
);