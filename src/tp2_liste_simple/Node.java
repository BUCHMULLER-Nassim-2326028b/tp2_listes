package tp2_liste_simple;

public class Node {
	
    private int element;
    private Node next;

    public Node(int s, Node n) {
        element = s;
        next = n;
    }

    public int getElement() { return element; }

    public Node getNext() { return next; }

    public void setElement(int newElem) { element = newElem; }

    public void setNext(Node newNext) { next = newNext; }
    
}