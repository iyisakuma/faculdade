package br.com.ufpel.projeto.compilador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class MaquinaPilha {

    private Stack<Integer> stack = new Stack<>();
    private BufferedReader arquivo;


    public void init(String file) throws IOException {
        this.arquivo = new BufferedReader(new FileReader(file));
        String linha;

        while ((linha = arquivo.readLine()) != null) {
            if (linha.contains("PUSH")) {
                Integer valor = Integer.valueOf(linha.split(" ")[1]);
                stack.push(valor);
            } else {
                Op.valueOf(linha).exec(this.stack);
            }
        }
    }

    public void finish() throws IOException {
        if (arquivo != null) {
            arquivo.close();
        }
    }
}

