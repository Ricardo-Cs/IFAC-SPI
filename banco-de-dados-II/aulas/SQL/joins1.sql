-- Joins 1 (base de dados: queries/bd_treino_joins.sql)

-- INNER JOIN -> Retorna apenas os registros que tem correspondência nas duas tabelas (ou seja, a interseção dos dois conjuntos)
SELECT c.id, c.nome, v.valor
FROM clientes c
INNER JOIN vendas v ON c.id = v.cliente_id
ORDER BY c.id;

-- LEFT JOIN -> Retorna os registros da tabela da esquerda (clientes nesse caso) e os registros que tem correspondência
-- Nesse caso, todos os registros de clientes foram retornados, mesmo os que não tinham vendas registradas
SELECT c.id, c.nome, v.valor
FROM clientes c
LEFT JOIN vendas v ON c.id = v.cliente_id
ORDER BY c.id;

-- RIGHT JOIN -> Retorna os registros da tabela da direita (vendas nesse caso) e os registros que tem correspondência
SELECT c.id, c.nome, v.valor
FROM clientes c
RIGHT JOIN vendas v ON c.id = v.cliente_id
ORDER BY c.id;

-- FULL OUTER JOIN -> Retorna as duas tabelas, e os registros que tem correspondência
-- MYSQL não tem suporte nativo para esse comando (FULL OUTER JOIN vendas v ON c.id = v.cliente_id)
-- Uma alternativa para isso é fazer uma união entre um LEFT e RIGHT JOIN
SELECT c.id, c.nome, SUM
FROM clientes c
LEFT JOIN vendas v ON c.id = v.cliente_id
UNION
SELECT c.id, c.nome, v.valor
FROM clientes c
RIGHT JOIN vendas v ON c.id = v.cliente_id;
