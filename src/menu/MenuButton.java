package menu;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuButton {
    String text;
    ImageView buildIcon;

    public MenuButton(String text) {
    this.text = text;
   }

   public Button createButton (){
        Image icon = new Image("menu/assets/coin.png", 100, 100, false, false);
        ImageView buildIcon = new ImageView();
        buildIcon.setImage(icon);
        buildIcon.setVisible(false);
        this.buildIcon = buildIcon;

        Button button = new Button(text);
        button.setFont(Font.font("Ubuntu Mono", FontWeight.BOLD, 20));
        button.setGraphic(buildIcon);

        return button;
   }

   public void observeButton (Button button){
        button.setOnMouseEntered(event -> {
            buildIcon.setVisible(true);
        });

        button.setOnMouseExited(event -> {
            buildIcon.setVisible(false);
        });
   }
}
