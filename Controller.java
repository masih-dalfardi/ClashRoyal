package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Controller {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    void onlogin(ActionEvent event) throws IOException {
        //vaghti rooye dokme login click mishe in tabe ejra mishe
    String data=Read_From_File("Users.txt");//in tabe etelaat ro az file Users.txt migire
    Check_Theres(data);//in tabe vazife ino dare k barrsi kone aya ba etelaati ke vared karde karbar fardi vogood dare too file ke etelaatesh hamin bashe?age ok bood varede barname va age okey nabood vared nenishe
    }

    @FXML
    void onlogup(ActionEvent event) throws IOException {
        //vaghti roo dokme logup mizanim in tabe ejra mishe
        Main.pager.onnext("logup");//maro mibare be safhe logup
    }

    String Read_From_File(String filename){
        String s="";
    try {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
             s+=data;
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    return s;
}

    void Check_Theres(String data) throws IOException {
     if(data!=null){
         String[] Splited=data.split("/");
         for(int i=0;i<Splited.length;i++){
            String[] splited_1=Splited[i].split(",");
                if(splited_1[0].equals(username.getText()) && splited_1[1].equals(password.getText())){
                    Model model=new Model();
                    model.setUsername(username.getText());
                    model.setPassword(password.getText());
                    Main.pager.onnext("menu");
                }
         }
     }
    }

}
