package PaneView;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Ruleta.CirculoNumerico;
import Ruleta.RuletaNum;
import java.nio.file.Paths;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author omarc
 */
public class Main extends Application {
            
    
    public static void main(String[] arg) {
        launch(arg);
    }    

    @Override

    public void start(Stage primaryStage) throws Exception {
        playMusic();

        Scene scene = new Scene(new PaneManagement().getIniRoot(),500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    MediaPlayer mp;
    
    public void playMusic()
    {
        String content = "soundtrack2.mp3";
        
        Media m = new Media(Paths.get(content).toUri().toString());
        mp = new MediaPlayer(m);
        mp.play();
    }
                    
}