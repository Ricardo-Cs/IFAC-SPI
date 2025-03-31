const form = document.querySelector('form');
const input = document.querySelector('input');
const span = document.querySelector('span');

// Exemplo de requisiçâo de api
form.addEventListener("submit", (e) => {
    e.preventDefault();
    const request = new Request(`http://viacep.com.br/ws/${input.value}/json/`);
    fetch(request)
        .then((response) => response.json())
        .then(data => {
            console.log(data);
            span.innerHTML = `Bairro: ${data.bairro} <br>
            Logradouro: ${data.logradouro} <br>
            Estado: ${data.estado}`;
        })
});
