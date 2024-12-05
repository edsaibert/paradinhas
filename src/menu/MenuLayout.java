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

import design.MenuButton;
import javafx.util.*;



public class MenuLayout implements Builder<Region> {
    private final Runnable onAction;

    public MenuLayout(Runnable onAction) {
        this.onAction = onAction;
    }

    public Region build(Consumer<MenuButton> buttonConfigurator) {
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

        MenuButton buttonNovoJogo = new MenuButton("Iniciar Novo Jogo");
        MenuButton buttonRetomarJogo = new MenuButton("Retomar Jogo");
        MenuButton buttonFechar = new MenuButton("Sair");

        buttonConfigurator.accept(buttonNovoJogo);
        buttonConfigurator.accept(buttonRetomarJogo);
        buttonConfigurator.accept(buttonFechar);

        buttonNovoJogo.observeButton();
        buttonRetomarJogo.observeButton();
        buttonFechar.observeButton();

        buttonNovoJogo.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");
        buttonRetomarJogo.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");
        buttonFechar.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");

        layout1.setSpacing(20);
        layout1.getChildren().addAll(buildLogo, buttonNovoJogo, buttonRetomarJogo, buttonFechar);
        return layout1;
    }
}