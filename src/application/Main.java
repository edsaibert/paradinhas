package application;

/*
 * Começando o contâiner de aplicação JavaFX (Stage e Scene)
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.Group;

import design.Texto;
import design.RelativeSizing;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Olá Mundo");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, new Color(0.9, 0.9, 0.9, 1.0));
        RelativeSizing rs = new RelativeSizing();
        
        Image icon = new Image("file:src/application/assets/icone.png");
        stage.getIcons().add(icon);
        
        stage.setFullScreen(true);
        setStageSize(stage, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
        
        rs.setSize(50, 50);
        Texto text = new Texto("Olá Mundo", rs.getVw(stage), rs.getVh(stage), "Arial", 30, new Color(0.1, 0.1, 0.1, 1.0));
        root.getChildren().add(text);

        stage.setTitle("MonoPolitecnico");
        stage.setScene(scene);
        stage.show();
    }

    public void setStageSize(Stage stage, double width, double height) {
        stage.setWidth(width);
        stage.setHeight(height);
    }
}
