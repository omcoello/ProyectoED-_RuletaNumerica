package TDA;

/**
 *
 * @author omarc
 */
public class Node <E> {
    
    private E content;
    Node<E> next;
    Node<E> previous;
    
    
    
    public Node (){
        content = null;
        this.next = null;
        this.previous = null;
    }

    public Node(E content){
        this.content = content;
        this.next = null;
        this.previous = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
    
}
