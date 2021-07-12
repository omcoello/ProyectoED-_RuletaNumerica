/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
