package PaneView;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Ruleta.CirculoNumerico;
import Ruleta.RuletaNum;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

        Scene scene = new Scene(new PaneManagement().getIniRoot(),500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
                    
}