package menu;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import java.util.function.Consumer;
import java.stage.Stage;

import javafx.util.*;


public class VisibilityLayoutBuilder implements Builder<Region> {
    Region customComponent2;

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        // results.setTop(new Label("This is The Wrapper"));
        BooleanProperty vBox1Visible = new SimpleBooleanProperty(true);
        Region component1 = new Menu(() -> vBox1Visible.set(false)).build(
            button -> {
                if (button.getText().equals("Iniciar Novo Jogo")) {
                    button.setOnAction(e -> vBox1Visible.set(false));
                } else if (button.getText().equals("Retomar Jogo")) {
                    button.setOnAction(e -> vBox1Visible.set(false));
                } else if (button.getText().equals("Sair")) {
                    button.setOnAction(e -> System.exit(0));
                }
            }
        );
        Region component2 = new Layout2Builder(() -> vBox1Visible.set(true)).build();
        component1.visibleProperty().bind(vBox1Visible);
        component2.visibleProperty().bind(vBox1Visible.not());
        results.setCenter(new StackPane(component1, component2));
        return results;
    }

}
