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
import javafx.scene.layout.Region;

import menu.*;

import jogador.*;


public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Olá Mundo");

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        VisibilityLayoutBuilder layoutBuilder = new VisibilityLayoutBuilder();
        Region root = layoutBuilder.build();

        // Create the scene
        Scene scene = new Scene(root, 1280, 720);
        scene.setFill(new Color(0.6, 0.6, 0.6, 1.0));
        
        stage.setFullScreen(true);
        setStageSize(stage, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
       
        stage.setTitle("MonoPolitecnico");
        stage.setScene(scene);
        stage.show();
    }

    public void setStageSize(Stage stage, double width, double height) {
        stage.setWidth(width);
        stage.setHeight(height);
    }
}
