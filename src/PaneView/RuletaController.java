/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneView;

import Ruleta.*;
import TDA.CircularlyDoubleLinkedList;
import static java.lang.Math.*;
import java.util.LinkedHashSet;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author omarc
 */
public class RuletaController extends Application {

    public double generateX(int k, int n, double resolution) {
        return resolution * (1 - cos(k * (2 * Math.PI / n)));
    }

    public double generateY(int k, int n, double resolution) {
        return resolution * (1 - sin(k * (2 * Math.PI / n)));
    }

    public void generateRuleta(RuletaNum rn, double resolution, Pane pane){
        LinkedHashSet <CirculoNumerico> rul = rn.getRuletasNumericas();
        int circle = 0;
        for(CirculoNumerico cn : rul){
            int n = cn.getListaNumerica().size();            
            for(int e = 1; e <= n; ++e){
                double actualResolution = resolution /(Math.pow(2, circle));
                double recenteringX = (resolution - actualResolution)/2 + generateX(e,n,actualResolution/2);
                double recenteringY = (resolution - actualResolution)/2 + generateY(e,n,actualResolution/2);
                
                Label label = new Label(String.valueOf(cn.getListaNumerica().get(e-1)));
                pane.getChildren().add(label);
                
                label.setLayoutX(recenteringX);
                label.setLayoutY(recenteringY);
                System.out.println("Recentering: " + recenteringX);                
            }
            ++circle;
        }
    }

    public static void main(String[] arg) {
//        for (int i = 1; i < 5; ++i) {
//            System.out.println("X: " + new RuletaController().generateX(i, 4, 1000));
//            System.out.println("Y: " + new RuletaController().generateY(i, 4, 1000));
//        }
        launch(arg);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        double resX = 500, resY = 500;
        Pane pane = new Pane();
        
        LinkedHashSet<CirculoNumerico> rul = new LinkedHashSet<>();
        CirculoNumerico cn1 = new CirculoNumerico(new CircularlyDoubleLinkedList());
        CirculoNumerico cn2 = new CirculoNumerico(new CircularlyDoubleLinkedList());
        CirculoNumerico cn3 = new CirculoNumerico(new CircularlyDoubleLinkedList());

        cn1.llenarListaNum(4);        
        cn2.llenarListaNum(4);
        cn3.llenarListaNum(4);
        rul.add(cn1);
        rul.add(cn2);
        rul.add(cn3);
        
        generateRuleta(new RuletaNum(rul), resX, pane);
        
        Scene scene = new Scene(pane, resX, resY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

