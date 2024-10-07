package ast;

import java.util.ArrayList;

public class Fun{
	public String nome;
	public ArrayList<ParamFormalFun> params;
	public String retorno;
	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> body;
	
	public Fun(String nome,ArrayList<ParamFormalFun> params, String retorno,ArrayList<VarDecl> vars,ArrayList<Comando> body)
	{
		this.nome = nome;
		this.params = params;
		this.retorno = retorno;
		this.vars = vars;
		this.body = body;
	}

	@Override
     public String toString() {
        StringBuilder stringBuilder = new StringBuilder("public static " + this.retorno + " " + this.nome + "(" +  printParam() + ") {\n");
        for (VarDecl decVar : this.vars) {
            stringBuilder.append(decVar).append("\n");
        }
        stringBuilder
		.append(body
			.stream()
			.map(Comando::toString)
			.reduce("", (acc, cv) -> acc + "\n" + cv))
		.append("}\n");
        return stringBuilder.toString();
    }
	private String printParam(){
		return this.params.stream().map(ParamFormalFun::toString).reduce("", (acc, currVal) -> acc + ", " + currVal);
	}
}
