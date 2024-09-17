package tp2_liste_double;

public class DNode {
    private int element;  // L'élément est un int maintenant
    private DNode next, prev;

    public DNode(int e, DNode p, DNode n) {
        element = e;
        prev = p;
        next = n;
    }

    public int getElement() {
        return element;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setElement(int newElem) {
        element = newElem;
    }

    public void setNext(DNode newNext) {
        next = newNext;
    }

    public void setPrev(DNode newPrev) {
        prev = newPrev;
    }
}
