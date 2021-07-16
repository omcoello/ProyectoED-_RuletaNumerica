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
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

    public String getRandomColor() {
        String hexNumbers[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String hexColor = "#";
        for (int i = 0; i < 6; i++) {
            hexColor += hexNumbers[new Random().nextInt(16)];
        }
        return hexColor;
    }
    
    

    public void generateRuleta(RuletaNum rn, double resolution, Pane pane) {
        LinkedHashSet<CirculoNumerico> rul = rn.getRuletasNumericas();
        int circle = 0;
        for (CirculoNumerico cn : rul) {
            Circle c = new Circle();
            c.setCenterX(resolution / 2);
            c.setCenterY(resolution / 2);
            c.setStroke(Color.valueOf(getRandomColor()));
            c.setFill(null);
            pane.getChildren().add(c);
            int n = cn.getListaNumerica().size();
            for (int e = 1; e <= n; ++e) {
                double actualResolution = resolution / (Math.pow(2, circle));
                double recenteringX = (resolution - actualResolution) / 2 + generateX(e, n, actualResolution / 2);
                double recenteringY = (resolution - actualResolution) / 2 + generateY(e, n, actualResolution / 2);


                Button button = new Button(String.valueOf(cn.getListaNumerica().get(e - 1)));
                button.setStyle("-fx-margin: 2px; -fx-font-weight: bold");
                pane.getChildren().add(button);
                button.setUserData(circle+","+ (e-1));
                button.setLayoutX(recenteringX);
                button.setLayoutY(recenteringY);


                //Ajustando radio del círuclo según la resolución manejada actualmente
                if (e == 1) {
                    c.setRadius(Math.sqrt(Math.pow(resolution / 2 - recenteringX, 2) + Math.pow(resolution / 2 - recenteringY, 2)));
                }
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
