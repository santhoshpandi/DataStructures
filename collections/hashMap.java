import java.util.*;

class hashMap {
  public static void main(String[] args) {
    Map<String, Integer> m = new HashMap<>();

    //Insert
    m.put("John", 25);
    m.put("Jane", 30);
    m.put("Jim", 35);
    System.out.println(m);

    //Update
    m.put("Jim",400);
    System.out.println("After Updation -> "+m);

    //Display 
    for(String key: m.keySet()) System.out.println(key);
    for(int value: m.values()) System.out.println(value);

    System.out.println("Displaying values using ForEach");
    m.forEach((k,v)-> {
      System.out.println(k+" "+v);
    });

    //Remove
    m.remove("Jim");
    System.out.println("After Removing -> "+m);

    //Other methods containsKey(), containsValue(), get(key)

    
  }
}