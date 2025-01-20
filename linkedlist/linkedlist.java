import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        this.data=d;
        this.next=null;
    }
}

public class linkedlist {    
    Node head=null,tail=null;

    public void insertAtBeg(int d){
      Node newNode = new Node(d);
      if(head==null){
        head=newNode;
        tail = head;
      }
      else{
        newNode.next = head;
        head = newNode;
      }
      display();
    }

    public void insertAtPos(int d,int pos){
        Node newNode = new Node(d);

        if(pos==1){
            newNode.next = head;
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp!=null){
                if(--pos==1){
                    newNode.next = temp.next;
                    temp.next = newNode;
                    if(newNode.next == null) tail = newNode;
                }
                temp = temp.next;
            }
            if(pos>0) System.out.println("position is too Long");
        }
       
        display();
    }

    public void insertAtEnd(int d){
        Node newNode = new Node(d);
        if(head==null){
            head=newNode;
            tail=head;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        display();
    }
    
    public void deletes(int pos){
        if(head == null){
            System.out.println("List Empty");
        }
        else if(pos == 1){
            head = head.next;
            if(head==null) tail = null;
        }
        else{
            Node temp = head;
            while(temp!=null && temp.next!=null){
                if(--pos == 1){
                    //It points the previous node
                    temp.next = temp.next.next;
                    if(temp.next == null) tail = null;
                }
                temp = temp.next;
            }
            if(pos > 0) System.out.println("position is too Long");
        }        
        display();
    }

    public void display(){
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
    
    public int findElementByPosition(int pos){
        if(head==null){
            return -1;
        }
        else{
            Node temp = head;
            while(temp!=null){
                if(--pos==0) return temp.data;
                temp = temp.next;
            }
        }
        return -1;
    }

    public void clearConsole(){
        for(int var = 0; var < 3; ++var) {
            System.out.println();
         } 
    }
    
    @SuppressWarnings("resource")
    public static void main(String[] args) { 
        Scanner c = new Scanner(System.in);
        linkedlist l = new linkedlist();   
        l.clearConsole();
       
        while(true){
            System.out.println("1.Insert Beg 2.Insert Mid 3.Insert End 4.Delete 5.Display 6.Find Element By Position 7.Exits");
            int choice = c.nextInt();
            switch (choice) {
                case 1: l.insertAtBeg(c.nextInt()); break;
                case 2: l.insertAtPos(c.nextInt(), c.nextInt()); break;
                case 3: l.insertAtEnd(c.nextInt()); break;
                case 4: l.deletes(c.nextInt()); break;
                case 5: l.display(); break;
                case 6: System.out.println(l.findElementByPosition(c.nextInt())); break;
                case 7:  return;
                default: return;
            }
        }

       
      
    }
}
