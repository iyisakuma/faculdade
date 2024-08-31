package br.com.ufpel.projeto.compilador;

import java.util.Stack;

public enum Op {
    SOMA {
        @Override
        public void exec(Stack<Integer> stack) {
            Integer arg1 = stack.pop();
            Integer arg2 = stack.pop();
            stack.push(arg1 + arg2);

        }
    }, MULT {
        @Override
        public void exec(Stack<Integer> stack) {
            Integer arg1 = stack.pop();
            Integer arg2 = stack.pop();
            stack.push(arg1 * arg2);
        }
    }, SUB {
        @Override
        public void exec(Stack<Integer> stack) {
            Integer arg1 = stack.pop();
            Integer arg2 = stack.pop();
            stack.push(arg2 - arg1);
        }
    }, DIV {
        @Override
        public void exec(Stack<Integer> stack) {
            Integer arg1 = stack.pop();
            Integer arg2 = stack.pop();
            stack.push(arg2 / arg1);
        }
    },
    PRINT{
        @Override
        public void exec(Stack<Integer> stack) {
            Integer arg1 = stack.pop();
            System.out.println(arg1);
        }
    };


    public abstract  void exec(Stack<Integer> stack);
}
