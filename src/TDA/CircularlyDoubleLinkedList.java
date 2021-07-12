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
        while (traveler != null && j < index) {
            traveler = traveler.getNext();
            j++;
        }
        assert traveler != null;
        return traveler.getContent();
    }

    @Override
    public boolean add(int index, E element) {
        if (index >= 0 && element != null) {
            Node<E> traveler = first.next;
            int j = 0;
            while (!traveler.equals(first) && j < index) {
                traveler = traveler.next;
                j++;
            }
            Node<E> nuevoNode = new Node(element);
            traveler.previous.next = nuevoNode;
            nuevoNode.previous = traveler.previous;
            nuevoNode.next = traveler;
            traveler.previous = nuevoNode;
            size++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void remove(int index) {
        Node<E> traveler = first.getNext();
        int j = 0;
        while (!traveler.equals(first) && j < index) {
            traveler = traveler.getNext();
            ++j;
        }
        traveler.previous.next = traveler.getNext();
        traveler.next.previous = traveler.getPrevious();
        size--;
    }

    @Override
    public int indexOf(E element) {
        Node<E> traveler = first;
        int j = 0;
        while (traveler.getNext() != first) {
            if (traveler.getNext().getContent().equals(element)) {
                break;
            }
            traveler = traveler.getNext();
            j++;
        }
        if (traveler.next != first) {
            return j;
        } else {
            return -1;
        }

    }

    @Override
    public void showList() {
        Node<E> node = first.getNext();
        while (!node.equals(first)) {
            System.out.println(node.getContent() + "");
            node = node.getNext();
        }
        System.out.println();

    }

    public Node<E> getFirst() {
        return first;
    }

}
