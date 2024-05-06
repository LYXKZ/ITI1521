import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;


    // Representation of the empty list.

    public OrderedList() {
    }

    // Calculates the size of the list
    public int size() {

        if (head == null) {
            return 0;
        }

        int num = 0;
        Node node = head;
        while (node.next != head) {
            node = node.next;
            num++;
        }
        return num;
    }


    public Object get( int pos ) {
        
        if (pos < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        Node node = head;
        for (int i = 0; i < pos; i++) {
            if (node.next == head) {
                throw new IndexOutOfBoundsException();
            }
            node = node.next;
        }
        return node.value;

    }

    // Adding an element while preserving the order

    @SuppressWarnings("unchecked")
    public boolean add( Comparable o ) {

        if (o == null) {
            throw new IllegalArgumentException();
        }
        if (head == null) {
            head = new Node(o, null, null);
            head.previous = head;
            head.next = head;
            return true;

        } else {
            if (head.value.compareTo(o) >= 0) {
                Node nodeToAdd = new Node(o, null, null);
                nodeToAdd.next = head;
                nodeToAdd.previous = head.previous;
                head.previous = nodeToAdd;
                if (head.next == head) {
                    head.next = nodeToAdd;
                }
                head = nodeToAdd;
            } else {
                Node nodeToAdd = new Node(o, null, null);
            Node node = head;
            while (node.next != head) {
                if (node.value.compareTo(o) < 0) {
                    node = node.next;
                } else {
                    break;
                }
            }
            nodeToAdd.previous = node.previous;
            node.previous.next = nodeToAdd;
            node.previous = nodeToAdd;
            nodeToAdd.next = node;
            }
            return true;

/* 
            Node nodeToAdd = new Node(o, null, null);
            Node node = head;
            while (node.next != head) {
                if (node.value.compareTo(o) < 0) {
                    node = node.next;
                } else {
                    break;
                }
            }
            nodeToAdd.previous = node.previous;
            node.previous.next = nodeToAdd;
            node.previous = nodeToAdd;
            nodeToAdd.next = node;
            if (node == head && node.value.compareTo(o) < 0) {
                head = nodeToAdd;
            }
            return true; */
        }
    }

    //Removes one item from the position pos.
    @SuppressWarnings("unchecked")
    public void remove( int pos ) {

        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        if (pos < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node node = head;
        for (int i = 0; i < pos; i++) {
            if (node.next == head) {
                throw new IndexOutOfBoundsException();
            }
            node = node.next;
        }

        node.previous.next = node.next;
        node.next.previous = node.previous;
        if (node == head) {
            head = node.next;
        }
    }

    @SuppressWarnings("unchecked")
    public void merge( OrderedList other ) {
        int otherLength = other.size();
        for (int i = 0; i < otherLength; i++) {
            Comparable o = other.head.value;
            this.add(o);
            other.remove(0);
        }
    }
    public static void main(String[] args) {
        OrderedList list = new OrderedList();
        list.add("A");
        list.add("B");
        list.add("A");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        //System.out.println(list.get(2));
    }
}
