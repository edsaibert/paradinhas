package design;

import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Texto extends Text{
    public Texto(String text, double x, double y, String font, int size, Color color) {
        super(text);
        this.setX(x);
        this.setY(y);
        this.setFont(Font.font(font, size));
        this.setFill(color);
    }
}
