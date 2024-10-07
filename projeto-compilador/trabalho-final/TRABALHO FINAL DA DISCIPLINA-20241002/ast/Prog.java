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
        return "package org.test;\nimport java.util.Scanner;\npublic class KarloffTeste {\n\n"
        + this.main + (this.fun == null ? "" : "\n" + this.fun) + "\n}\n";
    }
}

