package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Munu implements Initializable {
    @FXML
    private ListView<String> list;

    @FXML
    void go(ActionEvent event) throws IOException {
        //age roo dokme training camp bezanim in tabe ro ejra mikone
        Main.pager.onnext("game");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ghab har chizi in tabe ejra mishe
        list.getItems().add("UnFinished             2/3/2021");//meghdare list ro meghdar dehi mikonim
        list.getItems().add("UnFinished             1/3/2021");
        list.getItems().add("UnFinished                25/2/2021");
        list.getItems().add("UnFinished                24/2/2021");
        list.getItems().add("UnFinished             24/2/2021");
    }
}
