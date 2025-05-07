-- Liste alunos cujo nome comece com "J".
SELECT * FROM alunos
WHERE nome LIKE "J%";

-- Mostre professores com título "Mestre" ou "Especialista".
SELECT * FROM professores
WHERE titulacao IN ('Mestre', 'Especialista');

-- Liste disciplinas com carga horária entre 30 e 60 horas.
SELECT * FROM disciplinas
WHERE carga_horaria BETWEEN 30 AND 60
ORDER BY carga_horaria;

-- Mostre alunos ordenados pela data de nascimento (mais novo primeiro).
SELECT * FROM alunos
ORDER BY data_nascimento;

-- Liste disciplinas onde o ID seja 2, 4 ou 6.
SELECT * FROM disciplinas
WHERE id IN (2, 4, 6);

-- Liste notas maiores que 7 e menores que 9.
SELECT * FROM notas
WHERE nota BETWEEN 7 AND 9
ORDER BY nota;