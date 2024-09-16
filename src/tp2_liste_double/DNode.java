package tp2_liste_double;

public class DNode {
    private String element;
    private DNode next, prev;
    
    public DNode(String e, DNode p, DNode n) {
        element = e;
        prev = p;
        next = n;
    }

    public String getElement() {
        return element;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setElement(String newElem) {
        element = newElem;
    }

    public void setNext(DNode newNext) {
        next = newNext;
    }

    public void setPrev(DNode newPrev) {
        prev = newPrev;
    }
}