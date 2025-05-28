function validarData() {
    const data = document.getElementById('data').value;
    const dataResposta = document.getElementById('dataResposta');
    const regexData = /((0[1-9])|((1|2)[0-9])|(3[01])|([1-9]{1}))\/(([1-9])|(0[1-9])|(1[012]))\/([0-9]{4})/g;

    const resultado = regexData.exec(data);
    if(resultado) {
        dataResposta.innerText = "Data válida";
        dataResposta.style.color = "green";
    } else {
        dataResposta.innerText = "Data inválida";
        dataResposta.style.color = "red";
    }
}