package monopoly;

import java.awt.*;
import javax.swing.*;


//FALTA OS METODOS DE INTERFACE
public class players {
    int posicao = 0;
    int id;
    int carteira = 0;

    public void somaCarteira(int valor) {
        carteira += valor;
    }
    
    public int getCarteira() {
        return carteira;
    }

    public int getId() {
        return id;
    }

    //GUARDAREMOS A POSICAO DO PLAYER DENTRO DA CLASSE PLAYER, INCLUINDO SOMAR
    //VALORES NA CARTEIRA DO PLAYER E MOVER O PERSONAGEM, AS INTERACOES SERAO
    //MERAMENTE CODIGO, SEM/COM POUCOS PONTEIROS
    public void setPosicao(int resultadoDado) {
        posicao += resultadoDado;
        if(posicao > 19) {
            System.out.println("DIA DO PAGAMENTO!!!");
            somaCarteira(200);
            posicao = posicao % 20;
        }
    }

    public int getPosicao() {
        return posicao;
    }

    //CONSTRUTOR DE PLAYER
    public players(int ide) {
        id = ide;
        somaCarteira(2000);
    }
}
