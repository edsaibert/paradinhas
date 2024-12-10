package application.javafxSerializable;

import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewSerialize extends ImageView implements Serializable{
    
    public ImageViewSerialize() {
        super();
    }

    public ImageViewSerialize(Image img) {
        super(img);
    }

}