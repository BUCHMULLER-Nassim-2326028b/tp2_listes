package tp2_liste_double;

/// 1.1.6 et 1.1.7

public class DLinkedList {
    private DNode header, trailer;
    private long size;

    public DLinkedList() {
        header = new DNode(0, null, null);
        trailer = new DNode(0, header, null);
        header.setNext(trailer);
        size = 0;
    }

    public long getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int element) {
        addBetween(element, header, header.getNext());
    }

    public void addLast(int element) {
        addBetween(element, trailer.getPrev(), trailer);
    }

    private void addBetween(int element, DNode predecessor, DNode successor) {
        DNode newNode = new DNode(element, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    public int getFirst() {
        if (isEmpty()) return -1;
        return header.getNext().getElement();
    }

    public int getLast() {
        if (isEmpty()) return -1;
        return trailer.getPrev().getElement();
    }

    public int removeFirst() {
        if (isEmpty()) return -1;
        return remove(header.getNext());
    }

    public int removeLast() {
        if (isEmpty()) return -1;
        return remove(trailer.getPrev());
    }

    private int remove(DNode node) {
        DNode predecessor = node.getPrev();
        DNode successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public void printList() {
        DNode current = header.getNext();
        while (current != trailer) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    public void printListReverse() {
        DNode current = trailer.getPrev();
        while (current != header) {
            System.out.println(current.getElement());
            current = current.getPrev();
        }
    }

    public boolean updateElement(int oldElement, int newElement) {
        DNode current = header.getNext();
        while (current != trailer) {
            if (current.getElement() == oldElement) {
                current.setElement(newElement);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);

        System.out.println("Liste dans l'ordre :");
        list.printList();

        System.out.println("Liste à l'envers :");
        list.printListReverse();

        System.out.println("Mise à jour de 20 à 25 :");
        list.updateElement(20, 25);
        list.printList();

        System.out.println("Suppression du premier élément : " + list.removeFirst());
        list.printList();

        System.out.println("Suppression du dernier élément : " + list.removeLast());
        list.printList();
    }
}
