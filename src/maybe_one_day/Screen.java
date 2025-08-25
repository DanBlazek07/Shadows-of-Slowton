package maybe_one_day;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Screen extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane pane = new Pane();
        Scene scene1 = new Scene(pane, 1536, 768);
        Button b1 = new Button("Start game");
        b1.setScaleX(3);
        b1.setScaleY(3);
        b1.setLayoutX(768);
        b1.setLayoutY(384);
        pane.getChildren().add(b1);
        Label l = new Label("Shadows of Slowton");
        l.setLayoutX(734);
        l.setLayoutY(150);
        l.setStyle("-fx-font-size: 16px;");
        l.setScaleX(3);
        l.setScaleY(3);
        pane.getChildren().add(l);
        Pane pane1 = new Pane();
        Scene scene2 = new Scene(pane1, 1536, 768);
        b1.setOnMouseClicked(e -> {stage.setScene(scene2);});
        stage.setScene(scene1);
        stage.setTitle("Shadows of Slowton");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.show();
    }
    //        Screen.launch();
}