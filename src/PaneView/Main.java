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
    
    /*
    
    public void movimientoMaquina(){
        Random random = new Random();
        
        //indice random para remover un elemento o rotar una lista circular
        int index1 = random.nextInt(2);
        // index1 = 0 para rotar
        // index1 = 1 para eliminar
        
        //indice random para obtener una de las listas (para rotacion)
        int bound = ruletaNumerica.getRuletasNumericas().size();
        int index2 = random.nextInt(bound);
        
        //indice random para aplicar el remove() en caso de eliminacion
        int indexRemove = 0;
        
        // variable boolean de control para el sentido de las rotaciones
        boolean rotacion = random.nextBoolean();
        // rotacion = true para rotar a la derecha
        // rotacion = false para rotar a la izquierda

        
        if(index1 == 0){
            
            if(rotacion){
                ruletaNumerica.getCircleNumByIndex(index2).rotarDerecha();
            } else{
                ruletaNumerica.getCircleNumByIndex(index2).rotarIzquierda();
            }
        } else{
            for(CirculoNumerico cn: ruletaNumerica.getRuletasNumericas()){
                cn.getListaNumerica().remove(indexRemove);
                
            }
        }
        
        new RuletaController().generateRuleta(ruletaNumerica, 500, pane);
        
    }
    */
}