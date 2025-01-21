import java.util.*;

public class dequeue {
  public static void main(String[] args) {
    ArrayDeque<String> ar = new ArrayDeque<>();

    //insert
    ar.addFirst("sun"); //add returns error (when error occurs)
    ar.addLast("moon");
    ar.offerFirst("galaxy"); //offer returns false (when error occurs)
    ar.offerLast("iphone");
    ar.offerFirst("moto");

    System.out.println(ar);

    //remove
    ar.removeFirst();
    ar.removeLast();
    ar.pollFirst();
    ar.pollLast();

    //Print
    for(String s:ar) System.out.println(s);

    //Peek
    System.out.println("Peeked element -> "+ar.peek());
  }
}
