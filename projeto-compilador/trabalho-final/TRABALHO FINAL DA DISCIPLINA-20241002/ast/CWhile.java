package ast;

import java.util.ArrayList;

public class CWhile extends Comando{
	public int linha;
	public Exp exp;
	public ArrayList<Comando> bloco;
	public CWhile(int linha,Exp exp, ArrayList<Comando> bloco)
	{
	  this.linha = linha;
	  this.exp = exp;
	  this.bloco = bloco;
	} 

	@Override
    public String toString() {
	return "while (" + this.exp.toString()+ ") {\n" + this.bloco.stream().map(Comando::toString).reduce("", (acc, currVal) -> acc + "\n" + currVal) + "}";
    }
}
