package menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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



public class LoadedGameLayout  implements Builder<Region> {
    Tabuleiro t;
    Jogo game;

    public LoadedGameLayout() {
        try {
        this.game = carregaJogo();
        } catch(IOException a) {
            System.out.println("MEUY CUAWETFGAHGY7WHW");
        } catch(ClassNotFoundException b) {
            System.out.println("vofce hgsota de maionaewase4");
        }
        this.t = this.game.tabuleiro;
        System.out.println(game.ocorrendo.getX());
    }

    public Region build(Consumer<GameButton> buttonConfigurator) {
        Pane layout2 = new Pane();
        layout2.setStyle(
                "-fx-background-color:#386682"
        );

        // t.iniciaTabuleiro(4);

        game.roleDados.setTranslateX(300);
        game.roleDados.setTranslateY(300);
        layout2.getChildren().addAll(game.roleDados, game.passeTurno, game.hipotecar, game.melhorar, game.comprar, game.dadosImg.get(0), game.dadosImg.get(1));
            
        for(int i = 0; i < game.numJogadores; i++) {
            layout2.getChildren().add(game.playersFundo.get(i));
            layout2.getChildren().add(game.jogadores.getJogadorById(i).dinheiro);
        }

        t.graficoCasas(1345, 850);
        for(int i = 0;i < 40;i++) {
            System.out.println(t.getImg(i).getX());
            System.out.println(t.get(i).get);
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

    public static Jogo carregaJogo() throws IOException, ClassNotFoundException {
        ObjectInputStream carrega = new ObjectInputStream(new FileInputStream("src/application/Jogo.bin"));

        Jogo game = (Jogo) carrega.readObject();
        return game;
    }
}
