
package Ruleta;

import TDA.CircularlyDoubleLinkedList;

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
    
    
}
