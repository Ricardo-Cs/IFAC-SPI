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
    const notas = document.getElementsByName("nota")[0].value;
    console.log(notas);
}