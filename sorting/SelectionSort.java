public class SelectionSort {
  
  public static void selectionSort(int[] ar){
    for(int i=0;i<ar.length;i++){
      for(int j=i+1;j<ar.length;j++){
        if(ar[i]>ar[j]){
          int temp = ar[i];
          ar[i] = ar[j];
          ar[j] = temp;
        }
      }
    }
  }
  public static void main(String[] args) {
    int[] ar = {34,23,56,100,90,3,20,1};

    selectionSort(ar);

    for(int i:ar) System.out.print(i+" ");
    System.out.println();
  }
}
