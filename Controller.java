package sample;

public class Controller {
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
}
   public void changesence(Scene scene)
    {

        window.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
    void Check_Theres(String data) throws IOException {
     if(data!=null){//age meghdari tooye file ma voggod dasht varede shart beshe
         String[] Splited=data.split("/");//tabe split vazife joda sazi ro dare...alan ma migim ke etelaate file ro ba ye slash( / ) jodasazi kon...(har karbar ba yek slash az ham joda shodand dar file...eteleate har karbar ba yek kama (,) az ham joda shode
         for(int i=0;i<Splited.length;i++){
            String[] splited_1=Splited[i].split(",");
                if(splited_1[0].equals(username.getText()) && splited_1[1].equals(password.getText())){//too in shart barresi mikonim ke aya username va passi k karbar vared karde ba user va pass hayee ke too file vogood dare motabeghat dare ya na
                    Model model=new Model();//yek shey az classe model misazim
                    model.setUsername(username.getText());//username ros et mikonimm
                    model.setPassword(password.getText());//password ros et mikonimm
                    Main.pager.onnext("menu");//be menu miravim
                }
         }
     }
    }

}

