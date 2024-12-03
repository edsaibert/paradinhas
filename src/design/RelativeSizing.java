package design;

import javafx.stage.Stage;

/*
 * Classe para facilitar o dimensionamento relativo de elementos, baseado em vh e vw
 * vh = 1% da altura da tela * size
 * vw = 1% da largura da tela * size
 */

public class RelativeSizing {
    protected double sizeX;
    protected double sizeY;

    public void setSize(double sizeX, double sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public double getVw(Stage stage) {
        double onePercent = stage.getWidth() / 100;
        return onePercent * sizeX;
    }

    public double getVh(Stage stage) {
        double onePercent = stage.getHeight() / 100;
        return onePercent * sizeY;
    }

}
