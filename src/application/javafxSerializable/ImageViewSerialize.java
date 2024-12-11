package application.javafxSerializable;

import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewSerialize extends ImageView implements Serializable{
    public int x;
    public int y;
    // public String img;
    public Boolean visible;
    
    public ImageViewSerialize() {
        super();
    }

    public ImageViewSerialize(Image img) {
        super(img);
    }

    public void setAll(){
        this.x = (int) this.getX();
        this.y = (int) this.getY();
        // this.img = this.getImage().impl_getUrl();
        this.visible = this.isVisible();
    }

}