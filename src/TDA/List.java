package TDA;

/**
 *
 * @author omarc
 */
public interface List {
    
    public boolean add();
    public boolean remove(int pos);
    public boolean rotate(String orientation);
    public int indexOf();
    //Parametro c1 y c2 asumiendo que se tienen mas de dos circulos
    public boolean elimination(CircularlyDoubleLinkedList c1, CircularlyDoubleLinkedList c2);
    public int get(int index);
    
}
