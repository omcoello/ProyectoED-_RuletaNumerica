package TDA;

/**
 *
 * @author omarc
 */
public class CircularlyDoubleLinkedList<E> implements List<E> {

    private Node<E> first;   
    
    private int size;

    @Override
    public void clear() {
        first.setContent(null);
        first.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return first.getNext() == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        Node<E> traveler = first.next;
        int j = 0;
        while(traveler != null && j<index){
            traveler = traveler.getNext();
            j++;
        }
        assert traveler != null;
        return traveler.getContent();
    }

    @Override
    public boolean add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(E element) {
        Node<E> traveler = first;
        int j = 0;
        while(traveler.getNext() != first){
            if(traveler.getNext().getContent().equals(element)){
                break;
            }
            traveler = traveler.getNext();
            j++;
        }
        if(traveler.next != first){
            return j;
        } else {
            return -1;
        }

    }

    @Override
    public void showList() {
        Node<E> node = first.getNext();
        while(!node.equals(first)){
            System.out.println(node.getContent()+"");
            node = node.getNext();
        }
        System.out.println();

    }

    

}
