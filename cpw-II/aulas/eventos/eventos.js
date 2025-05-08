function tamanhoInput() {
    const nome = document.getElementById("nome").value;
    document.getElementById("tamanho").innerHTML = nome.length;
}

function eventoFocus() {
    console.log("Foco no input nome");
}

function eventoBlur() {
    console.log("Foco não está no input nome");
}