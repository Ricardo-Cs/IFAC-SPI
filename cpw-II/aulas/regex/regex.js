function validar() {
    const cep = document.getElementById('cep').value;
    const regex_cep = /[0-9]{5}-[0-9]{3}/g;

    const resultado = regex_cep.exec(cep);
    if(resultado) alert('Certo');
    else alert('Errado');
}