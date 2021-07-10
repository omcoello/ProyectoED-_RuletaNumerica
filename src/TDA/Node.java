package TDA;

/**
 *
 * @author omarc
 */
public class Node <Integer> {
    
    private int content;
    private Node<Integer> next;
    private Node<Integer> previous;
    
    public Node (){
        content = 0;
        this.next = null;
        this.previous = null;
    }
    
    public Node(int content){
        this.content = content;
        this.next = null;
        this.previous = null;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public Node<Integer> getNext() {
        return next;
    }

    public void setNext(Node<Integer> next) {
        this.next = next;
    }

    public Node<Integer> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<Integer> previous) {
        this.previous = previous;
    }
    
}
