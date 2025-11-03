package com.morsecode.morsecode.controller;

import com.morsecode.morsecode.model.MorseTree;
import com.morsecode.morsecode.model.MorseTreeBuilder;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import java.util.HashSet;
import java.util.Set;

/**
 * Controller responsável por gerenciar a interface de conversão de código Morse.
 */
public class IncriptionController {
    public TextArea inputTextArea;
    public TextArea outputTextArea;
    
    private MorseTree morseTree;
    private Set<Character> lastProcessedCharacters; // Caracteres do último texto processado
    
    /**
     * Inicializa o controller, construindo a árvore de código Morse.
     */
    public void initialize() {
        morseTree = MorseTreeBuilder.buildDefaultTree();
        lastProcessedCharacters = new HashSet<>();
        // Imprime a árvore no console ao iniciar
        morseTree.printTree();
    }
    
    /**
     * Manipula a ação de criptografar (Texto -> Morse).
     */
    public void handleEncrypt(ActionEvent actionEvent) {
        String inputText = inputTextArea.getText();
        
        if (inputText == null || inputText.trim().isEmpty()) {
            showAlert("Aviso", "Por favor, digite um texto para criptografar.");
            return;
        }
        
        String encoded = morseTree.encodeWord(inputText);
        outputTextArea.setText(encoded);
        
        // Extrai caracteres únicos do texto de entrada
        lastProcessedCharacters = extractUniqueCharacters(inputText.toUpperCase());
    }
    
    /**
     * Manipula a ação de descriptografar (Morse -> Texto).
     */
    public void handleDecrypt(ActionEvent actionEvent) {
        String inputMorse = inputTextArea.getText();
        
        if (inputMorse == null || inputMorse.trim().isEmpty()) {
            showAlert("Aviso", "Por favor, digite um código Morse para descriptografar.");
            return;
        }
        
        String decoded = morseTree.decodeWord(inputMorse);
        outputTextArea.setText(decoded);
        
        // Extrai caracteres únicos do texto decodificado
        lastProcessedCharacters = extractUniqueCharacters(decoded.toUpperCase());
    }
    
    /**
     * Limpa os campos de entrada e saída.
     */
    public void handleClear(ActionEvent actionEvent) {
        inputTextArea.clear();
        outputTextArea.clear();
    }
    
    /**
     * Exibe a árvore binária de código Morse em um diálogo.
     * Se houver um texto processado recentemente, mostra apenas os caracteres relevantes.
     */
    public void handleShowTree(ActionEvent actionEvent) {
        MorseTree treeToShow;
        String headerText;
        
        if (lastProcessedCharacters != null && !lastProcessedCharacters.isEmpty()) {
            // Constrói árvore parcial apenas com caracteres processados
            treeToShow = MorseTreeBuilder.buildTreeForCharacters(lastProcessedCharacters);
            headerText = "Estrutura da Árvore (Caracteres Processados)";
        } else {
            // Mostra árvore completa se não houver texto processado
            treeToShow = morseTree;
            headerText = "Estrutura da Árvore (Completa)";
        }
        
        String treeString = treeToShow.getTreeAsString();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Árvore Binária de Código Morse");
        alert.setHeaderText(headerText);
        alert.setContentText(treeString);
        
        // Criar TextArea para melhor visualização
        TextArea textArea = new TextArea(treeString);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setPrefRowCount(20);
        textArea.setPrefColumnCount(50);
        
        alert.getDialogPane().setContent(textArea);
        alert.getDialogPane().setPrefSize(600, 500);
        
        alert.showAndWait();
    }
    
    /**
     * Extrai caracteres únicos de um texto, filtrando apenas caracteres válidos para código Morse.
     * 
     * @param text Texto do qual extrair caracteres
     * @return Conjunto de caracteres únicos
     */
    private Set<Character> extractUniqueCharacters(String text) {
        Set<Character> characters = new HashSet<>();
        
        for (char ch : text.toCharArray()) {
            // Inclui apenas caracteres que têm código morse (A-Z, 0-9, espaço)
            if ((ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == ' ') {
                characters.add(ch);
            }
        }
        
        return characters;
    }
    
    /**
     * Exibe um alerta simples.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
