
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
