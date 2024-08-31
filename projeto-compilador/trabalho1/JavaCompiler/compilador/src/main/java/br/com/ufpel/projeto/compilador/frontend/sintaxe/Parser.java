package br.com.ufpel.projeto.compilador.frontend.sintaxe;

import br.com.ufpel.projeto.compilador.frontend.lexico.AnalisadorLexica;
import br.com.ufpel.projeto.compilador.frontend.lexico.Token;
import br.com.ufpel.projeto.compilador.frontend.lexico.TokenType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Parser {
    AnalisadorLexica scanner;


    public ArvoreSintatica parseProg() throws Exception {

        ArvoreSintatica resultado = Exp();
        Token tokenCorrente = scanner.getNextToken();
        if (tokenCorrente.type() != TokenType.EOF)
            throw (new Exception("Estava esperando: EOF"));

        return resultado;

    }

    Exp Exp() throws Exception {
        Exp exp1, exp2;
        Token tokenCorrente = scanner.getNextToken();

        if (tokenCorrente.type() == TokenType.NUM)
            return new Num(Integer.parseInt(tokenCorrente.lexema() + ""));


        if (tokenCorrente.type() == TokenType.APar) {
            exp1 = Exp();
            if (exp1 == null)
                throw (new Exception("Não encontrei expressão!"));

            Operador op = Op();

            if (op == null)
                throw (new Exception("Não encontrei operador!"));

            exp2 = Exp();
            if (exp2 == null)
                throw (new Exception("Não enconrtrei expressão!"));

            op.setArg1(exp1);
            op.setArg2(exp2);
            tokenCorrente = scanner.getNextToken();
            if (tokenCorrente.type() != TokenType.FPar)
                throw (new Exception("Estava esperando:)"));
            return op;

        } else throw (new Exception("Estava esperando: ( ou <NUM>"));

        //return null;

    }

    Operador Op() throws Exception {

        Token tokenCorrente = scanner.getNextToken();
        switch (tokenCorrente.type()) {
            case SOMA:
                return new Soma(null, null);
            case MULT:
                return new Mult(null, null);
            default:
        }
        return null;


    }
}
