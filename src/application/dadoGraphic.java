package application;

import java.util.Random;
import javafx.scene.image.Image;


class dados{
    
    Random rnd = new Random();
    int valor = 5;

    public void rolaDado() { valor = rnd.nextInt(6) + 1; }

    public int valorDado() { return valor; }
}

public class dadoGraphic extends dados{
    Image img = new Image("application/assets/dados/dado5.png", 100, 100, false, false);

    public Image getImg() { return img; }

    public void setaImagem(){ img = new Image("application/assets/dados/dado"+ this.valorDado() + ".png", 100, 100, false, false); }
}
