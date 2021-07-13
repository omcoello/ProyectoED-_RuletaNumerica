/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Ruleta.RuletaNum;
import TDA.CircularlyDoubleLinkedList;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        
        CircularlyDoubleLinkedList<Integer> lista1 = new CircularlyDoubleLinkedList<>();

        CircularlyDoubleLinkedList<Integer> lista2 = new CircularlyDoubleLinkedList<>();
        
        RuletaNum ruleta1 = new RuletaNum(lista1);
        RuletaNum ruleta2 = new RuletaNum(lista2);

        ruleta1.llenarRuleta(5);
        ruleta2.llenarRuleta(5);
        
        ruleta1.getRuleta().showList();
        System.out.println("******************");
        ruleta2.getRuleta().showList();
        System.out.println();
        
        int valorRuleta = ruleta1.calcularValor()+ruleta2.calcularValor();
        System.out.println("valor de la ruleta: " + valorRuleta);

        ruleta1.eliminar(3);
        ruleta2.eliminar(3);
        valorRuleta = ruleta1.calcularValor()+ruleta2.calcularValor();
        System.out.println("valor de ruleta: "+ valorRuleta);
        
    }
    
}
