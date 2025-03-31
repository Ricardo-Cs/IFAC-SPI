// Declaração de variáveis
const quizContent = document.querySelector(".quiz-content");
const finishQuiz = document.querySelector(".finish-quiz");
const status = document.querySelector("#status");
const tryAgain = document.querySelector("#try-again");
const backHome = document.querySelector("#back-home");
const showAnswers = document.querySelector("#correct-answers");
const quizQuestion = document.querySelector(".quiz-question h2");
const quizOptions = document.querySelectorAll(".quiz-options span");
const urlParams = new URLSearchParams(window.location.search);
const quizParams = urlParams.get("quiz");
let correct = 0;
let wrong = 0;
let currentQuestion = 0;

// Mapeia nome do quiz com base no número (para utilizar no title)
const getStringByNumber = (number) => {
    const map = {
        1: "Programação",
        2: "Conhecimentos Gerais",
        3: "Jogos",
        4: "Esportes",
    };

    return map[number];
};

document.title = `Quiz - ${getStringByNumber(quizParams)}`;

// Funções
const checkAnswer = (selectedOption) => {
    const correctAnswer = getCorrectAnswer();

    if (selectedOption.textContent == correctAnswer) {
        selectedOption.classList.add("correct");
        correct++;
        setTimeout(() => {
            selectedOption.classList.remove("correct");
        }, 1000);
    } else {
        selectedOption.classList.add("incorrect");
        wrong++;
        setTimeout(() => {
            selectedOption.classList.remove("incorrect");
        }, 1000);
    }
};

const getCorrectAnswer = () => {
    if (quizParams === "1") {
        return quizData.programming[currentQuestion].answer;
    }

    if (quizParams === "2") {
        return quizData.conhecimentos[currentQuestion].answer;
    }

    if (quizParams === "3") {
        return quizData.games[currentQuestion].answer;
    }

    if (quizParams === "4") {
        return quizData.sports[currentQuestion].answer;
    }

    return null;
};

const nextQuestion = () => {
    if (loadQuestion()) {
        currentQuestion++;
        window.localStorage.setItem("currentQuestion", currentQuestion);
        loadQuestion();
    }
};

const loadOptions = (quizOptions, quizData, type) => {
    quizOptions.forEach((option, index) => {
        option.innerHTML = quizData[type][currentQuestion].options[index];
    });
};

const enableOptionClick = () => {
    quizOptions.forEach((option) => {
        option.addEventListener("click", optionClickHandler);
    });
};

const optionClickHandler = (event) => {
    const selectedOption = event.target;
    checkAnswer(selectedOption);

    // Desabilitar cliques nas opções após o primeiro clique
    quizOptions.forEach((option) => {
        option.removeEventListener("click", optionClickHandler);
    });

    setTimeout(() => {
        nextQuestion();
        enableOptionClick();
        // Habilitar novamente o clique nas opções
    }, 1000);
};

const showResults = () => {
    quizContent.style.display = "none";
    finishQuiz.style.display = "block";
    showAnswers.innerHTML = correct;

    if (correct <= 3) {
        status.innerHTML = "Ruim";
    }

    if (correct >= 4 && correct <= 6) {
        status.innerHTML = "Aceitável";
    }

    if (correct >= 7 && correct <= 8) {
        status.innerHTML = "Bom";
    }

    if (correct == 9) {
        status.innerHTML = "Ótimo";
    }

    if (correct == 10) {
        status.innerHTML = "Perfeito";
    }

    // Salvar resultado no localStorage
    const quizName = getStringByNumber(quizParams);
    const results = JSON.parse(localStorage.getItem("quizResults")) || [];
    results.push({ quiz: quizName, correct });
    localStorage.setItem("quizResults", JSON.stringify(results));
};

const loadQuestion = () => {
    if (quizParams === "1") {
        if (quizData.programming[currentQuestion]) {
            quizQuestion.innerHTML =
                quizData.programming[currentQuestion].question;
            loadOptions(quizOptions, quizData, "programming");
            return true;
        } else {
            return showResults();
        }
    }

    if (quizParams === "2") {
        if (quizData.conhecimentos[currentQuestion]) {
            quizQuestion.innerHTML =
                quizData.conhecimentos[currentQuestion].question;
            loadOptions(quizOptions, quizData, "conhecimentos");
            return true;
        } else {
            return showResults();
        }
    }

    if (quizParams === "3") {
        if (quizData.games[currentQuestion]) {
            quizQuestion.innerHTML = quizData.games[currentQuestion].question;
            loadOptions(quizOptions, quizData, "games");
            return true;
        } else {
            return showResults();
        }
    }

    if (quizParams === "4") {
        if (quizData.sports[currentQuestion]) {
            quizQuestion.innerHTML = quizData.sports[currentQuestion].question;
            loadOptions(quizOptions, quizData, "sports");
            return true;
        } else {
            return showResults();
        }
    }
};

// Chamada das funções
tryAgain.addEventListener("click", () => {
    location.reload();
});

backHome.addEventListener("click", () => {
    window.location = "./main.html";
});

for (let i = 0; i < quizOptions.length; i++) {
    quizOptions[i].addEventListener("click", optionClickHandler);
}

loadQuestion();
