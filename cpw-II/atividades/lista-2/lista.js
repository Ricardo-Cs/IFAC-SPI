function arrayNumerosAleatorios() {
    const array = [];

    for(let i = 0; i < 50; i++) {
        array[i] = Math.floor(Math.random() * 100);
    }

    return array;
}

function maiorNumero() {
    const array = arrayNumerosAleatorios();
    const resposta = document.getElementById('maior-numero-resposta');

    array.sort((a, b) => a - b);
    resposta.innerText = `Array Ordenado: ${array}\n Maior Número: ${Math.max(...array)}`;
    // Ou array[array.length - 1]
}

function media() {
    const array = [];
    let media = 0;
    const resposta = document.getElementById('media-resposta');
    
    for(let i = 0; i < 50; i++) {
        let num = Math.floor(Math.random() * 100);
        array[i] = num
        media += num; 
    }
    
    array.sort((a, b) => a - b);
    resposta.innerText = `Array Ordenado: ${array}\n Média: ${media / 50}`;
}

function maisRepetidos() {
    const array = arrayNumerosAleatorios();
    const resposta = document.getElementById('mais-repetidos-resposta');
    const valoresArray = new Map();

    array.forEach((num) => {
        if(valoresArray.has(num)) {
            valoresArray.set(num, valoresArray.get(num) + 1);
        } else {
            valoresArray.set(num, 1);
        }
    });
    
    // Ordena o map
    const maisFrequentes = [...valoresArray.entries()].sort((a, b) => b[1] - a[1]);
    
    array.sort((a, b) => a - b);
    resposta.innerText = `Array Ordenado: ${array} \nMais Repetidos: `;

    resposta.innerText += `\n${maisFrequentes[0][0]} - ${maisFrequentes[0][1]} vezes`
    resposta.innerText += `\n${maisFrequentes[1][0]} - ${maisFrequentes[1][1]} vezes`
    resposta.innerText += `\n${maisFrequentes[2][0]} - ${maisFrequentes[2][1]} vezes`
}

function quantidadeRepeticoes() {
    const array = arrayNumerosAleatorios();
    const resposta = document.getElementById('quantidade-repeticoes-resposta');
    const valoresMap = new Map();

    array.forEach((num) => {
        if(valoresMap.has(num)) {
            valoresMap.set(num, valoresMap.get(num) + 1);
        } else {
            valoresMap.set(num, 1);
        }
    });

    array.sort((a, b) => a - b);
    resposta.innerText = `Array Ordenado: ${array} \nQuantidade de Repetições: `;
    valoresMap.forEach((valor, chave) => {
        resposta.innerText += `\nNúmero: ${chave} - Repetição: ${valor} vez(es)`;
    });
}

function menorNumero() {
    const array = arrayNumerosAleatorios();
    const resposta = document.getElementById('menor-numero-resposta');

    array.sort((a, b) => a - b);
    resposta.innerText = `Array: ${array}\n Menor Número: ${Math.min(...array)}`;
    // Ou array[0]
}