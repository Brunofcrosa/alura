CREATE TABLE USUARIO (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         nome VARCHAR(255),
                         email VARCHAR(255),
                         senha VARCHAR(255),
                         PRIMARY KEY (id)
);

CREATE TABLE TOPICO (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        titulo VARCHAR(255),
                        mensagem VARCHAR(255),
                        data_criacao TIMESTAMP,
                        status VARCHAR(255),
                        autor_id BIGINT,
                        curso_id BIGINT,
                        PRIMARY KEY (id)
);
CREATE TABLE CURSO (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       nome VARCHAR(255),
                       categoria VARCHAR(255),
                       PRIMARY KEY (id)
);
CREATE TABLE RESPOSTA (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          mensagem VARCHAR(255),
                          topico_id BIGINT,
                          data_criacao TIMESTAMP,
                          autor_id BIGINT,
                          solucao BOOLEAN,
                          PRIMARY KEY (id)
);