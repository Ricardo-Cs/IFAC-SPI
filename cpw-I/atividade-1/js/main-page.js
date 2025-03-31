const playerName = document.querySelector("[player-name]");
const startQuizButton = document.querySelectorAll(".start-quiz");
const startQuizDiv = document.querySelectorAll(".quiz");

playerName.innerHTML = localStorage.getItem("player");

const startQuiz = (quizNumber) => {
    window.location = `./quiz.html?quiz=${quizNumber}`;
};

startQuizButton.forEach((button, index) => {
    button.addEventListener("click", () => startQuiz(index + 1));
});

startQuizDiv.forEach((div, index) => {
    div.addEventListener("click", () => startQuiz(index + 1));
});
