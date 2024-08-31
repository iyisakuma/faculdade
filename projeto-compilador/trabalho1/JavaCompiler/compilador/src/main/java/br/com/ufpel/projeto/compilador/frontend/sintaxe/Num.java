package br.com.ufpel.projeto.compilador.frontend.sintaxe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Num extends Exp{
    public int value;

}
