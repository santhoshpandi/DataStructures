import java.util.*;

class Node {
  int data;
  Node next;

  Node(int d) {
    this.data = d;
    this.next = null;
  }
}

public class stack {
  Node head;

  public void push(int d) {
    Node newNode = new Node(d);
    newNode.next = head;
    head = newNode;
    display();
  }

  public void pop() {
    if (head == null)
      System.out.println("--- Stack Underflow ---");
    else {
      head = head.next;
      display();
    }
  }

  public int peek() {
    if (head == null) return -1;
    else return head.data;
  }

  public int sizeOf() {
    int cnt = 0;
    if(head == null) cnt=-1;
    else{
      Node temp = head;
      while(temp!=null){
        cnt++; temp=temp.next;
      }
    }
    return cnt;
  }

  public void display() {
    Node temp = head;
    if (temp == null)
      System.out.println("--- Stack Empty ---");
    System.out.println("-------");
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
    System.out.println("-------");
  }

  public static void main(String[] args) {
    stack s = new stack();
    Scanner c = new Scanner(System.in);
    // Printing new Lines in Console
    for (int i = 0; i < 5; i++)
      System.out.println();
    while (true) {
      System.out.println("1.Push 2.Pop 3.Peek 4.SizeOf 5.Display 6.Exit");
      int choice = c.nextInt();

      switch (choice) {
        case 1: s.push(c.nextInt()); break;
        case 2: s.pop(); break;
        case 3: System.out.println(s.peek()); break;
        case 4: System.out.println(s.sizeOf()); break;
        case 5: s.display(); break;
        case 6: return;
        default: return;
      }
    }
  }
}
