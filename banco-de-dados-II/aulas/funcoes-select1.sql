-- Funções de SELECT 1 (base de dados: queries/bd_academico.sql)
USE ifac;

-- ORDER BY
SELECT * FROM alunos 
ORDER BY data_nascimento;

-- ORDER BY com duas colunas
SELECT * FROM disciplinas 
ORDER BY carga_horaria DESC, nome ASC;

-- ORDER BY com WHERE
SELECT * FROM alunos 
WHERE data_nascimento < '2004-01-01'
ORDER BY data_nascimento DESC;

-- LIKE
-- Nesse caso, nomes que começam com Ana
SELECT * FROM alunos
WHERE nome LIKE 'Ana%';

-- Nesse caso, nomes de disciplinas que podem ter algo antes de física, exemplo: Educação Fisica
SELECT * FROM disciplinas
WHERE nome LIKE '%Fisica';

-- BETWEEN
SELECT * FROM notas
WHERE nota BETWEEN 7 AND 9
ORDER BY nota;

-- IN -> Filtra registros que correspondem a uma lista de valores (como um OR)
SELECT * FROM professores
WHERE titulacao IN ('Mestre', 'Doutor');

-- Negação da query anterior
SELECT * FROM professores
WHERE titulacao NOT IN ('Mestre', 'Doutor');