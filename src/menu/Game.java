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

import jogador.*;
import casa.*;
import design.*;
import jogo.*;
import javafx.util.*;



public class Game implements Builder<Region> {
    private final Runnable onAction;

    public Game(Runnable onAction) {
        this.onAction = onAction;
    }

    public Region build() {
        VBox layout1 = new VBox(10); // Vertical box with spacing of 10
        layout1.setAlignment(Pos.CENTER);

        Tabuleiro t = new Tabuleiro();
        t.iniciaTabuleiro(6);
        // Group root = new Group();

        for(int i = 0;i < 40;i++) {
            layout1.getChildren().add(t.getImg(i));
        }
        // Scene scene = new Scene(root, new Color(0.6, 0.6, 0.6, 1.0));
        RelativeSizing rs = new RelativeSizing();
        
        // Image icon = new Image("file:src/application/assets/icone.png");
        // stage.getIcons().add(icon);
        
        // stage.setFullScreen(true);
        // setStageSize(stage, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
        // rs.setSize(50, 50);


        Jogo game = new Jogo(2);
        layout1.getChildren().addAll(game.roleDados, game.passeTurno, game.hipotecar, game.melhorar, game.comprar, game.dadosImg.get(0), game.dadosImg.get(1));

        for(int i = 0; i < 2; i++) {
            layout1.getChildren().add(game.playersFundo.get(i));
            layout1.getChildren().add(game.jogadores.getJogadorById(i).dinheiro);
        }

        layout1.setSpacing(20);
        return layout1;
    }
}