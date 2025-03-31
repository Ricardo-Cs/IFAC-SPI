aluno = {
    "nome": input("Informe o nome do aluno: "),
    "idade": int(input("Informe a idade do aluno: ")),
    "nota": float(input("Informe a nota do aluno: "))
}

print("\nInformações do Aluno:")
print(f"Nome: {aluno['nome']}")
print(f"Idade: {aluno['idade']} anos")
print(f"Nota: {aluno['nota']:.2f}")
