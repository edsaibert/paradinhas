package application;

/*
 * Começando o contâiner de aplicação JavaFX (Stage e Scene)
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import design.Texto;
// import javafx.geometry.*;

public class Main extends Application {
    public static void main(String[] args){
        System.out.println("Olá Mundo");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, new Color(0.9, 0.9, 0.9, 1.0));

        Image icon = new Image("file:src/application/assets/icone.png"); 
        stage.getIcons().add(icon);

        // Rectangle2D screenBounds = javafx.stage.Screen.getPrimary().getVisualBounds();
        // double screenWidth = screenBounds.getWidth();
        // double screenHeight = screenBounds.getHeight();

        stage.setWidth(1000);
        stage.setHeight(700);
        // stage.setResizable(false);
        stage.setFullScreen(true);
        // stage.setFullScreenExitHint("Pressione ESC para sair do modo de tela cheia");

        Texto text = new Texto("Olá Mundo", 100, 100, "Arial", 30, new Color(0.1, 0.1, 0.1, 1.0));

        root.getChildren().add(text);
       
        stage.setTitle("MonoPolitecnico");
        stage.setScene(scene);
        stage.show();
    }
}
