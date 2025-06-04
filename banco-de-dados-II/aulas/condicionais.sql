-- Condicionais (Sem base de dados, apenas exemplos)
-- CASE (WHEN)
SELECT nome,
    CASE 
        WHEN nota >= 7 THEN 'Aprovado'
        ELSE 'Reprovado'
    END AS situacao
FROM alunos;

-- CASE com mais de um WHEN
SELECT nome,
    CASE 
        WHEN nota >= 9 THEN 'Excelente'
        WHEN nota >= 7 THEN 'Bom'
        ELSE 'Reprovado'
    END AS situacao
FROM alunos;

-- IF (CASE reduzido)
SELECT nome, if(nota >= 7, 'Aprovado', 'Reprovado') AS situacao
FROM alunos;

-- IFNULL (Se a tabela especificada for nula, adiciona o valor a ela)
SELECT nome, IFNULL(email, 'Sem email') AS email
FROM clientes;

-- COALESCE (IFNULL com mais tabelas)
SELECT nome, COALESCE(email, telefone, 'Sem contato') AS contato
FROM clientes;

-- DECODE (não disponível no MYSQL)
-- Exemplo no Oracle (nesse caso, se sexo for 'M', a tabela guardará 'Masculino')
SELECT nome, DECODE(sexo, 'M', 'Masculino', 'F', 'Feminino', 'Outro') AS genero
FROM pessoas;