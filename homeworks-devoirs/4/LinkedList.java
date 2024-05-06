import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

  private static class Node<T> {
    private T value;
    private Node<T> prev;
    private Node<T> next;

    private Node(T value, Node<T> prev, Node<T> next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }

  private Node<E> head;
  private int size;

  public LinkedList() {
    head = new Node<E>(null, null, null);
    head.prev = head;
    head.next = head;
    size = 0;
  }

  public int size() {
    return size;
  }

  public E get(int pos) {

    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException(Integer.toString(pos));
    }

    Node<E> p;
    p = head.next;

    while (pos > 0) {
      p = p.next;
      pos--;
    }

    return p.value;
  }

  public void add(E element, int pos) {

    if (element == null) {
      throw new NullPointerException();
    }

    if (pos < 0 || pos > size) {
      throw new IndexOutOfBoundsException(Integer.toString(pos));
    }

    Node<E> before, after;
    before = head;

    while (pos > 0) {
      before = before.next;
      pos--;
    }

    after = before.next;

    before.next = new Node<E>(element, before, after);
    after.prev = before.next;

    size++;
  }

  public void remove(int pos) {

    if (pos < 0 || pos >= size) {
      throw new IndexOutOfBoundsException(Integer.toString(pos));
    }

    Node<E> before, after;
    before = head;

    while (pos > 0) {
      before = before.next;
      pos--;
    }

    after = before.next.next;

    before.next = after;
    after.prev = before;

    size--;
  }

  public void merge(LinkedList<E> other) {

    int s = other.size;
    for (int i = 0; i < s; i++) {
      Node<E> nodeToAdd = other.head.next;
      other.head.next = other.head.next.next;
      other.head.next.prev = other.head;
      if (other.head.next == other.head) {
        other.head.prev = other.head;
      }
      head.prev.next = nodeToAdd;
      nodeToAdd.prev = head.prev;
      head.prev = nodeToAdd;
      nodeToAdd.next = head;
      this.size++;
      other.size--;
    }
  }

  public Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  public class LinkedListIterator implements Iterator<E> {

    private Node<E> current;

    public LinkedListIterator() {
      current = head;
    }

    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      if (current.next == head) {
        current = current.next;
      }
      current = current.next;
      return current.value;
    }

    public E prev() {
      if (!hasPrev()) {
        throw new NoSuchElementException();
      }
      if (current.prev == head) {
        current = current.prev;
      }
      current = current.prev;
      return current.value;
    }

    public boolean hasNext() {
      if (size == 0) {
        return false;
      }
      if (current.next == head) {
        if (current.next.next.value instanceof E) {
          return true;
        }
        return false;
      }
      if (current.next.value instanceof E) {
        return true;
      }
      return false;
    }

    public boolean hasPrev() {
      if (size == 0) {
        return false;
      }
      if (current.prev == head) {
        if (current.prev.prev.value instanceof E) {
          return true;
        }
        return false;
      }
      if (current.prev.value instanceof E) {
        return true;
      }
      return false;
    }
  }

  public String toString() {

    StringBuffer b;
    b = new StringBuffer("LinkedList [");

    Node<E> p;
    p = head.next;

    while (p != head) {
      b.append(p.value);
      if (p.next != head) {
        b.append(",");
      }
      p = p.next;
    }

    b.append("]");

    return b.toString();
  }

}
