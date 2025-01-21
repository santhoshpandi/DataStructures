import java.util.*;
public class hashSet {
  public static void main(String[] args) {
    HashSet<String> h = new HashSet<>();

    //Insert
    h.add("Apple");
    h.add("Orange");
    h.add("Apple"); //Duplicate value do not stored
    h.add("Banana");

    System.out.println(h);

    //Print
    for(String s:h) System.out.println(s);

    //Remove
    h.remove("Apple");
    System.out.println(h);

    //Contains
    System.out.println(h.contains("Banana"));

    //other methods size(), clear(), clone(), isEmpty()

  }
}
