package tp2_liste_simple;

public class SLinkedList {
    private Node head; 
    private int size; 

    public SLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(int element) {
        head = new Node(element, head);
        size++;
    }

    public void printList(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        System.out.println(currentNode.getElement());
        printList(currentNode.getNext());
    }

    public void printList() {
        printList(head);
    }

    public boolean updateElement(int oldValue, int newValue) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getElement() == oldValue) {
                currentNode.setElement(newValue);
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public int removeFirst() {
        if (head == null) {
            throw new IllegalStateException("La liste est vide.");
        }
        int removedElement = head.getElement();
        head = head.getNext();
        size--;
        return removedElement;
    }

    public int getSize() {
        return size;
    }
    
    public boolean removeElement(int element) {
        if (head == null) {
            return false; 
        }
        
        if (head.getElement() == element) {
            head = head.getNext();
            size--;
            return true;
        }
        
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getElement() == element) {
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        
        return false; 
    }
    
    public void addLast(int element) {
        Node newNode = new Node(element, null);
        
        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        
        size++;
    }
    
    public Node avantDernier() {
        if (head == null || head.getNext() == null) {
            throw new IllegalStateException("La liste doit avoir au moins deux éléments.");
        }

        Node currentNode = head;
        
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        
        return currentNode; 
    }
    
    public void reverse() {
        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }
    
    public boolean nodeSwap(int x, int y) {
        if (x == y) {
            return false;
        }

        Node prevX = null, currX = head;
        Node prevY = null, currY = head;

        while (currX != null && currX.getElement() != x) {
            prevX = currX;
            currX = currX.getNext();
        }

        while (currY != null && currY.getElement() != y) {
            prevY = currY;
            currY = currY.getNext();
        }

        if (currX == null || currY == null) {
            return false;
        }

        if (prevX != null) {
            prevX.setNext(currY);
        } else { 
            head = currY;
        }

        if (prevY != null) {
            prevY.setNext(currX);
        } else {
            head = currX;
        }

        Node temp = currX.getNext();
        currX.setNext(currY.getNext());
        currY.setNext(temp);

        return true;
    }


    
    public static void main(String[] args) {
    	
    	SLinkedList list = new SLinkedList();

        list.addFirst(10);
        list.addFirst(20); 
        list.addFirst(30);
        list.addFirst(65);
        
        // 1.1.2

        System.out.println("Liste initiale :");
        list.printList(); 
        System.out.println("Modification de l'élément 20 à 25 :");
        list.updateElement(20, 25);
        list.printList(); 

        System.out.println("Suppression du premier élément : " + list.removeFirst());
        list.printList(); 

        System.out.println("Taille actuelle de la liste : " + list.getSize());
        
        // 1.1.3
        
        try {
            Node penultimate = list.avantDernier();
            System.out.println("L'avant-dernier élément est : " + penultimate.getElement());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        

        list.addFirst(40);
        list.printList();
        
        // 1.1.4
        
        System.out.println("Liste avant inversion :");
        list.printList();

        list.reverse();

        System.out.println("Liste après inversion :");
        list.printList();
        
        // 1.1.5
        
        System.out.println("Liste avant échange :");
        list.printList();
        
        int numb1 = 25; // On définit les chiffres qu'on veut échanger
        int numb2 = 30; //

        list.nodeSwap(numb1, numb2);

        System.out.println("Liste après échange de " + numb1 + " et " + numb2);
        list.printList();
        
        
    }
}
