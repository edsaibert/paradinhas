package application;

import java.util.Random;
import javafx.scene.image.Image;


//CLASSE APENAS PARA GERAÇÃO DE NUMERO ALEATORIO
class dados{
    
    Random rnd = new Random();
    int valor = 1;

    public void rolaDado() {
        valor = rnd.nextInt(6) + 1;
    }

    public int valorDado() {
        return valor;
    }
}

//CLASSE QUE REPRESENTA GRAFICAMENTE O DADO NA TELA
public class dadoGraphic extends dados{
    Image val = new Image("src/application/assets/dado1.png", 100, 100, false, false);

    public Image valor() {
        return val;
    }

    public void setaImagem(){
        switch(this.valorDado()) {
            case 1: 
                val = new Image("src/application/assets/dado1.png", 100, 100, false, false);
                break;
            case 2:
                val = new Image("src/application/assets/dado2.png", 100, 100, false, false);
                break;
            case 3:
                val = new Image("src/application/assets/dado3.png", 100, 100, false, false);
                break;
            case 4:
                val = new Image("src/application/assets/dado4.png", 100, 100, false, false);
                break;
            case 5:
                val = new Image("src/application/assets/dado5.png", 100, 100, false, false);
                break;
            case 6:
                val = new Image("src/application/assets/dado6.png", 100, 100, false, false);
                break;
        }
    }
}
