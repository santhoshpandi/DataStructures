import java.util.*;
public class linkedlist {
  public static void main(String[] args) {
    LinkedList<String> l = new LinkedList<>();

    //Add
    l.add("Apple");
    l.add("Tomato");
    l.add("Banana");
    l.add("Orange");
    l.add(2,"Steak"); //dll insertion concept

    System.out.println(l);

    //Update
    l.set(2,"Cake");

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
