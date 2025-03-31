// Função para atualizar a tabela de resultados
const updateResultsTable = () => {
    const resultsBody = document.getElementById("results-body");
    const results = JSON.parse(localStorage.getItem("quizResults")) || [];

    // Limpar a tabela antes de adicionar novos dados
    resultsBody.innerHTML = "";

    // Verificar se não há resultados e exibir mensagem
    if (results.length === 0) {
        const emptyRow = document.createElement("tr");
        emptyRow.innerHTML = `
            <td colspan="2" class="empty-message">Nenhum resultado encontrado</td>
        `;
        resultsBody.appendChild(emptyRow);
        return; // Finalizar a execução aqui, já que a tabela está vazia
    }

    // Adicionar cada resultado como uma nova linha na tabela
    results.forEach((result) => {
        const row = document.createElement("tr");

        const quizCell = document.createElement("td");
        quizCell.textContent = result.quiz;
        row.appendChild(quizCell);

        const correctCell = document.createElement("td");
        correctCell.textContent = `${result.correct} / 10`;
        row.appendChild(correctCell);

        resultsBody.appendChild(row);
    });
};

// Chamar a função ao carregar a página
document.addEventListener("DOMContentLoaded", updateResultsTable);
