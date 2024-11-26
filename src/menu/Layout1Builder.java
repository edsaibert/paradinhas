package menu;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.function.Consumer;

import javafx.util.*;



public class Layout1Builder implements Builder<Region> {
    private final Runnable onAction;

    public Layout1Builder(Runnable onAction) {
        this.onAction = onAction;
    }

    public Region build(Consumer<Button> buttonConfigurator) {
        VBox layout1 = new VBox(10); // Vertical box with spacing of 10
        layout1.setAlignment(Pos.CENTER);

        /*
         * Título
         */
        Image logo = new Image("menu/assets/monopolitecnico.png", 900, 100, false, false);
        ImageView buildLogo = new ImageView();
        buildLogo.setImage(logo); 

            // Adiciona imagem de fundo
        layout1.setStyle(
                "-fx-background-image: url('menu/assets/background.jpg');" +
                        "-fx-background-size: cover;" + // Ajusta a imagem para cobrir toda a região
                        "-fx-background-position: center;" // Centraliza a imagem
        );


        Button buttonNovoJogo = new Button("Iniciar Novo Jogo");
        buttonNovoJogo.setFont(Font.font("Ubuntu Mono", FontWeight.BOLD, 20));

        Button buttonRetomarJogo = new Button("Retomar Jogo");
        buttonRetomarJogo.setFont(Font.font("Ubuntu Mono", FontWeight.BOLD, 20));

        Button buttonFechar = new Button("Sair");
        buttonFechar.setFont(Font.font("Ubunto Mono", FontWeight.BOLD, 18));

        // Action when the button is clicked
        // buttonNovoJogo.setOnAction(event -> onAction.run());
        // buttonRetomarJogo.setOnAction(event -> onAction.run());
        // buttonFechar.setOnAction(event -> onAction.run());

        buttonConfigurator.accept(buttonNovoJogo);
        buttonConfigurator.accept(buttonRetomarJogo);
        buttonConfigurator.accept(buttonFechar);

        buttonNovoJogo.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");
        buttonRetomarJogo.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");
        buttonFechar.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");

        layout1.setSpacing(20);
        layout1.getChildren().addAll(buildLogo, buttonNovoJogo, buttonRetomarJogo, buttonFechar);
        return layout1;
    }
}