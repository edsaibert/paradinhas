package menu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.*;

public class Layout2Builder implements Builder<Region> {
    private final Runnable onAction;

    public Layout2Builder(Runnable onAction) {
        this.onAction = onAction;
    }

    @Override
    public Region build() {
        VBox layout2 = new VBox(10); // Vertical box with spacing of 10
        layout2.setAlignment(Pos.CENTER);

        Label label = new Label("This is Layout 2");
        Button button = new Button("Switch to Layout 1");

        // Action when the button is clicked
        button.setOnAction(event -> onAction.run());

        layout2.getChildren().addAll(label, button);
        return layout2;
    }
}

