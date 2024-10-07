package ast;

public class VarDecl{
   public String type;
   public String var;
   
   public VarDecl(String type,String var){
   	this.type = type;
   	this.var = var;
   }


   @Override
   public String toString() {
       if (this.type != null && this.var != null)
           return this.type + " " + this.var + ";";
       else
           return "";
   }
}
