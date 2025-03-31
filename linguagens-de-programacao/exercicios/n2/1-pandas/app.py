import pandas as pd

df = pd.read_csv('alunos.csv')

print(df, '\n\n')
print(df.head(), '\n\n')
print(df[df['Status'] == 'Ativo'], '\n\n')

alunos_por_curso = df.groupby('Curso')['Aluno'].count()
print(alunos_por_curso)

# Com index=False o nome dos cursos não é imprimido na saída
alunos_por_curso.to_csv('agrupamento.csv')
