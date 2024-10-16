package ast;

import java.util.ArrayList;

public class CChamadaFun extends Comando{
	public int linha;
	public String fun;
	public ArrayList<Exp> args;
	
	public CChamadaFun(int linha,String fun, ArrayList<Exp> args)
	{
	  this.linha = linha;
	  this.fun = fun;
	  this.args = args;
	} 

	@Override
	 public String toString() {
		if (this.args == null || args.isEmpty()) return this.fun + "()";
        return this.fun + "(" + args.stream().map(Exp::toString).reduce("",  (acc, currVal) -> acc + " " +currVal) + ")";
	 }
}
