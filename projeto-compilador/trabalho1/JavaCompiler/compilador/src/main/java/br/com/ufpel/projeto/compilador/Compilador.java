package br.com.ufpel.projeto.compilador;

import br.com.ufpel.projeto.compilador.backend.CodeGen;
import br.com.ufpel.projeto.compilador.frontend.lexico.AnalisadorLexica;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.ArvoreSintatica;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.Parser;

import java.net.URL;

class Compilador {

    public static void main(String[] args) {
        ArvoreSintatica arvoreSintatica = null;

        try {
            URL resource = Compilador.class.getClassLoader().getResource("teste");
            //AnalisadorLexico
            var analisadorLexico = new AnalisadorLexica(resource.getPath());

            //Analisador Sintático
            var parser = new Parser(analisadorLexico);

            arvoreSintatica = parser.parseProg();

            var codeGen = new CodeGen();
            String codigo = codeGen.geraCodigo(arvoreSintatica);
            System.out.println(codigo);

        } catch (Exception e) {
            System.out.println("Erro de compilação:\n" + e);
        }


    }
}
