package menu;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import java.util.function.Consumer;
import javafx.stage.Stage;

import javafx.util.*;

public class VisibilityLayoutBuilder implements Builder<Region> {
    Region customComponent2;

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        // results.setTop(new Label("This is The Wrapper"));
        BooleanProperty vBox1Visible = new SimpleBooleanProperty(true);
        BooleanProperty vBox2Visible = new SimpleBooleanProperty(false);

        Region component1 = new MenuLayout(() -> {
            vBox1Visible.set(false);
            vBox2Visible.set(true);
        }).build(button -> {
            if (button.getText().equals("Iniciar Novo Jogo")) {
                button.setOnAction(e -> vBox1Visible.set(false));
            } else if (button.getText().equals("Retomar Jogo")) {
                button.setOnAction(e -> vBox1Visible.set(false));
            } else if (button.getText().equals("Sair")) {
                button.setOnAction(e -> System.exit(0));
            }
        });

        Region component2 = new GameLayout(() -> {
            vBox1Visible.set(true);
            vBox2Visible.set(false);
        }).build(button -> {
            if (button.getText().equals("Menu")) {
                button.setOnAction(e -> vBox2Visible.set(true));
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
                    } else if (button.getText().equals("Salvar e Sair") || button.getText().equals("Sair")) {
                        button.setOnAction(e -> {
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

}
