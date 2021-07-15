/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruleta;

import TDA.CircularlyDoubleLinkedList;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class CirculoNumerico {
    
    private CircularlyDoubleLinkedList<Integer> listaNumerica;

    public CirculoNumerico(CircularlyDoubleLinkedList<Integer> listaNumerica) {
        this.listaNumerica = listaNumerica;
    }

    public int calcularValorListaNumerica(){
        int total = 0;
        int aux;
        for(int i = 0; i<listaNumerica.size(); i++){
            aux = listaNumerica.get(i);
            total += aux;
        }
        return total;
    }


    public void rotarDerecha(){
        CircularlyDoubleLinkedList<Integer> aux = new CircularlyDoubleLinkedList<>();
        CircularlyDoubleLinkedList<Integer> actual = new CircularlyDoubleLinkedList<>();
        for(int i = listaNumerica.size()-1; i<=listaNumerica.size()*2-1; i++){
            aux.add(i+1, listaNumerica.get(i));
        }

        for (int i = 0; i<aux.size(); i++){
            actual.add(i, aux.get(i)+1);
        }

        listaNumerica = actual;
    }

    public void rotarIzquierda(){
        CircularlyDoubleLinkedList<Integer> aux = new CircularlyDoubleLinkedList<>();
        CircularlyDoubleLinkedList<Integer> actual = new CircularlyDoubleLinkedList<>();

        for(int i = 0; i<=listaNumerica.size(); i++){
            aux.add(i, listaNumerica.get(i+1));
        }

        for (int i = 0; i<aux.size(); i++){
            actual.add(i, aux.get(i)-1);
        }

        listaNumerica = actual;
    }

    public void llenarListaNum(int numero_elementos){
        Random r = new Random();
        int numeroRandom;
        for(int i = 0 ; i<numero_elementos; i++){
            numeroRandom = r.nextInt(10);
            listaNumerica.add(i, numeroRandom);
        }
    }

    public CircularlyDoubleLinkedList<Integer> getListaNumerica() {
        return listaNumerica;
    }
    
    
    
}
