package application.javafxSerializable;

import java.io.Serializable;

import javafx.scene.shape.Rectangle;

public class RectangleSerialize extends Rectangle implements Serializable{
    public int x;
    public int y;
    public int width;
    public int height;
    
    public RectangleSerialize() {
        super();
    }

    public void setAll(){
        this.x = (int) this.getX();
        this.y = (int) this.getY();
        this.width = (int) this.getWidth();
        this.height = (int) this.getHeight();

        System.out.println("X: " + this.x + " Y: " + this.y + " Width: " + this.width + " Height: " + this.height);
    }
}
