function parOuImpar() {
    const parImparResposta = document.getElementById("par-impar-resposta");
    const inputParImpar = document.getElementById("par-impar-input").value;
    inputParImpar % 2 == 0 ? parImparResposta.innerText = "Par" : parImparResposta.innerText = "Ímpar";
}

function calculoIMC() {
    const altura = document.getElementById("altura").value;
    const peso = document.getElementById("peso").value;
    const imcResposta = document.getElementById("imc-resposta");

    imcResposta.innerHTML = `O IMC é: ${(peso / (altura ** 2)).toFixed(2)}`;
}

function calcularMedia() {
    const notas = document.getElementsByName("nota");
    const mediaResposta = document.getElementById("media-resposta");
    let media = 0;
    notas.forEach(nota => {
        media += parseInt(nota.value);
    });
    mediaResposta.innerText = `A média das notas é: ${media / 4}`;
}

function maiorNumero() {
    const numeros = document.getElementById("maior-numero").value.split(",");
    const maiorResposta = document.getElementById("maior-resposta");
    maiorResposta.innerText = `O maior número é: ${Math.max(...numeros)}`;
}

function inverterPalavra() {
    const palavra = document.getElementById("palavra-invertida").value;
    // Split transforma a palavra em um array, com os elementos sendo cada letra. Reverse inverte os valores desse array. Join junta tudo e retorna uma string.
    const invertida = palavra.split('').reverse().join(''); 
    const inverterResposta = document.getElementById("palavra-invertida-resposta");
    inverterResposta.innerText = `A palavra ${palavra} ao contrário é: ${invertida}`;
}