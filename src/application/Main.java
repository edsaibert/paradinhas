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

//import design.*;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Olá Mundo");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //INICIA OS DADOS E SUAS IMAGENS
        dadoGraphic dado1 = new dadoGraphic();
        dado1.rolaDado();
        dado1.setaImagem();
        dadoGraphic dado2 = new dadoGraphic();
        dado2.rolaDado();
        dado2.setaImagem();
        ImageView imgd1 = new ImageView(dado1.valor());
        imgd1.setX(1000);
        imgd1.setY(800);
        ImageView imgd2 = new ImageView(dado2.valor());
        imgd2.setX(1200);
        imgd2.setY(800);
        tabuleiro t = new tabuleiro();
        t.iniciaTabuleiro();

        Group root = new Group(imgd1, imgd2);
        for(int i = 0;i < 40;i++) {
            root.getChildren().add(t.getTodasImg().get(i));
        }
        Scene scene = new Scene(root, new Color(0.6, 0.6, 0.6, 1.0));
        //RelativeSizing rs = new RelativeSizing();
        
        Image icon = new Image("file:src/application/assets/icone.png");
        stage.getIcons().add(icon);
        
        stage.setFullScreen(true);
        setStageSize(stage, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
        //rs.setSize(50, 50);


        /*BOTAO E EVENTOS DE BOTAO, IMPLEMENTADO COMO SE FOSSE UM MÉTODO*/
        Button botaoDado = new Button("Rerole o dado");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {
                dado1.rolaDado();
                dado2.rolaDado();
                dado1.setaImagem();
                dado2.setaImagem(); 
                imgd1.setImage(dado1.valor());
                   imgd2.setImage(dado2.valor());
            } 
        }; 

        botaoDado.setOnAction(event);
        botaoDado.setTranslateX(1100);
        botaoDado.setTranslateY(760);
        root.getChildren().add(botaoDado);
        stage.setTitle("MonoPolitecnico");
        stage.setScene(scene);
        stage.show();
    }

    public void setStageSize(Stage stage, double width, double height) {
        stage.setWidth(width);
        stage.setHeight(height);
    }
}
