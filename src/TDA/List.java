package TDA;

/**
 *
 * @author omarc
 */
public interface List<E> {
    
    public void clear();
    public boolean isEmpty();
    public int size();
    public E get(int index);
    public boolean add(int index, E element);
    public void remove(int index);
    public int indexOf(E element);
    public void showList();
    
}
