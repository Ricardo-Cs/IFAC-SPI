from matplotlib import pyplot as plt

plt.style.use('dark_background')

eixo_x_dias = [1, 5, 10, 15, 20, 25, 30]    
eixo_y_temp_max = [28, 29, 25, 32, 34, 36, 31]
eixo_y_temp_min = [21, 22, 17, 23, 23, 24, 20]

plt.plot(eixo_x_dias, eixo_y_temp_max, linestyle='--', marker='o', linewidth=3)
plt.plot(eixo_x_dias, eixo_y_temp_min, linewidth=5, color='#A1A6B4')

plt.title('Temperatura Máxima e Mínima')
plt.xlabel('Dias')
plt.ylabel('Temperatura')
plt.legend(['Temp Max', 'Temp Min'])
plt.grid(True)
plt.show()