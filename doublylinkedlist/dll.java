import java.util.*;

class Node{
  int data;
  Node prev,next;
  Node(int d){
    this.data = d;
  }
}

public class dll {

  Node head=null,tail=null;

    public void insertAtBeg(int d){
      Node newNode = new Node(d);
      if(head==null){
        head=newNode;
        tail = head;
      }
      else{
        newNode.next = head; head.prev = newNode;
        head = newNode;
      }
      displayFromHead();
    }

    public void insertAtPos(int d,int pos){
        Node newNode = new Node(d);
        
        if(pos == 1){
          // when position = 1
          insertAtBeg(d);
        }
        // when position = lastOne
        else if(pos == sizeOf(head)+1) insertAtEnd(d);
        else if(pos > sizeOf(head)+1) System.out.println("position too Long");
        else{
          Node temp = head;
          for(int i=1;i<pos-1;i++){
            temp = temp.next;
          }          
          newNode.next = temp.next; temp.next.prev = newNode;
          temp.next = newNode; newNode.prev = temp; 
        }       
        
        displayFromHead();
    }

    public void insertAtEnd(int d){
        Node newNode = new Node(d);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            tail.next=newNode; newNode.prev = tail;
            tail=newNode;
        }
        displayFromHead();
    }
    
    public void deletes(int pos){
       
      if(head == null) System.out.println();
      else if(pos == 1){
        head = head.next; 
        if(head != null) head.prev = null;
      }
      else if(pos == sizeOf(head)){
        tail = tail.prev; tail.next = null;
      }
      else if(pos > sizeOf(head)) System.out.println("position too Long");
      else{
        Node temp = head;
        for(int i=1;i<pos-1;i++) temp = temp.next;
        
        Node del = temp.next,aft = temp.next.next;
        temp.next = aft; aft.prev = temp;
        del.prev = null; del.next = null;
      }
        displayFromHead();
    }

    public int sizeOf(Node temp){
      int cnt = 0;
      while(temp!=null){
        cnt++; temp = temp.next;
      }
      return cnt;
    }

    public void displayFromHead(){
        Node temp = head;
        System.out.println("----------------------");
        if(temp==null){
            System.out.println("List Empty");
        }
        else{
            while(temp!=null){
                System.out.print(temp.data+" -> ");
                temp=temp.next;
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

    public void displayFromTail(){
      Node temp = tail;
      System.out.println("----------------------");
      if(temp==null){
          System.out.println("List Empty");
      }
      else{
          while(temp!=null){
              System.out.print(temp.data+" -> ");
              temp=temp.prev;
          }
          System.out.println();
      }
      System.out.println("----------------------");
    }
    
    public int findElementByPosition(int pos){
        if(head==null){
            return -1;
        }
        else if(pos > sizeOf(head)) System.out.println("position is too Long");
        else{
            Node temp = head;
            for(int i=0;i<pos-1;i++) temp = temp.next;
            return temp.data;
        }
        return -1;
    }

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner c = new Scanner(System.in);
    dll d = new dll();

    for(int i=0;i<5;i++) System.out.println();

    while(true){
      System.out.println("1.Insert Beg 2.Insert Mid 3.Insert End 4.Delete 5.displayFromHead 6.Find Element By Position 7.Exit");
      int choice = c.nextInt();
      switch (choice) {
          case 1: d.insertAtBeg(c.nextInt()); break;
          case 2: d.insertAtPos(c.nextInt(), c.nextInt()); break;
          case 3: d.insertAtEnd(c.nextInt()); break;
          case 4: d.deletes(c.nextInt()); break;
          case 5: d.displayFromHead(); break;
          case 8: d.displayFromTail(); break;
          case 6: System.out.println(d.findElementByPosition(c.nextInt())); break;
          case 7:  return;
          default: return;
      }
  }

  }
}
