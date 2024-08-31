package br.com.ufpel.projeto.compilador.frontend.lexico;

import java.io.BufferedReader;
import java.io.FileReader;

public class AnalisadorLexica {
    private BufferedReader arquivo;

    public AnalisadorLexica(String file) throws Exception {
        this.arquivo = new BufferedReader(new FileReader(file));

    }

    public Token getNextToken() throws Exception {
        String lexema = "";
        int eof = -1;
        char currchar;
        int currchar1;

        do {
            currchar1 = arquivo.read();
            currchar = (char) currchar1;
            if (Character.isDigit(currchar)) {
                lexema = String.valueOf(currchar);
                while (true) {
                    arquivo.mark(0);
                    currchar1 = arquivo.read();
                    currchar = (char) currchar1;
                    if (Character.isDigit(currchar)) {
                        lexema += String.valueOf(currchar);
                    } else {
                        arquivo.reset();
                        break;
                    }
                }
            } else {
                lexema = String.valueOf(currchar);
            }
        } while (lexema.equals("\n") || lexema.equals(" ") || lexema.equals("\t") || lexema.equals("\r"));

        if (!lexema.getBytes().equals(eof) && !lexema.getBytes().equals(10)) {
            try {
                Integer.valueOf(lexema);
                return new Token(lexema, TokenType.NUM);
            } catch (Exception ex) {
                switch (lexema) {
                    case "(":
                        return (new Token(lexema, TokenType.APar));
                    case ")":
                        return (new Token(lexema, TokenType.FPar));
                    case "+":
                        return (new Token(lexema, TokenType.SOMA));
                    case "*":
                        return (new Token(lexema, TokenType.MULT));
                    case "-":
                        return (new Token(lexema, TokenType.SUB));
                    case "/":
                        return (new Token(lexema, TokenType.DIV));
                }
            }
        }

        arquivo.close();

        return (new Token(String.valueOf(currchar), TokenType.EOF));

    }
}
