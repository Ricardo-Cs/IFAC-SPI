function parOuImpar() {
    const resposta = document.getElementById("par-impar-resposta");
    const valor = document.getElementById("par-impar-input").value;
    valor % 2 == 0 ? resposta.innerText = "Par" : resposta.innerText = "Ímpar";
}

function calculoIMC() {
    const altura = document.getElementById("altura").value;
    const peso = document.getElementById("peso").value;
    const resposta = document.getElementById("imc-resposta");

    resposta.innerHTML = `O IMC é: ${(peso / (altura ** 2)).toFixed(2)}`;
}

function calcularMedia() {
    const notas = document.getElementsByName("nota");
    const resposta = document.getElementById("media-resposta");
    let media = 0;
    notas.forEach(nota => {
        media += parseInt(nota.value);
    });
    resposta.innerText = `A média das notas é: ${media / 4}`;
}

function maiorNumero() {
    const numeros = document.getElementById("maior-numero").value.split(",");
    const resposta = document.getElementById("maior-resposta");
    resposta.innerText = `O maior número é: ${Math.max(...numeros)}`;
}

function inverterPalavra() {
    const palavra = document.getElementById("palavra-invertida").value;
    // Split transforma a palavra em um array, com os elementos sendo cada letra. Reverse inverte os valores desse array. Join junta tudo e retorna uma string.
    const invertida = palavra.split('').reverse().join(''); 
    const resposta = document.getElementById("palavra-invertida-resposta");
    resposta.innerText = `A palavra ${palavra} ao contrário é: ${invertida}`;
}

function pesquisarPalavra() {
    const frase = document.getElementById("frase").value;
    const palavra = document.getElementById("palavra-pesquisa").value;
    const resposta = document.getElementById("palavra-pesquisa-resposta");

    frase.match(palavra) ? resposta.innerText = "A palavra existe na frase." : resposta.innerText = "A palavra não existe na frase.";
}

function maiorNumeroArray() {
    const array = [];
    const resposta = document.getElementById("maior-numero-array-resposta");
    const arrayHTML = document.getElementById("maior-numero-array");
    
    for(let i = 0; i < 50; i++) {
        array[i] = Math.floor(Math.random() * 100);
    }

    arrayHTML.innerText = `Array em Ordem Crescente: ${array.sort()}`;
    resposta.innerText = `Maior número: ${array[array.length - 1]}`;
}

function mediaArray() {
    const array = [];
    let media = 0;
    const resposta = document.getElementById("media-numero-array-resposta");
    const arrayHTML = document.getElementById("media-numero-array");

    for(let i = 0; i < 50; i++) {
        let valor = Math.floor(Math.random() * 100);
        array[i] = valor;
        media += valor; 
    }

    arrayHTML.innerText = `Array: ${array}`;
    resposta.innerText = `Média: ${media / 50}`;
}