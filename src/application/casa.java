package application;

import javafx.scene.shape.Rectangle;

public class casa {
    Rectangle cabeca = new Rectangle();
    int posi;
    int tipo;
    int valorCompra;
    int valorAluguel;
    int idDono = 0;
    int categoria = 0;

    public int posicao() {
        return posi;
    }

    public int comprar() {
        return valorCompra;
    }

    public int alugar() {
        return valorAluguel;
    }

    public int queTipo() {
        return tipo;
    }

    public int quemDono() {
        return idDono;
    }

    public int queCat() {
        return categoria;
    }

    public casa(int pos, int type, int pCom, int pAl) {
        this.posi = pos;
        this.tipo = type;
        this.valorCompra = pCom;
        this.valorAluguel = pAl;
    }
    
    public void printaCasa() {
    }
}
