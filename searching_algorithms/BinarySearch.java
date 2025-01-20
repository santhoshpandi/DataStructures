import java.util.*;
public class BinarySearch {

  public int binarySearch(int key,int[] ar){
    
    int low=0,high=ar.length-1;

    while(low<=high){
      int mid = low + (high - low)/2;
      if(ar[mid]==key) return mid+1;
      else if(key > ar[mid]) low = mid+1;
      else high = mid-1; 
    }

    return -1;
  }
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    BinarySearch b = new BinarySearch();
    Scanner c = new Scanner(System.in);
    int[] ar = {2, 3, 4, 10, 40,50,100,200};
    int pos = b.binarySearch(c.nextInt(),ar); 

    if(pos ==-1){
      System.out.println("Element Not Found");
    }    
    else{
      System.out.println("Element Found at Position "+pos);
    }
  }
}
