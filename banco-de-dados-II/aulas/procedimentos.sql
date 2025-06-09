-- Stored Procedure é uma coleção de comandos em SQL, que podem ser executadas em um Banco de dados de uma só vez, como em uma função.

-- Exemplo 1 - Criando um procedimento (queries/bd_comercio.sql)
DELIMITER //
CREATE PROCEDURE listar_clientes()
BEGIN
    SELECT * FROM clientes;
END //
DELIMITER ;

-- Chamando o procedimento
CALL listar_clientes();

-- Exemplo 2 - Pegar um aluno pelo seu id (queries/bd_academico.sql)
DELIMITER //
CREATE PROCEDURE listar_aluno_específico(IN identificador INT)
BEGIN
    SELECT * FROM alunos
    WHERE alunos.id = identificador;
END //
DELIMITER ;

-- Chamando exemplo 2 - Retorna o aluno com id = 1
CALL listar_aluno_específico(1);

-- Exemplo 3 - Inserir aluno (queries/bd_academico.sql)
DELIMITER //
CREATE PROCEDURE inserir_aluno(IN id INT, nome VARCHAR(50), email VARCHAR(50))
BEGIN
    INSERT INTO alunos(id, nome, email) 
    VALUES(id, nome, email);
END //
DELIMITER;

-- Chamando exemplo 3
CALL inserir_aluno(21, "Ricardo Costa", "ricardo@gmail.com");

-- Para alterar um procedimento em MYSQL, tem que apagar e criar de novo
DROP PROCEDURE inserir_aluno;