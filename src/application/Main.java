package application;

/*
 * Começando o contâiner de aplicação JavaFX (Stage e Scene)
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import jogador.*;
import casa.*;
import design.*;
import jogo.*;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Olá Mundo");

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //INICIA OS DADOS E SUAS IMAGENS
        Tabuleiro t = new Tabuleiro();
        t.iniciaTabuleiro(6);
        Group root = new Group();

        for(int i = 0;i < 40;i++) {
            root.getChildren().add(t.getImg(i));
        }
        Scene scene = new Scene(root, new Color(0.6, 0.6, 0.6, 1.0));
        RelativeSizing rs = new RelativeSizing();
        
        Image icon = new Image("file:src/application/assets/icone.png");
        stage.getIcons().add(icon);
        
        stage.setFullScreen(true);
        setStageSize(stage, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
        rs.setSize(50, 50);


        Jogo game = new Jogo(4);
        root.getChildren().add(game.roleDados);
        root.getChildren().add(game.passeTurno);
        root.getChildren().add(game.hipotecar);
        root.getChildren().add(game.melhorar);
        root.getChildren().add(game.comprar);
        root.getChildren().add(game.dadosImg.get(0));
        root.getChildren().add(game.dadosImg.get(1));
        for(int i = 0; i < 4; i++)
            root.getChildren().add(game.jogadores.getJogadorById(i).dinheiro);
        stage.setTitle("MonoPolitecnico");
        stage.setScene(scene);
        stage.show();
    }

    public void setStageSize(Stage stage, double width, double height) {
        stage.setWidth(width);
        stage.setHeight(height);
    }
}
