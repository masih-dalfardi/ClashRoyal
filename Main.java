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
      /*  Cart click */


        Button cart1 = (Button) scene3.lookup("#cart1");
        Button cart2 = (Button) scene3.lookup("#cart2");
        Button cart3 = (Button) scene3.lookup("#cart3");
        Button cart4 = (Button) scene3.lookup("#cart4");

        ///////////////////////////////////////////////////////////////
        cart1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
               double count =0.3;
               if(gameprg.getProgress()>=0.3)
               {
                   double test = gameprg.getProgress();
                   test-=0.3;
                   gameprg.setProgress(test);
               }
            }
        });

        ////////////////////////////////////////////////////////////////

        cart2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                double count =0.2;
                if(gameprg.getProgress()>=0.2)
                {
                    double test = gameprg.getProgress();
                    test-=0.2;
                    gameprg.setProgress(test);
                }
            }
        });
        ////////////////////////////////////////////////////////////

        cart3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                double count =0.4;
                if(gameprg.getProgress()>=0.4)
                {
                    double test = gameprg.getProgress();
                    test-=0.4;
                    gameprg.setProgress(test);
                }
            }
        });
        ////////////////////////////////////////////////////////////
        cart4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                double count =0.5;
                if(gameprg.getProgress()>=0.5)
                {
                    double test = gameprg.getProgress();
                    test-=0.5;
                    gameprg.setProgress(test);
                }
            }
        });



        window.show();





    }


    public void setTimer() {
        final int[] interval = {0};
        final double[] show = {0.0};
        Timer timer = new java.util.Timer();

        timer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (interval[0] < 3) {
                            show[0] = (double) interval[0] / 10;
                            prgbr.setProgress(show[0]);
                            interval[0]++;
                        } else {
                            changesence(scene2);
                            timer.cancel();
                        }
                    }
                });
            }
        }, 1000, 1000);

    }


    public void gameTimer() {
        final int[] interval = {180};
        final double[] show = {0.0};

        gametimer.setText("::");
        Timer timer = new java.util.Timer();

        timer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (interval[0] > 0) {
                            if(interval[0]%2==0)
                            {
                                if(gameprg.getProgress()!=1)
                                {
                                    double test = gameprg.getProgress();
                                    test+=0.1;
                                    gameprg.setProgress(test);
                                }
                            }

                            String time = (interval[0]/60)+":"+(interval[0]%60);
                            gametimer.setText(time);
                            interval[0]--;
                        } else {

                            timer.cancel();
                        }
                    }
                });
            }
        }, 1000, 1000);

    }








    public void changesence(Scene scene)
    {

        window.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
