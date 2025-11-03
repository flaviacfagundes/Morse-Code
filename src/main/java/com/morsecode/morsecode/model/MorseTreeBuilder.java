package com.morsecode.morsecode.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe responsável por construir a árvore de código Morse
 * com todos os caracteres do alfabeto, números e símbolos especiais.
 */
public class MorseTreeBuilder {
    
    /**
     * Mapa que contém o código morse para cada caractere.
     */
    private static final Map<Character, String> MORSE_CODE_MAP = new HashMap<>();
    
    static {
        // Alfabeto (A-Z)
        MORSE_CODE_MAP.put('A', ".-");
        MORSE_CODE_MAP.put('B', "-...");
        MORSE_CODE_MAP.put('C', "-.-.");
        MORSE_CODE_MAP.put('D', "-..");
        MORSE_CODE_MAP.put('E', ".");
        MORSE_CODE_MAP.put('F', "..-.");
        MORSE_CODE_MAP.put('G', "--.");
        MORSE_CODE_MAP.put('H', "....");
        MORSE_CODE_MAP.put('I', "..");
        MORSE_CODE_MAP.put('J', ".---");
        MORSE_CODE_MAP.put('K', "-.-");
        MORSE_CODE_MAP.put('L', ".-..");
        MORSE_CODE_MAP.put('M', "--");
        MORSE_CODE_MAP.put('N', "-.");
        MORSE_CODE_MAP.put('O', "---");
        MORSE_CODE_MAP.put('P', ".--.");
        MORSE_CODE_MAP.put('Q', "--.-");
        MORSE_CODE_MAP.put('R', ".-.");
        MORSE_CODE_MAP.put('S', "...");
        MORSE_CODE_MAP.put('T', "-");
        MORSE_CODE_MAP.put('U', "..-");
        MORSE_CODE_MAP.put('V', "...-");
        MORSE_CODE_MAP.put('W', ".--");
        MORSE_CODE_MAP.put('X', "-..-");
        MORSE_CODE_MAP.put('Y', "-.--");
        MORSE_CODE_MAP.put('Z', "--..");
        
        // Números (0-9)
        MORSE_CODE_MAP.put('0', "-----");
        MORSE_CODE_MAP.put('1', ".----");
        MORSE_CODE_MAP.put('2', "..---");
        MORSE_CODE_MAP.put('3', "...--");
        MORSE_CODE_MAP.put('4', "....-");
        MORSE_CODE_MAP.put('5', ".....");
        MORSE_CODE_MAP.put('6', "-....");
        MORSE_CODE_MAP.put('7', "--...");
        MORSE_CODE_MAP.put('8', "---..");
        MORSE_CODE_MAP.put('9', "----.");
        
        // Caractere especial: espaço (representado como '/')
        MORSE_CODE_MAP.put(' ', "/");
    }
    
    /**
     * Constrói e retorna uma árvore de código Morse completa
     * com todos os caracteres do alfabeto e números.
     * 
     * @return MorseTree completa com todos os caracteres
     */
    public static MorseTree buildDefaultTree() {
        MorseTree tree = new MorseTree();
        
        for (Map.Entry<Character, String> entry : MORSE_CODE_MAP.entrySet()) {
            tree.insert(entry.getKey(), entry.getValue());
        }
        
        return tree;
    }
    
    /**
     * Constrói uma árvore de código Morse apenas com os caracteres especificados.
     * 
     * @param characters Conjunto de caracteres para incluir na árvore
     * @return MorseTree com apenas os caracteres especificados
     */
    public static MorseTree buildTreeForCharacters(Set<Character> characters) {
        MorseTree tree = new MorseTree();
        
        for (Character ch : characters) {
            String morseCode = MORSE_CODE_MAP.get(ch);
            if (morseCode != null) {
                tree.insert(ch, morseCode);
            }
        }
        
        return tree;
    }
    
    /**
     * Obtém o código morse de um caractere.
     * 
     * @param ch Caractere
     * @return Código morse ou null se não encontrado
     */
    public static String getMorseCode(char ch) {
        return MORSE_CODE_MAP.get(ch);
    }
}


