package application;

/*
 * Começando o contâiner de aplicação JavaFX (Stage e Scene)
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.scene.paint.Color;
import javafx.scene.layout.Region;
import javafx.scene.input.KeyCode;

import menu.*;

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
        
        scene.setOnKeyPressed(event -> {
            // fullscreen quando 'F' é apertado
            if (event.getCode() == KeyCode.F) {
                stage.setFullScreen(!stage.isFullScreen());
            }
        });
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
