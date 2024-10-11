package ast;

public class RemoveLastCharacter {
    public String RemoveChar(String string) {
        string = string.substring(0, string.length()-1);
        System.out.println("return " + string);
        return string;
    }
}
