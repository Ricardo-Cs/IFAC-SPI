package com.example.aplicacao;

import javafx.application.Application;
import javafx.geometry.Pos; // Importe para alinhamento
import javafx.scene.Scene;
import javafx.scene.control.Button; // Importe para o botão
import javafx.scene.control.Label;
import javafx.scene.layout.VBox; // Usaremos VBox para organizar elementos verticalmente
import javafx.stage.Stage;

public class App extends Application {

    // Contador para mostrar a funcionalidade do botão
    private int contadorCliques = 0;
    // Label que vai exibir o texto e o contador
    private Label mensagemLabel;

    @Override
    public void start(Stage stage) {
        // 1. Criar os elementos da interface
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        mensagemLabel = new Label("Clique no botão! (JavaFX " + javafxVersion + " rodando no Java " + javaVersion + ")");
        
        Button cliqueAquiBotao = new Button("Clique Aqui!");

        // 2. Definir a ação do botão
        cliqueAquiBotao.setOnAction(event -> {
            contadorCliques++;
            mensagemLabel.setText("Você clicou " + contadorCliques + " vezes!");
        });

        // 3. Organizar os elementos em um layout
        // VBox organiza os elementos verticalmente
        VBox root = new VBox(20); // 20 é o espaçamento entre os elementos
        root.setAlignment(Pos.CENTER); // Centraliza os elementos na VBox
        root.getChildren().addAll(mensagemLabel, cliqueAquiBotao); // Adiciona a label e o botão

        // 4. Criar a cena e definir no palco (Stage)
        Scene scene = new Scene(root, 400, 250); // Largura e altura da janela

        stage.setTitle("Minha Primeira Interface JavaFX"); // Título da janela
        stage.setScene(scene); // Define a cena no palco
        stage.show(); // Exibe o palco
    }

    public static void main(String[] args) {
        launch();
    }
}