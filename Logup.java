package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Logup {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    void nlogup(ActionEvent event) throws IOException {
        //vaghti roo dokme logup click mishe
        if(!username.getText().equals("") && !password.getText().equals("")){
        Write_To_File(username.getText(),password.getText());}else {
            System.out.println("null");
        }
    }

    void Write_To_File(String username,String password) throws IOException {
       
        String s=username+","+password+"/";
        try {
            Files.write(Paths.get("Users.txt"),s.getBytes(), StandardOpenOption.APPEND);
            Main.pager.onnext("sample");
           
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
