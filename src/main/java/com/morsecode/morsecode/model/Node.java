package com.morsecode.morsecode.model;

public class Node {
    private char letter;
    private String morseCode;
    private Node left;  //? ponto (.)
    private Node right; //? traço (-)

    public Node(char letter, String morseCode) {
        this.letter = letter;
        this.morseCode = morseCode;
        this.left = null;
        this.right = null;
    }

    //? GETTERS & SETTERS

    public char getLetter()                     { return letter; }
    public Node getLeft()                       { return left; }
    public Node getRight()                      { return right; }
    public String getMorseCode()                { return morseCode; }
    public void setLetter(char letter)          { this.letter = letter; }
    public void setMorseCode(String morseCode)  { this.morseCode = morseCode; }
    public void setLeft(Node left)              { this.left = left; }
    public void setRight(Node right)            { this.right = right; }


}
