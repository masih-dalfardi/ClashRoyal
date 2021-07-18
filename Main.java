package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application implements Pager {
  Stage primaryStage;
  static Pager pager;
    @Override
    public void start(Stage primaryStage) throws Exception{
    this.primaryStage=primaryStage;
    pager=this::onnext;
onnext("sample");
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void onnext(String name) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(name+".fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
