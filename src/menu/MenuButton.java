package menu;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;

public class MenuButton extends Button {
    String text;
    ImageView buildIcon;

    public MenuButton(String text) {
    this.text = text;

    Image icon = new Image("menu/assets/coin.png", 50, 50, false, false);
    ImageView buildIcon = new ImageView();

    buildIcon.setImage(icon);
    buildIcon.setVisible(false);

    this.buildIcon = buildIcon;

    buildIcon.setTranslateX(300);
    this.setGraphicTextGap(-50);

    this.setMinWidth(100);
    this.setFont(Font.font("Ubuntu Mono", FontWeight.BOLD, 20));
    this.setText(text);
    this.setGraphic(buildIcon);
   }

   public void observeButton (){
        this.setOnMouseEntered(event -> {
            buildIcon.setVisible(true);
        });

        this.setOnMouseExited(event -> {
            buildIcon.setVisible(false);
        });
   }
}
