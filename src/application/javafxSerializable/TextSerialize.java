package application.javafxSerializable;

import java.io.Serializable;
import javafx.scene.text.Text;

public class TextSerialize extends Text implements Serializable{

    public TextSerialize(String text) {
        super(text);
    }

    public TextSerialize(int x, int y, String text) {
        super(x,y,text);
    }
}