import pandas as pd

df = pd.read_csv('dados_vendas.csv')
# print(df)
# print(df.head(1)) - Imprime as primeiras n-linhas (padrão: 5 linhas)
# print(df.info()) - Imprime informações da tabela, como tipo de dados da coluna
# print(df.describe()) - Descrição de algumas colunas da tabela, como quantidade de registros

vendas_fevereiro = df[df['Data de Venda'] >= '2023-02-10']
# print(vendas_fevereiro)

vendas_por_categoria = df.groupby('Categoria')['Quantidade Vendida'].sum()
# print(vendas_por_categoria)
vendas_por_categoria_e_produto = df.groupby(['Categoria', 'Produto'])['Quantidade Vendida'].sum()
# print(vendas_por_categoria_e_produto)

df['receita'] = df['Quantidade Vendida'] * df['Preço Unitário']
receita_categoria = df.groupby(['Categoria', 'Produto'])['receita'].sum()
# print(receita_categoria)

vendas_por_categoria.to_csv('agrupamento.csv', index=False)