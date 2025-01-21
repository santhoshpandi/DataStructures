import java.util.*;
public class linkedList {
  public static void main(String[] args) {
    LinkedList<String> l = new LinkedList<>();

    //Add
    l.add("Apple");
    l.add("Tomato");
    l.add("Banana");
    l.add("Orange");

    System.out.println(l);

    //Print
    for(String s:l) System.out.println(s);

    //Get specific index
    System.out.println("Getting value from index -> "+l.get(2));

    //Delete [ remove(), remove(index), remove(value) anything will work]
    l.remove(2);
    System.out.println("After removing index 2 -> "+l);


    //other methods for [get] getFirst(), getLast()
    //other methods for [add] addFirst(), addLast()
    //other methods for [remove] removeFirst(), removeLast()
  }
}
