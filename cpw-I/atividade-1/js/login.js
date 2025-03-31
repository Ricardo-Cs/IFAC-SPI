const form = document.querySelector(".input-name");
const inputName = document.querySelector("input[type=text]");
const buttonLogin = document.querySelector(".login-button");
const buttonLoginSvg = document.querySelector(".login-button svg");

inputName.addEventListener("input", ({ target }) => {
    if (target.value.length < 3) {
        buttonLogin.classList.add("disabled");
        return;
    }

    buttonLogin.classList.remove("disabled");
});

form.addEventListener("submit", (event) => {
    event.preventDefault();

    localStorage.setItem("player", inputName.value);
    window.location = "./pages/main.html";
});
