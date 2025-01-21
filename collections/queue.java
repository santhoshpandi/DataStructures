import java.util.*;
public class queue {
  public static void main(String[] args) {

    // Both Queue and Dequeue -> Linkedlist or ArrayDequeue    
    Queue<String> q = new ArrayDeque<>();

    //Enqueue (add(), offer())
    q.add("sun");
    q.add("mercury");
    q.add("earth");
    q.add("moon"); //if error -> return error
    q.offer("venus"); //if erorr -> return false

    System.out.println(q);

    //Dequeue (remove(), poll())
    q.remove(); //if empty -> return error
    q.poll(); //if empty -> return null

    System.out.println(q);

    //Peek
    System.out.println("Peeked element -> "+q.peek());

  }
}
