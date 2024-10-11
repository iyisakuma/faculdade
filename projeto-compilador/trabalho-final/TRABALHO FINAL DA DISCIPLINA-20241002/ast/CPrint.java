package ast;


public class CPrint extends Comando{
	public int linha;
	public Exp exp;
	public RemoveLastCharacter r = new RemoveLastCharacter();
	
	
	public CPrint(int linha,Exp exp)
	{
	  this.linha = linha;
	  this.exp = exp;
	  
	} 

	@Override
    public String toString() {
        return "System.out.println(" + r.RemoveChar(this.exp.toString()) + ");";
    }

}
