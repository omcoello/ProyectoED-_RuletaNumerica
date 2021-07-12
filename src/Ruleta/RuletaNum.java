
package Ruleta;

import TDA.CircularlyDoubleLinkedList;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class RuletaNum {
    
    private CircularlyDoubleLinkedList<Integer> ruleta;

    public RuletaNum(CircularlyDoubleLinkedList<Integer> ruleta) {
        this.ruleta = ruleta;
    }
    
    public int calcularValor(){
        int total = 0;
        int aux;
        for(int i = 0; i<ruleta.size(); i++){
            aux = ruleta.get(i);
            total += aux;
        }
        return total;
    }

    public void rotarDerecha(){}

    public void rotarIzquierda(){}
    
    
    public void eliminar(int index){
        ruleta.remove(index);
    }
    
    public void llenarRuleta(int numero_elementos){
        Random r = new Random();
        int numeroRandom;
        for(int i = 0 ; i<numero_elementos; i++){
            numeroRandom = r.nextInt(10);
            ruleta.add(i, numeroRandom);
        }
    }

    public CircularlyDoubleLinkedList<Integer> getRuleta() {
        return ruleta;
    }
}
