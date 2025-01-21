import java.util.*;
public class queue {
  public static void main(String[] args) {

    // Both Queue and Dequeue -> Linkedlist    
    Queue<String> q = new LinkedList<>();

    //Enqueue
    q.add("sun");
    q.add("mercury");
    q.add("earth");
    q.add("moon");

    System.out.println(q);

    //Dequeue 
    q.remove(); //if empty -> return error
    q.poll(); //if empty -> return null

    System.out.println(q);

    //Peek
    System.out.println("Peeked element -> "+q.peek());

  }
}
