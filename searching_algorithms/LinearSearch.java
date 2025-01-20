import java.util.*;
public class LinearSearch {

  public int linearSearch(int key,int[] ar){
    for(int i=0;i<ar.length;i++){
      if(key == ar[i]) return i+1; 
    }
    return -1;
  }
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    LinearSearch l = new LinearSearch();
    Scanner c = new Scanner(System.in);
    int[] ar = {23,34,45,12,10,2};
    int pos = l.linearSearch(c.nextInt(),ar); 
    if(pos ==-1){
      System.out.println("Element Not Found");
    }    
    else{
      System.out.println("Element Found at Position "+pos);
    }
  }
}
