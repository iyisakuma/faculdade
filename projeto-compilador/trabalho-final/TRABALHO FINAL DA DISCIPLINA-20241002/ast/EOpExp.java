package ast;


public class EOpExp extends Exp{
	public String op;
	public Exp arg1;
	public Exp arg2;
	public RemoveLastCharacter r = new RemoveLastCharacter();
	
	
	public EOpExp(String op, Exp arg1, Exp arg2)
	{
	  this.op = op;
	  this.arg1 = arg1;
	  this.arg2 = arg2;
	  
	} 

	@Override
	public String toString() {
		return r.RemoveChar(arg1.toString()) + " " + op + " " + r.RemoveChar(arg2.toString());
	}
}
