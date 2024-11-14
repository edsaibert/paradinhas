package application;


import javafx.scene.image.Image;

public class casa {
    Image house = new Image("src/application/assets/dado1.png", 100, 100, false, false);
    int posi;
    int tipo;
    int valorCompra;
    int valorAluguel;
    int idDono = 0;
    int categoria = 0;

    public Image haus() {
        return house;
    }
    
    public void atualizaImg(Image img) {
        house = img;
    }

    public int posicao() {
        return posi;
    }

    public int comprar() {
        return valorCompra;
    }

    public void atualizaCompra(int val) {
        valorCompra = val;
    }

    public int alugar() {
        return valorAluguel;
    }

    public void atualizaAluguel(int val) {
        valorAluguel = val;
    }

    public int queTipo() {
        return tipo;
    }

    public int quemDono() {
        return idDono;
    }

    public void atualizaDono(int val) {
        idDono = val;
    }

    public int queCat() {
        return categoria;
    }

    public casa(int pos, int type, int pCom, int pAl) {
        posi = pos;
        tipo = type;
        valorCompra = pCom;
        valorAluguel = pAl;
    }
    
    //FUNCAO A TERMINAR, IMPLEMENTAÇÃO DEPENDE DE OUTRAS CLASSES
    public void acaoCasa(/*Player pd*/) {
        switch(this.queTipo()) {
            case 1:
                /*if(this.quemDono() == 0 && pd.carteira() >= this.comprar())
                    CÓDIGO PARA COMPRAR PROPRIEDADE*/
                /*else if(this.quemDono() != pd.id())
                    CÓDIGO PARA COBRAR ALUGUEL*/
                /*else if(this.quemDono() == pd.id())
                    CÓDIGO PARA MELHORAR CASA*/
                /*else
                    CÓDIGO PARA PRINTAR QUE NAO TEM DINHEIRO*/
                break;
            case 2:
                /*CÓDIGO PARA CARTA */
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
