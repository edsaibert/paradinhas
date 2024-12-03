package menu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import java.util.function.Consumer;
import javafx.util.*;
import design.*;

public class PauseLayout implements Builder<Region> {
    private final Runnable onAction;

    public PauseLayout(Runnable onAction) {
        this.onAction = onAction;
    }

    public Region build(Consumer<MenuButton> buttonConfigurator) {
        VBox layout2 = new VBox(10); // Vertical box with spacing of 10
        layout2.setAlignment(Pos.CENTER);

        MenuButton buttonRetomarJogo = new MenuButton("Retomar Jogo");
        MenuButton buttonSalvarSair = new MenuButton("Salvar e Sair");
        MenuButton buttonSair = new MenuButton("Sair");

        buttonConfigurator.accept(buttonRetomarJogo);
        buttonConfigurator.accept(buttonSalvarSair);
        buttonConfigurator.accept(buttonSair);

        buttonRetomarJogo.observeButton();
        buttonSalvarSair.observeButton();
        buttonSair.observeButton();
        
        buttonRetomarJogo.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");
        buttonSalvarSair.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");
        buttonSair.setStyle("-fx-background-color: #BDBDBD; -fx-border-color: #FFF; -fx-border-width: 5px;");

        // Action when the button is clicked

        layout2.getChildren().addAll(buttonRetomarJogo, buttonSalvarSair, buttonSair);
        return layout2;
    }
}

