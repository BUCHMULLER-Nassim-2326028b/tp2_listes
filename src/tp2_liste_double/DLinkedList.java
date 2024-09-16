package tp2_liste_double;

public class DLinkedList {
    private DNode header, trailer;
    private long size;
    
    public DLinkedList() {
        header = new DNode(null, null, null); 
        trailer = new DNode(null, header, null); 
        header.setNext(trailer);
        size = 0;
    }
    
    public long getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void addFirst(String element) {
        addBetween(element, header, header.getNext());
    }

    public void addLast(String element) {
        addBetween(element, trailer.getPrev(), trailer);
    }

    private void addBetween(String element, DNode predecessor, DNode successor) {
        DNode newNode = new DNode(element, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    public String getFirst() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public String getLast() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public String removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    public String removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    private String remove(DNode node) {
        DNode predecessor = node.getPrev();
        DNode successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}