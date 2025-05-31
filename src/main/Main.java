package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Stage stage1 = new Stage();
        Pane pain = new Pane();
        Scene scene1 = new Scene(pain, 1536, 768);
        stage1.setScene(scene1);
        Rectangle rekt = new Rectangle(32,32);
        rekt.setVisible(false);
        rekt.setFill(Color.RED);
        pain.getChildren().add(rekt);
        scene1.setOnMouseClicked(e -> rekt.setVisible(!rekt.isVisible()));
        stage1.show();
        stage1.setTitle("Shadows of Slowton");
        stage1.setResizable(false);
        stage1.setFullScreen(false);
    }

    public static void main(String[] args) {
        launch();
    }
}