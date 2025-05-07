-- Funções de SELECT 1 (base de dados: queries/bd_academico.sql)

-- COUNT ('AS' utilizado apenas para mudar o nome da coluna de retorno)
SELECT 
    COUNT(*) AS quantidade_alunos 
FROM alunos;

-- COUNT - valores não nulos/"válidos" de uma coluna
SELECT 
    COUNT(email) AS quantidade_emails 
FROM alunos;

-- SUM
SELECT 
    SUM(nota) AS soma_notas 
FROM notas;

-- AVG - média
SELECT 
    AVG(nota) AS media_notas
FROM notas;

-- GROUP BY - agrupamento de linhas com os mesmos valores em colunas especificadas
SELECT
    id_disciplina, 
    AVG(nota) AS media_disciplina
FROM notas
GROUP BY id_disciplina;

-- HAVING - alternativa ao WHERE para funções de agregação (WHERE não funciona nesses casos)
SELECT
    id_disciplina, 
    AVG(nota) AS media_disciplina
FROM notas
GROUP BY id_disciplina
HAVING AVG(nota) > 8; 


-- ATIVIDADE DE FIXAÇÃO
-- 1) Conte quantos alunos estão cadastrados
SELECT 
    COUNT(*) AS alunos_cadastrados
FROM alunos;

-- 2) Mostre a soma total das notas da tabela notas
SELECT 
    SUM(nota) AS soma_notas
FROM notas;

-- 3) Apresente a média de notas dos alunos por disciplina
SELECT
    id_disciplina, 
    AVG(nota) AS media_disciplina
FROM notas
GROUP BY id_disciplina;

-- 4) Mostre quantas disciplinas existem por carga horária
SELECT
    COUNT(*) AS quantidade_disciplinas,
    carga_horaria
FROM disciplinas
GROUP BY carga_horaria;

-- 5) Mostre apenas os grupos de disciplinas cuja carga horária total ultrapasse 60h
SELECT
    COUNT(*) AS quantidade_disciplinas,
    carga_horaria
FROM disciplinas
WHERE carga_horaria > 30
GROUP BY carga_horaria;

-- 6) Liste quantos alunos existem por data de nascimento
SELECT
    COUNT(*) AS quantidade_alunos,
    data_nascimento
FROM alunos
GROUP BY data_nascimento;