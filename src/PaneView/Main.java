package PaneView;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Ruleta.CirculoNumerico;
import Ruleta.RuletaNum;
import TDA.CircularlyDoubleLinkedList;
import java.util.LinkedHashSet;
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
    static Pane pane = new Pane();
    boolean ganador = false;
    boolean perdedor = false;
    int numeroProhibido = 20;
    RuletaNum ruletaNumerica;
    
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
        
        new RuletaController().generateRuleta(new RuletaNum(rul), resX, pane);
        
        Scene scene = new Scene(pane, resX+25, resY+25);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public boolean verificarProhibidos(){
        
        boolean resultado = false;
        
        for(CirculoNumerico cn: this.ruletaNumerica.getRuletasNumericas()){
            
            for(int i = 0; i<cn.getListaNumerica().size();i++){
                if(cn.getListaNumerica().get(i)<0 || cn.getListaNumerica().get(i) == numeroProhibido){
                    resultado = false;
                }
                else{
                    resultado = true;
                }
            }
        }
        
        return resultado;
    
    }
    
    
    
}