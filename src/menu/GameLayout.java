package menu;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import application.javafxSerializable.ImageViewSerialize;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.function.Consumer;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

import javafx.event.EventHandler;
import javafx.stage.Screen;


import jogador.*;
import casa.*;
import design.*;
import jogo.*;
import javafx.util.*;



public class GameLayout implements Builder<Region> {
    // private final Runnable onAction;
    Tabuleiro t;
    Jogo game;

    public GameLayout(Tabuleiro t, Jogo game) {
        // this.onAction = onAction;
        this.t = t;
        this.game = game;
    }

    public Region build(Consumer<GameButton> buttonConfigurator) {
        Pane layout2 = new Pane();
        layout2.setStyle(
                "-fx-background-color:#386682"
        );

        // t.iniciaTabuleiro(4);

        layout2.getChildren().addAll(game.roleDados, game.passeTurno, game.hipotecar, game.melhorar, game.comprar, game.dadosImg.get(0), game.dadosImg.get(1));
            
        for(int i = 0; i < game.numJogadores; i++) {
            layout2.getChildren().add(game.playersFundo.get(i));
            layout2.getChildren().add(game.jogadores.getJogadorById(i).dinheiro);
        }

        for(int i = 0;i < 40;i++) {
            layout2.getChildren().add(t.getImg(i));
            layout2.getChildren().add(t.getSeta(i));
        }

        layout2.getChildren().add(game.ocorrendo);

        // Desenha os players
        layout2.getChildren().addAll(game.jogadores.desenharJogadores());
        // Indica quem está jogando
        layout2.getChildren().addAll(game.jogadores.desenharQuemJogando());

        GameButton teste = new GameButton("Menu", (int) Screen.getPrimary().getVisualBounds().getWidth() - 110, 10);
        buttonConfigurator.accept(teste);

        layout2.getChildren().add(teste);

        return layout2;
    }
}