package design;
import java.io.Serializable;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameButton extends Button implements Serializable{
    String text;

    public GameButton(String text, int x, int y) {
    this.text = text;

    this.setMinWidth(100);

    this.setLayoutX(x);
    this.setLayoutY(y);

    this.setFont(Font.font("Ubuntu Mono", FontWeight.BOLD, 20));
    this.setText(text);

    this.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");
   }
}
