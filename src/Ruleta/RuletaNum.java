package Ruleta;

import java.util.LinkedHashSet;




/**
 *
 * @author Alexis
 */
public class RuletaNum {
    
    public LinkedHashSet <CirculoNumerico> ruletasNumericas;

    public RuletaNum(LinkedHashSet<CirculoNumerico> ruletasNumericas) {
        this.ruletasNumericas = ruletasNumericas;
    }

    public int calcularValorRuleta(){
        int total = 0;
        int aux;
        for(CirculoNumerico cn: ruletasNumericas){
            aux = cn.calcularValorListaNumerica();
            total += aux;
        }
        return total;
    }

    public void eliminar(int index){
        for(CirculoNumerico cn: ruletasNumericas){
            cn.getListaNumerica().remove(index);
        }
    }

    public LinkedHashSet<CirculoNumerico> getRuletasNumericas() {
        return ruletasNumericas;
    }

}