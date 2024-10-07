package ast;

import java.util.ArrayList;

public class Main{

	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> coms;
	
	public Main(ArrayList<VarDecl> vars,ArrayList<Comando> coms)
	{
		this.vars = vars;
		this.coms = coms;
	}


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("public static void main(String[] args) {\n");
        for (VarDecl decVar : this.vars) {
            stringBuilder.append(decVar).append("\n");
        }
        return stringBuilder.append(this.coms).append("}\n").toString();
    }
}
