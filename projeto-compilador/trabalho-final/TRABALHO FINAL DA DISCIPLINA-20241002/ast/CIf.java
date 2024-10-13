package ast;

import java.util.ArrayList;

public class CIf extends Comando{
	public int linha;
	public Exp exp;
	public ArrayList<Comando> bloco;
	public CIf(int linha,Exp exp, ArrayList<Comando> bloco)
	{
	  this.linha = linha;
	  this.exp = exp;
	  this.bloco = bloco;
	} 

	@Override
    public String toString() {
        return "if (" + this.exp.toString().replace(";", "") + ") {\n" + this.bloco.stream().map(Comando::toString).reduce("", (acc, currval) -> acc + "\n"+ currval) + "}";
    }

}
