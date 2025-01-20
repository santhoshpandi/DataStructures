import java.util.*;

public class arrayList {
  public static void main(String[] args) {
    ArrayList<Integer> ar = new ArrayList<>();

    //Insert
    ar.add(25);
    ar.add(234);
    ar.add(456);
    ar.add(55);

    //Changing the element
    ar.set(1,999);

    System.out.println(ar);

    //Delete
    ar.remove(2);

    //Print
    for(int i:ar) System.out.println(i);
    System.out.println("---");
    for(int i=0;i<ar.size();i++) System.out.println(ar.get(i));

    //Sorting
    Collections.sort(ar);
    System.out.println(ar);
    
  }
}