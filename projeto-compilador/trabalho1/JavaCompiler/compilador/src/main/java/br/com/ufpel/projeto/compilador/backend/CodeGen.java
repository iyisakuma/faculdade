package br.com.ufpel.projeto.compilador.backend;

import br.com.ufpel.projeto.compilador.frontend.sintaxe.ArvoreSintatica;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.Mult;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.Num;
import br.com.ufpel.projeto.compilador.frontend.sintaxe.Soma;

public class CodeGen {


    public String geraCodigo(ArvoreSintatica arv)
    {
        return (geraCodigo2(arv) + "PRINT");
    }
    String geraCodigo2 (ArvoreSintatica arv)
    {

        if (arv instanceof Mult)
            return (geraCodigo2(((Mult) arv).getArg1()) +
                    geraCodigo2(((Mult) arv).getArg2()) +
                    "MULT\n");

        if (arv instanceof Soma)
            return (geraCodigo2(((Soma) arv).getArg1()) +
                    geraCodigo2(((Soma) arv).getArg2()) +
                    "SUM\n");

        if (arv instanceof Num)
            return ("PUSH "  + ((Num) arv).value + "\n");

        return "";
    }
}
