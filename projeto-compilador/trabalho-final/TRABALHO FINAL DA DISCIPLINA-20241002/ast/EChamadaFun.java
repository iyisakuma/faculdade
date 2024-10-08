package ast;

import java.util.ArrayList;

public class EChamadaFun extends Exp{
	public String fun;
	public ArrayList<Exp> args;
	
	public EChamadaFun(String fun, ArrayList<Exp> args)
	{
	  this.fun = fun;
	  this.args = args;
	} 

   	 @Override
	 public String toString() {
		if (this.args == null) return this.fun + "();";
        return this.fun + "(" + args.stream().map(Exp::toString).reduce("",  (acc, currVal) -> acc + " "+currVal) + ");";
	 }
}
