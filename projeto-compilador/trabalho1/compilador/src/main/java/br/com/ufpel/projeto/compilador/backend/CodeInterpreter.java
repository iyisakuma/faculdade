package br.com.ufpel.projeto.compilador.backend;


import br.com.ufpel.projeto.compilador.frontend.sintaxe.ArvoreSintatica;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.Div;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.Mult;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.Num;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.Soma;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.Sub;

public class CodeInterpreter {

    public String geraCodigo(ArvoreSintatica arv)
    {
        return ("Resultado: " + geraCodigo2(arv));
    }
    String geraCodigo2 (ArvoreSintatica arv)
    {

        int result1;
        int result2;
        if (arv instanceof Mult){
            result1 = Integer.valueOf(geraCodigo2(((Mult) arv).getArg1()));
            result2 = Integer.valueOf(geraCodigo2(((Mult) arv).getArg2()));
            return Integer.toString(( result1 * result2));
        }

        if (arv instanceof Soma){
            result1 = Integer.valueOf(geraCodigo2(((Soma) arv).getArg1()));
            result2 = Integer.valueOf(geraCodigo2(((Soma) arv).getArg2()));
            return Integer.toString(( result1 + result2));
        }
        if (arv instanceof Sub){
            result1 = Integer.valueOf(geraCodigo2(((Sub) arv).getArg1()));
            result2 = Integer.valueOf(geraCodigo2(((Sub) arv).getArg2()));
            return Integer.toString(( result1 - result2));
        }

        if (arv instanceof Div){
            result1 = Integer.valueOf(geraCodigo2(((Div) arv).getArg1()));
            result2 = Integer.valueOf(geraCodigo2(((Div) arv).getArg2()));
            return Integer.toString(( result1 / result2));
        }
        if (arv instanceof Num)
            return ((Num) arv).value.toString();

        return "";
    }
}
