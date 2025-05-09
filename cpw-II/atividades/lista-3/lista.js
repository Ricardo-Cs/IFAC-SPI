const nomesMap = new Map();

function gerarNumerosAleatorios() {
    const numeros = [];
    
    for(let i = 0; i < 100; i++) {
        numeros[i] = Math.floor(Math.random() * 100);
    }

    return numeros;
}

function contagemNumeros() {
    const numeros = gerarNumerosAleatorios();
    const resposta = document.getElementById('contagem-numeros-resposta');
    const repeticoesMap = new Map();

    numeros.forEach((num) => {
        if(repeticoesMap.has(num)) repeticoesMap.set(num, repeticoesMap.get(num) + 1);
        else repeticoesMap.set(num, 1);
    });

    numeros.sort((a, b) => a - b);
    resposta.innerText = `Array Ordenado: ${numeros} \n\nQuantidade de Repetições: `;
    repeticoesMap.forEach((valor, chave) => {
        resposta.innerText += `\nNúmero: ${chave} - Repetição: ${valor} vez(es)`;
    });
}

function numerosNaoRepetidos() {
    const numeros = gerarNumerosAleatorios();
    const resposta = document.getElementById('numeros-nao-repetidos-resposta');
    const numerosSet = new Set();

    numeros.forEach(num => {
        numerosSet.add(num);
    });

    numeros.sort((a, b) => a - b);
    // Imprimi o set em forma de array e ordenado, para melhor visualização
    resposta.innerText = `Array Ordenado: ${numeros} \n\nSem Repetições: ${[...numerosSet].sort((a, b) => a - b).join(', ')}`;
}

function nomeCachorro() {
    const nome = document.getElementById('nome-cachorro').value;
    const resposta = document.getElementById('nome-cachorro-resposta');

    if(nomesMap.has(nome)) nomesMap.set(nome, nomesMap.get(nome) + 1);
    else nomesMap.set(nome, 1);

    resposta.innerText = "\nIndicações";
    nomesMap.forEach((valor, chave) => {
        resposta.innerText += `\nNome: ${chave} - Quantidade: ${valor} vez(es)`;
    });
}