function mostrarDados() {
    const inputColor = document.getElementById("cor").value;;
    const selectEstado = document.getElementById("estado").value;
    const resposta = document.getElementById("resposta");

    resposta.style.color = inputColor
    resposta.innerText = selectEstado;
}

function mostrarDadosRadio() {
    const resposta = document.getElementById("respostaRadio");
    const radio = document.querySelector('input[name="email"]:checked').value;

    resposta.innerText = radio;
}

function mostrarDadosCheckbox() {
    const resposta = document.getElementById("respostaCheckbox");
    const checkbox = document.querySelectorAll('input[name="sentido"]:checked');
    let text = "";

    checkbox.forEach(element => {
        text += element.value + "<br>";
    });

    resposta.innerHTML = text;
}