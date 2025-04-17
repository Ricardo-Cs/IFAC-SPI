const p1 = document.getElementById("p1");
const p2 = document.getElementById("p2");

function voltar() {
    history.back();
}

function avancar() {
    history.forward();
}

function alterar() {
    if (p1.innerHTML == "Novo Texto") {
        p1.innerHTML = "Primeiro exemplo JS";
        p1.style.color = "blue";
    }
    else {
        p1.innerHTML = "Novo Texto";
        p1.style.color = "red";
    }
}

function remover() {
    p2.style.visibility == "visible" ? p2.style.visibility = "hidden" : p2.style.visibility = "visible";
}