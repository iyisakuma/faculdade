package ast;


public class CReadInput extends Comando{
	public int linha;
	public String var;
	private static int counter = 0;
	
	public CReadInput(int linha,String var)
	{
	  this.linha = linha;
	  this.var = var;
	} 

	@Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (counter == 0) stringBuilder.append("Scanner scan = new Scanner(System.in);\n");
        stringBuilder.append(var).append(" = scan.nextInt();\nscan.nextLine();\n");
        counter++;
        return stringBuilder.toString();
    }
}
