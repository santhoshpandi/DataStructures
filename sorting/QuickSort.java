public class QuickSort {

  public static int partition(int[] ar,int low,int high){
    int pivot = low, i=low, j=high;
    while(i < j){
      while(ar[i]<=ar[pivot] && i<high) i++;
      while(ar[j]>ar[pivot]) j--;
      if(i<j){
        //swap a[i], a[j]
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
      }
    }    
    //swap a[j], a[pivot]
    int temp = ar[j];
    ar[j] = ar[pivot];
    ar[pivot] = temp;

    //j contains the pivot element
    return j;    
  }

  public static void quickSort(int[] ar,int low,int high){
    if(low < high){
      int pivot = partition(ar, low, high);
      quickSort(ar, low, pivot-1);
      quickSort(ar, pivot+1, high);
    }
  }
  public static void main(String[] args) {
    int[] ar = {31,23,56,100,23,90,3,20,5,51};

    quickSort(ar,0,ar.length-1);

    for(int i:ar) System.out.print(i+" ");
    System.out.println();
  }
}
