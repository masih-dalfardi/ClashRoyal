package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

/**
 * this class is for game fxml page and handle timer and eksir bar
 */
public class Game implements Initializable {
    Timer timer_schudle;
    int counter;
    int min;
    int sec;
    float prog = 0;
    int times_up = 0;
    /**
     * tabe haie can baraie check krdne mizan eksire mojod dar bar ba mizan eksir mored niaz baraie har card k age mojod bashe can == 1 dar qeir insorat can == 0
     */
    int can_barbar = 0, can_archer = 0, can_canon = 0, can_giant = 0;
    @FXML
    private ImageView bar;

    @FXML
    private ImageView can;

    @FXML
    private ImageView gia;

    @FXML
    private ImageView arch;

    @FXML
    private ImageView gh1;

    @FXML
    private ImageView gh2;

    @FXML
    private ImageView gh3;

    @FXML
    private ImageView gh4;

    @FXML
    private ProgressBar progress;

    @FXML
    private Label timer;


    @FXML
    /**
     * ba tavajoh b mizane mored niaz eksir baraie card az meqdare prog kam miknim
     */
    void archer(MouseEvent event) {

        if (can_archer == 1) {
            // masalan inja baraie sakhte archer 0/3 eksir az moteqaiere prog kam shde
            prog -= .3;
        }
    }

    /**
     * ba tavajoh b mizane mored niaz eksir baraie card az meqdare prog kam miknim
     */
    @FXML
    void barbar(MouseEvent event) {
        if (can_barbar == 1) {
            prog -= .2;
        }
    }
    /**
     * ba tavajoh b mizane mored niaz eksir baraie card az meqdare prog kam miknim
     */
    @FXML
    void canon(MouseEvent event) {
        if (can_canon == 1) {
            prog -= .45;
        }

    }
    /**
     * ba tavajoh b mizane mored niaz eksir baraie card az meqdare prog kam miknim
     */
    @FXML
    void giant(MouseEvent event) {
        if (can_giant == 1) {
            prog -= .5;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ////////////////////////////////////////////////////////////timer
        counter = 180;//seconds
        timer_schudle = new Timer();
        timer_schudle.schedule(new TimerTask() {
            @Override
            public void run() {
             // Platform ((.runlater)) baraie jelogiri az crash UI dar timer
                Platform.runLater(new Runnable() {
                    public void run() {
                        if (counter == 0) {
                            timer_schudle.cancel();
                        }
                        min = counter / 60;//calculate minutes
                        sec = counter % 60;//calculate seconds
                        timer.setText(String.valueOf("0" + min + ":" + sec));
                        progress.setProgress(prog);
                    }
                });

                counter--;
                //dar 120s aval prog har sanie 0/05 ezafe mishavad va dar 60 sanie akhar prog 0/15 ezafe mishavad
                if(counter>60) {
                    prog += .05;
                }
                else {
                    prog+= .15;
                }
                Cards();
            }
        }, 1000, 1000);


    }

    /**
     * in tabe vazife dare nesbat be progress bar card haro makhfi va zaher kone va ejaze dasresi beheshoono behemoon bede ya azamoon begire
     * darkol agar meqdare prog az mizane eksire card kamtr bod be sorate kam rang va dar qeir in sorat b sorate porrrang namaiesh bede
     */
    void Cards() {
        if (prog > .3) {
            gh1.setVisible(false);
            //carde barbar ro zaher kon
            bar.setOpacity(1);
            can_barbar = 1;
        } else {
            gh1.setVisible(true);
            //carde barbar ro kamrang kon
            bar.setOpacity(.5);
            can_barbar = 0;
        }
        if (prog > .4) {
            gh2.setVisible(false);
            arch.setOpacity(1);
            can_archer = 1;
        } else {
            gh2.setVisible(true);
            arch.setOpacity(.5);
            can_archer = 0;
        }
        if (prog > .7) {
            gh3.setVisible(false);
            gia.setOpacity(1);
            can_giant = 1;
        } else {
            gh3.setVisible(true);
            gia.setOpacity(.5);
            can_giant = 0;
        }
        if (prog > .6) {
            gh4.setVisible(false);
            can.setOpacity(1);
            can_canon = 1;
        } else {
            gh4.setVisible(true);
            can.setOpacity(.5);
            can_canon = 0;
        }


    }


}
