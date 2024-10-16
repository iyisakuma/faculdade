package ast;

import java.util.ArrayList;

public class Prog{
    public Main main;
    public ArrayList<Fun> fun;
    public Prog(Main main, ArrayList<Fun> fun)
    {
        this.main = main;
        this.fun = fun;
    }
    @Override
    public String toString() {
        return "package edu.teste;\nimport java.util.Scanner;\npublic class KarloffTeste {\n\n"
        + this.main + (this.fun == null ? "" : "\n" + this.fun.stream().map(Fun::toString).reduce("", (acc, currVal)-> acc + " "+ currVal)) + "\n}\n";//CORRIGIR O toString no fun
    }
}

