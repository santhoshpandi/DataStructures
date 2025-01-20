class BubbleSort{

  public static void bubbleSort(int[] ar){
    for(int i=0;i<ar.length;i++){

      for(int j=0;j<ar.length-i-1;j++){
        if(ar[j]>ar[j+1]){
          int temp = ar[j];
          ar[j] = ar[j+1];
          ar[j+1] = temp;
        }
      }
    }
  }
  public static void main(String[] args) {
    int[] ar = {34,23,56,100,90,3,20,1};

    bubbleSort(ar);

    for(int i:ar) System.out.print(i+" ");
    System.out.println();
  }
}