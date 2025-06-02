function validarData() {
    const data = document.getElementById("data").value;
    const dataResposta = document.getElementById("dataResposta");
    const regexData =
        /^((0[1-9])|((1|2)[0-9])|(3[01])|([1-9]{1}))\/(([1-9])|(0[1-9])|(1[012]))\/([0-9]{4})/g;

    const resultado = regexData.exec(data);
    if (resultado) {
        dataResposta.innerText = "Data válida";
        dataResposta.style.color = "green";
    } else {
        dataResposta.innerText = "Data inválida";
        dataResposta.style.color = "red";
    }
}

function validarPlaca() {
    const placa = document.getElementById("placa").value;
    const placaResposta = document.getElementById("placaResposta");
    const regexPlaca = /[A-Z]{3}[0-9][A-Z][0-9]{2}/g;

    const resultado = regexPlaca.exec(placa);
    if (resultado) {
        placaResposta.innerText = "Placa válida!";
        placaResposta.style.color = "green";
    } else {
        placaResposta.innerText = "Placa inválida!";
        placaResposta.style.color = "red";
    }
}

function validarCPF() {
    const cpf = document.getElementById("cpf").value;
    const cpfResposta = document.getElementById("cpfResposta");
    const regexCpf = /[0-9]{3}\.[0-9]{3}\.[0-9]{3}\-[0-9]{2}/g;

    const resultado = regexCpf.exec(cpf);
    if (resultado) {
        cpfResposta.innerText = "CPF válido!";
        cpfResposta.style.color = "green";
    } else {
        cpfResposta.innerText = "CPF inválido!";
        cpfResposta.style.color = "red";
    }
}

function validarNome() {
    const nome = document.getElementById("nome").value;
    const nomeResposta = document.getElementById("nomeResposta");
    const regexNome = /^[A-Za-zÀ-ÖØ-öø-ÿ]+(?: [A-Za-zÀ-ÖØ-öø-ÿ]+)*$/g;

    const resultado = regexNome.exec(nome);
    if (resultado) {
        nomeResposta.innerHTML = "Nome válido!";
        nomeResposta.style.color = "green";
    } else {
        nomeResposta.innerText = "Nome inválido!";
        nomeResposta.style.color = "red";
    }
}
