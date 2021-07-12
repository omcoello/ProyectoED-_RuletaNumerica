package Ruleta;

import TDA.CircularlyDoubleLinkedList;

import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class RuletaNum {
    
    private CircularlyDoubleLinkedList<Integer> ruleta;
    
    public RuletaNum(){
        this.ruleta = null;
    }
    
    public RuletaNum(CircularlyDoubleLinkedList<Integer> ruleta) {
        this.ruleta = ruleta;
    }
    
    public int calcularValor() {
        int total = 0;
        int aux;
        for (int i = 0; i < ruleta.size(); i++) {
            aux = ruleta.get(i);
            total += aux;
        }
        return total;
    }
    
    public void rotarDerecha() {
        
        Stack<Integer> s = new Stack<>();
        s.push(ruleta.getFirst().getContent());
        
        for (int i = 0; i < ruleta.size(); ++i) {
            if (i + 1 < ruleta.size() && !s.isEmpty()) {
                int value = ruleta.get(i + 1);
                ruleta.add(i + 1, s.pop() + 1);
                s.push(value);
            }
        }
        ruleta.getFirst().setContent(s.pop() + 1);
        
    }
    
    public void rotarIzquierda() {
        
        Stack<Integer> s = new Stack<>();
        s.push(ruleta.getFirst().getContent());
        
        for (int i = ruleta.size() - 1; i >= 0; --i) {
            if (i - 1 > 0 && !s.isEmpty()) {
                int value = ruleta.get(i - 1);
                ruleta.add(i - 1, s.pop() - 1);
                s.push(value);
            }
        }
        ruleta.getFirst().setContent(s.pop() - 1);
        
    }
    
    public void eliminar(int index) {
        ruleta.remove(index);
    }
    
    public void llenarRuleta(int numero_elementos) {
        Random r = new Random();
        int numeroRandom;
        for (int i = 0; i < numero_elementos; i++) {
            numeroRandom = r.nextInt(10);
            ruleta.add(i, numeroRandom);
        }
    }
    
    public CircularlyDoubleLinkedList<Integer> getRuleta() {
        return ruleta;
    }
    
    public void setRuleta(CircularlyDoubleLinkedList<Integer> ruleta) {
        this.ruleta = ruleta;
    }
    
}
