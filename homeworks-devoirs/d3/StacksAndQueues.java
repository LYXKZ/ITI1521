import java.util.EmptyStackException;

public class StacksAndQueues{
    
  //TODO: Ajouter vos 6 methodes ici
  public static void reverseQueue(Queue<String> queue) throws IllegalArgumentException {
      if (queue == null) {
          throw new IllegalArgumentException("Argument cannot be null");
      }

      LinkedStack<String> temp_stack = new LinkedStack<>();
      
      while (!queue.isEmpty()) {
          temp_stack.push(queue.dequeue());
      }

      while (!temp_stack.isEmpty()) {
          queue.enqueue(temp_stack.pop());
      }
  }


  public static void reverseStack(Stack<String> stack) throws IllegalArgumentException {
    if (stack == null) {
        throw new IllegalArgumentException("Argument cannot be null");
    }

      LinkedQueue<String> temp_queue = new LinkedQueue<>();
        
        while (!stack.isEmpty()) {
            temp_queue.enqueue(stack.pop());
        }

        while (!temp_queue.isEmpty()) {
            stack.push(temp_queue.dequeue());
        }
  }


  public static void removeAll(Queue<String> queue, String toRemove) throws IllegalArgumentException, EmptyQueueException {
    if (queue == null) {
        throw new IllegalArgumentException("Argument cannot be null");
    } else if (queue.isEmpty()) {
        throw new EmptyQueueException("Argument cannot be empty");
    }

      LinkedQueue<String> temp_queue = new LinkedQueue<>();
        
      while (!queue.isEmpty()) {
          String elem = queue.dequeue();

          if (!elem.equals(toRemove)) {
              temp_queue.enqueue(elem);
          }
      }

      while (!temp_queue.isEmpty()) {
          queue.enqueue(temp_queue.dequeue());
      }
  }


  public static void removeAll(Stack<String> stack, String toRemove) throws IllegalArgumentException, EmptyStackException {
      if (stack == null) {
          throw new IllegalArgumentException("Argument cannot be null");
      } else if (stack.isEmpty()) {
          throw new EmptyStackException();
      }

      LinkedStack<String> temp_stack = new LinkedStack<>();
        
      while (!stack.isEmpty()) {
          String elem = stack.pop();

          if (!elem.equals(toRemove)) {
              temp_stack.push(elem);
          }
      }

      while (!temp_stack.isEmpty()) {
          stack.push(temp_stack.pop());
      }
  }


  public static void removeFirst(Queue<String> queue, String toRemove) throws IllegalArgumentException, EmptyQueueException {
      if (queue == null) {
          throw new IllegalArgumentException("Argument cannot be null");
      } else if (queue.isEmpty()) {
          throw new EmptyQueueException("Argument cannot be empty");
      }

      LinkedQueue<String> temp_queue = new LinkedQueue<>();
      boolean isFound = false;
        
      while (!queue.isEmpty()) {
          String elem = queue.dequeue();

          if (!elem.equals(toRemove) || isFound) {
              temp_queue.enqueue(elem);
          } else {
              isFound = true;
          }
      }

      while (!temp_queue.isEmpty()) {
          queue.enqueue(temp_queue.dequeue());
      }
  }


  public static void removeFirst(Stack<String> stack, String toRemove) throws IllegalArgumentException, EmptyQueueException {
      if (stack == null) {
          throw new IllegalArgumentException("Argument cannot be null");
      } else if (stack.isEmpty()) {
          throw new EmptyStackException();
      }
    
      LinkedStack<String> temp_stack = new LinkedStack<>();
      boolean isFound = false;
      
    while (!stack.isEmpty()) {
        String elem = stack.pop();

        if (!elem.equals(toRemove) || isFound) {
            temp_stack.push(elem);
        } else {
            isFound = true;
        }
    }

    while (!temp_stack.isEmpty()) {
        stack.push(temp_stack.pop());
      }
  }
  

    public static void main (String[] args){
        Queue<String> q1;
        q1 = new LinkedQueue<String>();
        q1.enqueue ("a");
        q1.enqueue ("b");
        q1.enqueue ("c");
        q1.enqueue ("d");
        System.out.println("reverse Queue");
        System.out.println(q1);
        StacksAndQueues.reverseQueue(q1);
        System.out.println(q1);
        System.out.println();

        Stack<String> s1;
        s1 = new LinkedStack<String>();
        s1.push ("a");
        s1.push ("b");
        s1.push ("c");
        s1.push ("d");
        System.out.println("reverse Stack");
        System.out.println(s1);
        StacksAndQueues.reverseStack(s1);
        System.out.println(s1);
        System.out.println();

        Queue<String> q2;
        q2 = new LinkedQueue<String>();
        q2.enqueue ("a");
        q2.enqueue ("b");
        q2.enqueue ("c");
        q2.enqueue ("a");
        q2.enqueue ("b");
        q2.enqueue ("c");
        q2.enqueue ("a");
        q2.enqueue ("b");
        q2.enqueue ("c");
        System.out.println("remove All a for Queue");
        System.out.println(q2);
        StacksAndQueues.removeAll(q2, "a");
        System.out.println(q2);
        System.out.println();

        Stack<String> s2;
        s2 = new LinkedStack<String>();
        s2.push ("a");
        s2.push ("b");
        s2.push ("c");
        s2.push ("a");
        s2.push ("b");
        s2.push ("c");
        s2.push ("a");
        s2.push ("b");
        s2.push ("c");
        System.out.println("remove All a for Stack");
        System.out.println(s2);
        StacksAndQueues.removeAll(s2, "a");
        System.out.println(s2);
        System.out.println();

        Queue<String> q3;
        q3 = new LinkedQueue<String>();
        q3.enqueue ("a");
        q3.enqueue ("b");
        q3.enqueue ("c");
        q3.enqueue ("a");
        q3.enqueue ("b");
        q3.enqueue ("c");
        q3.enqueue ("a");
        q3.enqueue ("b");
        q3.enqueue ("c");
        System.out.println("remove First a for Queue - Scenario 1");
        System.out.println(q3);
        StacksAndQueues.removeFirst(q3, "a");
        System.out.println(q3);
        System.out.println();

        //removeFirst queue 2e exemple
        Queue<String> q4;
        q4 = new LinkedQueue<String>();
        q4.enqueue ("a");
        q4.enqueue ("b");
        q4.enqueue ("c");
        q4.enqueue ("a");
        q4.enqueue ("b");
        q4.enqueue ("c");
        q4.enqueue ("a");
        q4.enqueue ("b");
        q4.enqueue ("c");
        System.out.println("remove First b for Queue - Scenario 2");
        System.out.println(q4);
        StacksAndQueues.removeFirst(q4, "b");
        System.out.println(q4);
        System.out.println();

        Stack<String> s3;
        s3 = new LinkedStack<String>();
        s3.push ("a");
        s3.push ("b");
        s3.push ("c");
        s3.push ("a");
        s3.push ("b");
        s3.push ("c");
        s3.push ("a");
        s3.push ("b");
        s3.push ("c");
        System.out.println("remove First c for Stack - Scenario 1");
        System.out.println(s3);
        StacksAndQueues.removeFirst(s3, "c");
        System.out.println(s3);
        System.out.println();

        //removeFirst stack 2e exemple
        Stack<String> s4;
        s4 = new LinkedStack<String>();
        s4.push ("a");
        s4.push ("b");
        s4.push ("c");
        s4.push ("a");
        s4.push ("b");
        s4.push ("c");
        s4.push ("a");
        s4.push ("b");
        s4.push ("c");
        System.out.println("remove First b for Stack - Scenario 2");
        System.out.println(s4);
        StacksAndQueues.removeFirst(s4, "b");
        System.out.println(s4);
        System.out.println();
    }
}