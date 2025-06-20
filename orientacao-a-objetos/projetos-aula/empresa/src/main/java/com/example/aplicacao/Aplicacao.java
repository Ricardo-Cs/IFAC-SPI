package com.example.aplicacao;

import com.example.servico.Servico;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Aplicacao extends Application {

    private Servico servico = new Servico(); // Instância do seu serviço de negócio
    private TextArea outputArea; // Área para exibir mensagens de saída

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Gerenciamento de Departamentos e Funcionários");

        // --- Layout Principal (VBox) ---
        VBox root = new VBox(15); // Espaçamento de 15px entre os elementos
        root.setPadding(new Insets(20)); // Preenchimento de 20px nas bordas
        root.setAlignment(Pos.TOP_CENTER);

        // --- Título ---
        Label titleLabel = new Label("MENU PRINCIPAL");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // --- Área de Saída ---
        outputArea = new TextArea();
        outputArea.setEditable(false); // Não permite que o usuário edite diretamente
        outputArea.setPrefHeight(150);
        outputArea.setPromptText("As mensagens do sistema aparecerão aqui...");

        // --- Botões do Menu ---
        // Criar um GridPane para organizar os botões em 2 colunas
        GridPane menuGrid = new GridPane();
        menuGrid.setHgap(10); // Espaçamento horizontal
        menuGrid.setVgap(10); // Espaçamento vertical
        menuGrid.setAlignment(Pos.CENTER);

        Button btnCadastrarDepto = createMenuButton("1. Cadastrar Departamento");
        btnCadastrarDepto.setOnAction(e -> handleCadastrarDepartamento());

        Button btnRemoverDepto = createMenuButton("2. Remover Departamento");
        btnRemoverDepto.setOnAction(e -> showSimpleInputDialog("Remover Departamento", "ID do Departamento:", id -> {
            String resultado = servico.removerDepartamento(id);
            outputArea.appendText("\n" + resultado);
        }));

        Button btnCadastrarFuncionario = createMenuButton("3. Cadastrar Funcionário");
        btnCadastrarFuncionario.setOnAction(e -> handleCadastrarFuncionario());

        Button btnRemoverFuncionario = createMenuButton("4. Remover Funcionário");
        btnRemoverFuncionario.setOnAction(e -> showSimpleInputDialog("Remover Funcionário", "Matrícula do Funcionário:", matricula -> {
            // Lógica para remover funcionário (Operação realizada)
            outputArea.appendText("\nOperação realizada (remoção de funcionário: " + matricula + ")");
        }));

        Button btnTransferirFuncionario = createMenuButton("5. Transferir Funcionário");
        btnTransferirFuncionario.setOnAction(e -> handleTransferirFuncionario());

        Button btnListarFuncDepto = createMenuButton("6. Listar Funcionários por Departamento");
        btnListarFuncDepto.setOnAction(e -> showSimpleInputDialog("Listar Funcionários", "ID do Departamento:", id -> {
            String resultado = servico.listarFuncionariosDepartamento(id);
            outputArea.appendText("\n" + resultado);
        }));

        Button btnListarTodosFunc = createMenuButton("7. Listar Todos os Funcionários");
        btnListarTodosFunc.setOnAction(e -> {
            String resultado = servico.listarFuncionarios();
            outputArea.appendText("\n" + resultado);
        });

        Button btnSair = createMenuButton("0. Sair do Sistema");
        btnSair.setOnAction(e -> primaryStage.close()); // Fecha a janela

        // Adicionar botões ao GridPane
        menuGrid.add(btnCadastrarDepto, 0, 0); // Coluna 0, Linha 0
        menuGrid.add(btnRemoverDepto, 1, 0);   // Coluna 1, Linha 0
        menuGrid.add(btnCadastrarFuncionario, 0, 1);
        menuGrid.add(btnRemoverFuncionario, 1, 1);
        menuGrid.add(btnTransferirFuncionario, 0, 2);
        menuGrid.add(btnListarFuncDepto, 1, 2);
        menuGrid.add(btnListarTodosFunc, 0, 3);
        menuGrid.add(btnSair, 1, 3);

        root.getChildren().addAll(titleLabel, menuGrid, outputArea);

        Scene scene = new Scene(root, 700, 600); // Ajuste o tamanho conforme necessário
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // --- Métodos Auxiliares para Manipular a Lógica do Menu ---

    private Button createMenuButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(250); // Largura fixa para os botões do menu
        return button;
    }

    private void handleCadastrarDepartamento() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL); // Bloqueia a janela principal
        dialogStage.setTitle("Cadastrar Departamento");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label lblNome = new Label("Nome do departamento:");
        TextField txtNome = new TextField();
        txtNome.setPromptText("Ex: Marketing");

        Label lblId = new Label("ID do departamento:");
        TextField txtId = new TextField();
        txtId.setPromptText("Ex: MKT001");

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setOnAction(e -> {
            String nome = txtNome.getText();
            String identificador = txtId.getText();
            if (nome.isEmpty() || identificador.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Campos Vazios", "Por favor, preencha todos os campos.");
            } else {
                String resultado = servico.cadastrarDepartamento(nome, identificador);
                outputArea.appendText("\n" + resultado);
                dialogStage.close(); // Fecha a janela de diálogo após salvar
            }
        });

        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setOnAction(e -> dialogStage.close());

        HBox buttonBox = new HBox(10, btnSalvar, btnCancelar);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        grid.add(lblNome, 0, 0);
        grid.add(txtNome, 1, 0);
        grid.add(lblId, 0, 1);
        grid.add(txtId, 1, 1);
        grid.add(buttonBox, 1, 2); // Botões na coluna 1, linha 2

        Scene dialogScene = new Scene(grid);
        dialogStage.setScene(dialogScene);
        dialogStage.showAndWait(); // Exibe e espera o usuário interagir
    }

    // Exemplo de como você faria para "Remover Funcionário"
    // e "Listar Funcionários por Departamento" de forma mais genérica
    private void showSimpleInputDialog(String title, String promptText, java.util.function.Consumer<String> action) {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle(title);

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        Label label = new Label(promptText);
        TextField inputField = new TextField();
        inputField.setPromptText("Digite aqui...");

        Button btnOk = new Button("OK");
        btnOk.setOnAction(e -> {
            String input = inputField.getText();
            if (input.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Campo Vazio", "Por favor, preencha o campo.");
            } else {
                action.accept(input); // Executa a ação fornecida
                dialogStage.close();
            }
        });

        Button btnCancel = new Button("Cancelar");
        btnCancel.setOnAction(e -> dialogStage.close());

        HBox buttonBox = new HBox(10, btnOk, btnCancel);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        vbox.getChildren().addAll(label, inputField, buttonBox);

        Scene dialogScene = new Scene(vbox);
        dialogStage.setScene(dialogScene);
        dialogStage.showAndWait();
    }


    private void handleCadastrarFuncionario() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("Cadastrar Funcionário");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label lblNome = new Label("Nome do funcionário:");
        TextField txtNome = new TextField();
        Label lblCpf = new Label("CPF do funcionário:");
        TextField txtCpf = new TextField();
        Label lblIdDepto = new Label("ID do departamento de lotação:");
        TextField txtIdDepto = new TextField();

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setOnAction(e -> {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String idDepto = txtIdDepto.getText();
            if (nome.isEmpty() || cpf.isEmpty() || idDepto.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Campos Vazios", "Por favor, preencha todos os campos.");
            } else {
                String resultado = servico.cadastrarFuncionario(nome, cpf, idDepto);
                outputArea.appendText("\n" + resultado);
                dialogStage.close();
            }
        });

        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setOnAction(e -> dialogStage.close());

        HBox buttonBox = new HBox(10, btnSalvar, btnCancelar);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        grid.add(lblNome, 0, 0); grid.add(txtNome, 1, 0);
        grid.add(lblCpf, 0, 1); grid.add(txtCpf, 1, 1);
        grid.add(lblIdDepto, 0, 2); grid.add(txtIdDepto, 1, 2);
        grid.add(buttonBox, 1, 3);

        Scene dialogScene = new Scene(grid);
        dialogStage.setScene(dialogScene);
        dialogStage.showAndWait();
    }

    private void handleTransferirFuncionario() {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setTitle("Transferir Funcionário");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label lblMatricula = new Label("Matrícula do funcionário:");
        TextField txtMatricula = new TextField();
        Label lblIdAtual = new Label("ID do departamento de lotação atual:");
        TextField txtIdAtual = new TextField();
        Label lblIdDestino = new Label("ID do departamento de lotação de destino:");
        TextField txtIdDestino = new TextField();

        Button btnSalvar = new Button("Transferir");
        btnSalvar.setOnAction(e -> {
            String matricula = txtMatricula.getText();
            String idAtual = txtIdAtual.getText();
            String idDestino = txtIdDestino.getText();
            if (matricula.isEmpty() || idAtual.isEmpty() || idDestino.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Campos Vazios", "Por favor, preencha todos os campos.");
            } else {
                String resultado = servico.trasferirFuncionarioDepartamento(matricula, idAtual, idDestino);
                outputArea.appendText("\n" + resultado);
                dialogStage.close();
            }
        });

        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setOnAction(e -> dialogStage.close());

        HBox buttonBox = new HBox(10, btnSalvar, btnCancelar);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        grid.add(lblMatricula, 0, 0); grid.add(txtMatricula, 1, 0);
        grid.add(lblIdAtual, 0, 1); grid.add(txtIdAtual, 1, 1);
        grid.add(lblIdDestino, 0, 2); grid.add(txtIdDestino, 1, 2);
        grid.add(buttonBox, 1, 3);

        Scene dialogScene = new Scene(grid);
        dialogStage.setScene(dialogScene);
        dialogStage.showAndWait();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null); // Sem cabeçalho
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}