package menu;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.util.*;
import jogador.*;
import casa.*;
import design.*;
import jogo.*;

public class VisibilityLayoutBuilder implements Builder<Region> {
    Region customComponent2;

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        // results.setTop(new Label("This is The Wrapper"));
        BooleanProperty vBox1Visible = new SimpleBooleanProperty(true);
        BooleanProperty vBox2Visible = new SimpleBooleanProperty(false);

        Tabuleiro t = new Tabuleiro();
        // t.iniciaTabuleiro(5);

        Jogo game = new Jogo(6, t);

        JogoWrapper jogo = new JogoWrapper(game);

        Region component1 = new MenuLayout(() -> {
            vBox1Visible.set(false);
            vBox2Visible.set(true);
        }).build(button -> {
            if (button.getText().equals("Iniciar Novo Jogo")) {
                button.setOnAction(e -> vBox1Visible.set(false));
            } else if (button.getText().equals("Retomar Jogo")) {
                button.setOnAction(e -> 
                    {   
                        vBox1Visible.set(false);
                        try {
                            jogo.setGame(carregaJogo());
                        } catch(IOException a) {
                            System.out.println(a.getMessage());
                        } catch(ClassNotFoundException b) {
                            System.out.println(b.getMessage());
                        }
                    }
                );
            } else if (button.getText().equals("Sair")) {
                button.setOnAction(e -> System.exit(0));
            }
        });

        GameLayout layout = new GameLayout(t, jogo.getGame());
        Region component2 = layout.build(button -> {
            if ("Menu".equals(button.getText())) {
                button.setOnAction(e -> {
                    vBox1Visible.set(false);
                    vBox2Visible.set(true);
                });
            }

        });
        Region component3 = new PauseLayout(() -> {
            vBox1Visible.set(false);
            vBox2Visible.set(false);
        }).build(
                button -> {
                    if (button.getText().equals("Retomar Jogo")) {
                        button.setOnAction(e -> {
                            vBox1Visible.set(false); // Ensure MenuLayout stays hidden
                            vBox2Visible.set(false); // Allow GameLayout to show (binding condition)
                        });
                    } else if (button.getText().equals("Salvar e Sair")) {
                        button.setOnAction(e -> {
                            vBox1Visible.set(true); // Show MenuLayout
                            vBox2Visible.set(false); // Hide GameLayout
                            try {
                                salvarJogo(jogo.getGame());
                                
                            } catch(IOException a) {
                                System.out.println(a.getMessage());
                            }
                        });
                    }
                    else {
                        button.setOnAction(e -> {
                            game.resetGame();
                            vBox1Visible.set(true); // Show MenuLayout
                            vBox2Visible.set(false); // Hide GameLayout
                        });
                    }
        
                });

        component1.visibleProperty().bind(vBox1Visible);
        component2.visibleProperty().bind(vBox1Visible.not().and(vBox2Visible.not()));
        component3.visibleProperty().bind(vBox2Visible);

        results.setCenter(new StackPane(component1, component2, component3));

        return results;
    }

    public static void salvarJogo(Jogo jogo) throws IOException {
        ObjectOutputStream salvar = new ObjectOutputStream(new FileOutputStream("src/application/Jogo.bin"));

        salvar.writeObject(jogo);
    }

    public static Jogo carregaJogo() throws IOException, ClassNotFoundException {
        ObjectInputStream carrega = new ObjectInputStream(new FileInputStream("src/application/Jogo.bin"));

        Jogo game = (Jogo) carrega.readObject();
        return game;
    }

}
