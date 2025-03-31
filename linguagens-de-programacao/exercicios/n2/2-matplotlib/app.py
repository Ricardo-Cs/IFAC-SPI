from matplotlib import pyplot as plt

plt.style.use('ggplot')

eixo_x_meses = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
eixo_y_arroz = [28, 29, 25, 32, 34, 36, 31, 28, 29, 25, 32, 34]
eixo_y_feijao = [21, 22, 17, 23, 23, 24, 20, 21, 22, 17, 23, 23]

plt.plot(eixo_x_meses, eixo_y_arroz, marker='o')
plt.plot(eixo_x_meses, eixo_y_feijao, linestyle='--', marker='^')

plt.title('Venda Anual')
plt.xlabel('Meses')
plt.ylabel('Vendas')
plt.legend(['Arroz', 'Feijão'])
plt.grid(True)

plt.show()