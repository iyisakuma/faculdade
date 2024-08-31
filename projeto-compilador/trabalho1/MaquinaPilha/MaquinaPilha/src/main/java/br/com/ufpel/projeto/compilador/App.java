package br.com.ufpel.projeto.compilador;

import java.net.URL;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            URL resource = App.class.getClassLoader().getResource("ex1");
            MaquinaPilha maquinaPilha = new MaquinaPilha();
            maquinaPilha.init(resource.getPath());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
