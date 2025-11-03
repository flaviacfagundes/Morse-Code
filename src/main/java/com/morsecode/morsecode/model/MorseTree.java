package com.morsecode.morsecode.model;

/**
 * Classe responsável por gerenciar a Árvore Binária de Busca
 * para o código Morse, onde ponto (.) vai à esquerda e traço (-) vai à direita.
 */
public class MorseTree {
    private Node root;
    
    public MorseTree() {
        this.root = null;
    }
    
    /**
     * Insere um caractere na árvore seguindo a heurística do código morse:
     * ponto (.) à esquerda e traço (-) à direita.
     * 
     * @param letter Caractere a ser inserido
     * @param morseCode Sequência de pontos e traços representando o caractere
     */
    public void insert(char letter, String morseCode) {
        if (root == null) {
            // Cria uma raiz vazia que serve como ponto de partida
            root = new Node(' ', "");
        }
        insertRecursive(root, letter, morseCode, 0);
    }
    
    /**
     * Método recursivo auxiliar para inserção na árvore.
     * 
     * @param node Nó atual na recursão
     * @param letter Caractere a ser inserido
     * @param morseCode Sequência de pontos e traços
     * @param index Índice atual na sequência morseCode
     */
    private void insertRecursive(Node node, char letter, String morseCode, int index) {
        if (index >= morseCode.length()) {
            // Chegou ao final da sequência, atualiza o nó com o caractere
            node.setLetter(letter);
            node.setMorseCode(morseCode);
            return;
        }
        
        char symbol = morseCode.charAt(index);
        
        if (symbol == '.') {
            // Ponto vai à esquerda
            if (node.getLeft() == null) {
                node.setLeft(new Node(' ', "")); // Nó temporário
            }
            insertRecursive(node.getLeft(), letter, morseCode, index + 1);
        } else if (symbol == '-') {
            // Traço vai à direita
            if (node.getRight() == null) {
                node.setRight(new Node(' ', "")); // Nó temporário
            }
            insertRecursive(node.getRight(), letter, morseCode, index + 1);
        }
    }
    
    /**
     * Decodifica uma sequência de código morse para o caractere correspondente.
     * 
     * @param morseCode Sequência de pontos e traços
     * @return Caractere decodificado ou '?' se não encontrado
     */
    public char decodeChar(String morseCode) {
        return decodeCharRecursive(root, morseCode, 0);
    }
    
    /**
     * Método recursivo auxiliar para decodificação de um caractere.
     */
    private char decodeCharRecursive(Node node, String morseCode, int index) {
        if (node == null) {
            return '?'; // Caractere não encontrado
        }
        
        if (index >= morseCode.length()) {
            return node.getLetter(); // Chegou ao final, retorna o caractere do nó
        }
        
        char symbol = morseCode.charAt(index);
        
        if (symbol == '.') {
            return decodeCharRecursive(node.getLeft(), morseCode, index + 1);
        } else if (symbol == '-') {
            return decodeCharRecursive(node.getRight(), morseCode, index + 1);
        }
        
        return '?'; // Símbolo inválido
    }
    
    /**
     * Decodifica uma palavra completa em código morse.
     * Palavras são separadas por espaço e caracteres por /.
     * 
     * @param morseWord Sequência de código morse (ex: ".- -...")
     * @return Palavra decodificada
     */
    public String decodeWord(String morseWord) {
        if (morseWord == null || morseWord.trim().isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        String[] characters = morseWord.trim().split("\\s+"); // Separa por espaços
        
        for (String morseChar : characters) {
            char decoded = decodeChar(morseChar);
            result.append(decoded);
        }
        
        return result.toString();
    }
    
    /**
     * Codifica um caractere para código morse.
     * 
     * @param letter Caractere a ser codificado
     * @return Sequência de pontos e traços ou "" se não encontrado
     */
    public String encodeChar(char letter) {
        return encodeCharRecursive(root, letter, "");
    }
    
    /**
     * Método recursivo auxiliar para codificação de um caractere.
     */
    private String encodeCharRecursive(Node node, char letter, String currentPath) {
        if (node == null) {
            return "";
        }
        
        if (node.getLetter() == letter && !node.getMorseCode().isEmpty()) {
            return node.getMorseCode();
        }
        
        String leftResult = encodeCharRecursive(node.getLeft(), letter, currentPath + ".");
        if (!leftResult.isEmpty()) {
            return leftResult;
        }
        
        String rightResult = encodeCharRecursive(node.getRight(), letter, currentPath + "-");
        if (!rightResult.isEmpty()) {
            return rightResult;
        }
        
        return "";
    }
    
    /**
     * Codifica uma palavra completa para código morse.
     * 
     * @param word Palavra a ser codificada
     * @return Sequência de código morse com caracteres separados por espaço
     */
    public String encodeWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        String upperWord = word.toUpperCase();
        
        for (int i = 0; i < upperWord.length(); i++) {
            char letter = upperWord.charAt(i);
            
            if (letter == ' ') {
                result.append(" / ");
            } else {
                String morse = encodeChar(letter);
                if (!morse.isEmpty()) {
                    result.append(morse);
                    if (i < upperWord.length() - 1 && upperWord.charAt(i + 1) != ' ') {
                        result.append(" ");
                    }
                }
            }
        }
        
        return result.toString().trim();
    }
    
    /**
     * Retorna a raiz da árvore.
     */
    public Node getRoot() {
        return root;
    }
    
    /**
     * Imprime a árvore no console de forma visual.
     */
    public void printTree() {
        System.out.println("\n=== ÁRVORE BINÁRIA DE CÓDIGO MORSE ===\n");
        if (root == null) {
            System.out.println("Árvore vazia.");
            return;
        }
        printTreeRecursive(root, "", true);
    }
    
    /**
     * Método recursivo auxiliar para impressão visual da árvore.
     */
    private void printTreeRecursive(Node node, String prefix, boolean isLast) {
        if (node == null) {
            return;
        }
        
        System.out.print(prefix);
        System.out.print(isLast ? "└── " : "├── ");
        
        if (node.getLetter() != ' ' && !node.getMorseCode().isEmpty()) {
            System.out.println("'" + node.getLetter() + "' (" + node.getMorseCode() + ")");
        } else {
            System.out.println("[nó interno]");
        }
        
        if (node.getLeft() != null || node.getRight() != null) {
            String newPrefix = prefix + (isLast ? "    " : "│   ");
            
            if (node.getRight() != null) {
                printTreeRecursive(node.getLeft(), newPrefix, node.getRight() == null);
            }
            if (node.getRight() != null) {
                printTreeRecursive(node.getRight(), newPrefix, true);
            }
        }
    }
    
    /**
     * Retorna representação em String da árvore.
     */
    public String getTreeAsString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== ÁRVORE BINÁRIA DE CÓDIGO MORSE ===\n\n");
        if (root == null) {
            sb.append("Árvore vazia.");
            return sb.toString();
        }
        getTreeAsStringRecursive(root, "", true, sb);
        return sb.toString();
    }
    
    /**
     * Método recursivo auxiliar para obter String da árvore.
     */
    private void getTreeAsStringRecursive(Node node, String prefix, boolean isLast, StringBuilder sb) {
        if (node == null) {
            return;
        }
        
        sb.append(prefix);
        sb.append(isLast ? "└── " : "├── ");
        
        if (node.getLetter() != ' ' && !node.getMorseCode().isEmpty()) {
            sb.append("'").append(node.getLetter()).append("' (").append(node.getMorseCode()).append(")\n");
        } else {
            sb.append("[nó interno]\n");
        }
        
        if (node.getLeft() != null || node.getRight() != null) {
            String newPrefix = prefix + (isLast ? "    " : "│   ");
            
            if (node.getLeft() != null) {
                getTreeAsStringRecursive(node.getLeft(), newPrefix, node.getRight() == null, sb);
            }
            if (node.getRight() != null) {
                getTreeAsStringRecursive(node.getRight(), newPrefix, true, sb);
            }
        }
    }
}

