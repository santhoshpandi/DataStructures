class MergeSort{

  public static void merge(int[] ar,int low,int mid,int high){
    
    int[] leftArr = new int[mid-low+1];
    int[] rightArr = new int[high-(mid+1)+1];

    int i=0,j=0,k=low;
    for(i=0;i<leftArr.length;i++) leftArr[i] = ar[k++];
    for(j=0;j<rightArr.length;j++) rightArr[j] = ar[k++];

    i=0; j=0; k=low;
    while(i<leftArr.length && j<rightArr.length){
      if(leftArr[i]<rightArr[j]) ar[k++] = leftArr[i++];
      else ar[k++] = rightArr[j++];
    }

    for(;i<leftArr.length;i++) ar[k++] = leftArr[i];
    for(;j<rightArr.length;j++) ar[k++] = rightArr[j];

  }
  public static void mergeSort(int[] ar,int low,int high){
    if(low<high){
      int mid = (low+high)/2;
      mergeSort(ar, low, mid);
      mergeSort(ar, mid+1, high);
      merge(ar,low,mid,high);
    }
  }
  public static void main(String[] args) {
    int[] ar = {34,23,56,100,90,3,20,1};

    mergeSort(ar,0,ar.length-1);

    for(int i:ar) System.out.print(i+" ");
    System.out.println();
  }
}