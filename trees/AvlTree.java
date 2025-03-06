import java.util.Scanner;
class Node{
  int data;
  Node left,right;
  int height;

  Node(int d){
    this.data = d;
    this.left = this.right =null;
    this.height=1;
  }
}

public class AvlTree {
  Node root;

  //Height of the tree
  public int getHeight(Node node)
  {
    if(node==null) return 0;
    else return node.height;
  }

  //Balance factor of node ( left Height - right Height )
  public int getBF(Node node){
    if(node==null) return 0;
    else return( getHeight(node.left) - getHeight(node.right));
  }

  public void leftRotate(Node x)
  {
    Node y = x.right;
    Node T2 = y.left;

    //perform rotation
    y.left = x;
    x.right = T2;

    //update height
    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

  }

  public void insert(int data)
  {

  }

  public void delete(int data)
  {

  }

  public void search(int data){
    if(root==null) System.out.println("Empty Tree");
    
    Node curr=root;
    while(curr!=null){
      if(curr.data == data) 
      {
        System.out.println("Data found");
        return;
      }
      else if(data < curr.data) curr=curr.left;
      else curr=curr.right;
    }
    System.out.println("Data Not found");
  }

  public void inOrder(Node root){
    if(root!=null)
    {
      inOrder(root.left);
      System.out.print(root.data+" -> ");
      inOrder(root.right);
    }
  }

  public void preOrder(Node root){
    if(root!=null)
    {
      System.out.print(root.data+" -> ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  public void postOrder(Node root){
    if(root!=null)
    {
      postOrder(root.left);
      postOrder(root.right);
      System.out.print(root.data+" -> ");
    }
  }

  public static void main(String[] args) {
    AvlTree b = new AvlTree();
    Scanner c = new Scanner(System.in);

    while(true)
    {
      System.out.println("\n\n1.Insert 2.Delete 3.Search 4.Display 5.Exit");
      int choice = c.nextInt();
      switch(choice)
      {
        case 1: b.insert(c.nextInt()); break;
        case 2: b.delete(c.nextInt()); break;
        case 3: b.search(c.nextInt()); break;
        case 4:
        {
          System.out.println("1.InOrder 2.PreOrder 3.PostOrder");
          int ch = c.nextInt();
          switch(ch)
          {
            case 1: b.inOrder(b.root); break;
            case 2: b.preOrder(b.root); break;
            case 3: b.postOrder(b.root); break;
          }
        }
        case 5: return;
        default: return;
      }
    }
  }
}
