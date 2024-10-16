import monopoly.dados;
import monopoly.casas;
import monopoly.players;
import java.awt.*;
import javax.swing.*;

//ME PERGUNTEM DIRETAMENTE EM CASO DE ALGUMA DUVIDA NO CODIGO OU NA COMPILACAO

//RESTA QUASE TUDO :D
//SENDO USADO APENAS PARA TESTAR A FUNCIONALIDADE DO RESTANTE DAS CLASSES
public class MonopolyMain {
    public static void main(String args[]) {
        dados d = new dados();
        d.rolaDado();
        System.out.println(d.valorDado());

        casas c = new casas(123, 6969, "NOMELEGAL");
        System.out.println(c.getCompra());
        System.out.println(c.getAluguel());
        System.out.println(c.getNome());

        players p = new players(1);
        System.out.println(p.getCarteira());
        p.somaCarteira(4);
        System.out.println(p.getCarteira());
        System.out.println(p.getId());
        System.out.println(p.getPosicao());
        d.rolaDado();
        p.setPosicao(d.valorDado()); 
        System.out.println(p.getPosicao());
        System.out.println(p.getCarteira());
    }
}
