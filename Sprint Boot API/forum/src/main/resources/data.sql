INSERT INTO USUARIO(id, nome, email, senha) VALUES(1, 'Aluno', 'aluno@email.com', '123456');

INSERT INTO CURSO(id, nome, categoria) VALUES(1, 'Spring Boot', 'Programação');
INSERT INTO CURSO(id, nome, categoria) VALUES(2, 'HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida', 'Erro ao criar projeto', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Dúvida sobre JPA', 'Entidade não mapeada corretamente', CURRENT_TIMESTAMP(), 'NAO_RESPONDIDO', 1, 1);