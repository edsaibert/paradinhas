package application;


import javafx.scene.image.Image;

public class casa {
    Image house = new Image("src/application/assets/dado1.png", 100, 100, false, false);
    String nome;
    int posi;
    int tipo;
    int valorCompra;
    int valorAluguel;
    int idDono = 0;
    int categoria = 0;
    boolean pago = false;
    boolean hipotecado = false;

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

    public void aumentaAluguel(int val) {
        valorAluguel += val;
    }

    //o "tipo" é 1 quando comprável, 2 para carta aleatoria. Outras ações a decidir
    //pode ser que os tipos da casa tambem falem qual tipo de comprável é, tipo 1 quando é os compraveis verdes, tipo 2 quando for vermelhos etc
    public int queTipo() {
        return tipo;
    }

    public int quemDono() {
        return idDono;
    }

    public String qualNome() {
        return nome;
    }

    public void atualizaDono(int val) {
        idDono = val;
    }

    public void setPago(boolean pay) {
        pago = pay;
    }

    public boolean foiPago() {
        return pago;
    }

    public boolean estaHipotecado() {
        return hipotecado;
    }
    
    public int queCat() {
        return categoria;
    }

    public casa(int pos, int type, int pCom, int pAl, String name) {
        house = new Image("src/application/assets/dado"+1+".png", 70, 100, false, false);
        nome = name;
        posi = pos;
        tipo = type;
        valorCompra = pCom;
        valorAluguel = pAl;
    }
    
    //categoria pode contar também o fato de existir um monopólio naquele tipo
    //de propriedade, entao casas categoria 1 são monopolio, 2 e acima são com casas construidas
    public void melhoraCasa() {
        if(categoria <= 5) {
            categoria++;
            aumentaAluguel(valorAluguel);
        }
    }

    public void hipoteca(/*Jogador pd */) {
        if(hipotecado) {
            if(true/*pd.carteira() >= (valorCompra/2) + (valorCompra/10)*/) {
                hipotecado = false;
                /*DÉBITO DE (valorCompra/2) + (valorCompra/10) DA CARTEIRA DO JOGADOR PD */
            }
        }
        else {
            hipotecado = true;
                /*DEPÓSITO DE (valorCompra/2) DA CARTEIA DO JOGADOR PD */
                /*TROCAR PARA IMAGEM DE "HIPOTECADO" PARA A CASA*/
        }
    }

    //FUNCAO A TERMINAR, IMPLEMENTAÇÃO DEPENDE DE OUTRAS CLASSES
    public void acaoCasa(/*Player pd*/) {
        switch(this.queTipo()) {
            case 1:
                /*if(this.quemDono() == 0 && pd.carteira() >= this.comprar())
                    CÓDIGO PARA COMPRAR PROPRIEDADE*/
                /*else if(this.quemDono() != pd.id())
                    CÓDIGO PARA COBRAR ALUGUEL*/
                /*else if(this.quemDono() == pd.id() && pd.monopoly())
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
