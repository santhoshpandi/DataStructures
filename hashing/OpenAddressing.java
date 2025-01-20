class OpenAddressing{
  int m=5,n=0;
  int[] table = new int[m];

  //Hash Function
  private int hash(int key){
    return key%table.length;
  }

  //Used for Double hashing
  private int secondHash(int key){
    // Avoid returning '0' and 'table length'
    return 1+ (key % (table.length-1));
  }
  
  public void insert(int key){
    int idx,hashValue;
    idx = hashValue = hash(key);
    int step=1;
    
    if(n>=m){ 
      System.out.println("Table is Full");
      return;
    }
    //table[idx]=-1 represents the deleted box..
    while(table[idx]!=0 && table[idx] != -1){
      //Linear Probing
      idx = (hashValue + step) % table.length;

      //Quadratic Probing --> idx = (hashValue + (step * step)) % table.length;
      //Double Hashing --> idx = (hashValue + (step * secondHash(key))) % table.length;
      step++;
      if(idx<0) idx+=table.length;
    }

    //Storing the value
    table[idx]=key;
    n++;
    display();
  }

  public void search(int key){
    int idx,hashValue;
    idx = hashValue = hash(key);
    int step=1;
    while(table[idx]!=0){
      if(table[idx] == key){
        System.out.println("Key Found at "+ idx);
        return;
      }

      //Change here for other probing options (Quadratic probing or Double hashing)
      idx = (hashValue + step) % table.length;
      step++;      

      //To prevent infinite loop, when all tables occupied..
      if(step > table.length) break;
    }

    System.out.println("key not Found");
  }
  
  public void delete(int key){
    int idx,hashValue,step=1;

    idx = hashValue = hash(key);

    while(table[idx]!=0){
      if(table[idx] == key){
        table[idx]=-1;
        n--;
        System.out.println(key+" Deleted");   
        display();     
        return;
      }

      //Change here for other probing options (Quadratic probing or Double hashing)
      idx = (hashValue + step) % table.length;
      step++;

      //To prevent infinite loop, when all tables occupied..
      if(step > table.length) break;
    }

    System.out.println("Key not Found for Deletion");
  }

  public void display(){
    System.out.println("\n\n/// Hash Table ///\n--------");
    for(int i:table){
      if(i!=0) System.out.println(i);
      else System.out.println("EMPTY");
      System.out.println("--------");
    }
  }
  public static void main(String[] args) {
    OpenAddressing l = new OpenAddressing();
    l.insert(30);
    l.insert(32);
    l.insert(43);
    l.insert(41);
    l.insert(42);

    l.search(42);

    l.delete(30);
    l.delete(42);

    l.insert(55);
    l.insert(98);
    System.out.println();
  }
}