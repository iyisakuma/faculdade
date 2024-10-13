package ast;

import java.util.ArrayList;
import java.util.Iterator;

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
		else if(args.size() == 1) return this.fun + "(" + args.get(0) + ")";
		String argString = "";
		Iterator<Exp> iterator = args.iterator();
		while (iterator.hasNext()) {
			argString += iterator.next().toString();
			if (iterator.hasNext()) {
				argString += " , ";
			}
		}
        return this.fun + "(" + argString +  ");";
	 }
}
