package br.com.ufpel.projeto.compilador.frontend.sintaxe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Operador extends Exp{
    private Exp arg1, arg2;
}
