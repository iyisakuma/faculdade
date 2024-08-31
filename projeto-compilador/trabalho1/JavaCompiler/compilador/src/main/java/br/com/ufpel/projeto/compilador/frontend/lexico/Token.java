package br.com.ufpel.projeto.compilador.frontend.lexico;


public record Token (
     String lexema,
     TokenType type){
}
