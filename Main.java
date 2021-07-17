package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Application {

    private Stage window;
    private ProgressBar prgbr;
    private ProgressBar gameprg;
    private Button button2;
    private Label gametimer;
    Scene scene2;
    Scene scene3;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("ClashRoyal");
        Scene scene = new Scene(root, 480, 640);
        root.setId("pane");
        scene.getStylesheets().addAll(this.getClass().getResource("Firstpage.css").toExternalForm());
        window.setScene(scene);


        Parent root2 = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        window.setTitle("ClashRoyal");
        scene2 = new Scene(root2, 480, 640);
        scene2.getStylesheets().addAll(this.getClass().getResource("Firstpage.css").toExternalForm());


        Parent root3 = FXMLLoader.load(getClass().getResource("gamepage.fxml"));
        window.setTitle("ClashRoyal");
        scene3 = new Scene(root3, 480, 640);
        scene3.getStylesheets().addAll(this.getClass().getResource("Firstpage.css").toExternalForm());
/*
        ProgressBar pb = new ProgressBar(0.6);
        VBox vb = new VBox();
        vb.setSpacing(5);

        vb.getChildren().addAll(pb);
        scene.setRoot(vb);



        Button button= new Button("Submit Answer");

        button.setLayoutY(800);

        StackPane layout= new StackPane();
        layout.getChildren().add(button);
        scene.getStylesheets().addAll(this.getClass().getResource("Firstpage.css").toExternalForm());
        layout.setId("pane");

        scene.setRoot(layout);


 */

         prgbr = (ProgressBar) scene.lookup("#progressBar");
         gameprg = (ProgressBar) scene3.lookup("#gameprogress");
         gametimer = (Label) scene3.lookup("#Timer");
         gametimer.setText("__");
        setTimer();



        button2 = (Button) scene2.lookup("#startbutton");


        button2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                window.setScene(scene3);
                gametimer.setText("((");
                gameTimer();
            }
        });
      








 
