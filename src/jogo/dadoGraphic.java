package jogo;

import java.io.Serializable;
import java.util.Random;
import javafx.scene.image.Image;


class dados{
    
    Random rnd = new Random();
    int valor = 5;

    public void rolaDado() { valor = rnd.nextInt(6) + 1; }

    public int valorDado() { return valor; }
}

public class dadoGraphic extends dados implements Serializable{
    String img = ("application/assets/dados/dado5.png");

    public Image getImg() { return new Image(img, 100, 100, false, false); }

    public void setaImagem(){ img = ("application/assets/dados/dado"+ this.valorDado() + ".png"); }

}
