package monopoly;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

//FALTA OS METODOS DE INTERFACE
//CLASSE DESCOMPLICADA, BASICAMENTE PRONTA
public class dados{
    
    Random rnd = new Random();
    int valor = 1;

    public void rolaDado() {
        valor = rnd.nextInt(6) + 1;
    }

    public int valorDado() {
        return valor;
    }
}


