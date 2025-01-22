import java.util.Scanner;
class Node{
  int data;
  Node left,right;
  Node(int d){
    this.data = d;
    left = right =null;
  }
}

public class BinarySearchTree {

  Node root;

  public void insert(int data){
    Node newNode = new Node(data);
    if(root == null){
      root=newNode;
    }
    else{
      Node curr=root;
      Node parent = null;
      while(curr!=null)
      {
        //Maintains the previous parent pointer
        parent=curr;

        if(newNode.data < curr.data) curr=curr.left;
        else if(newNode.data > curr.data) curr=curr.right;
      }
      
      if(newNode.data < parent.data) parent.left=newNode;
      else parent.right=newNode;
    }

    inOrder(root);
  }
  
  public void delete(int data){
    // Deletion Cases:
    // Leaf Node : Simply remove the node from the tree.
    // One Child: Remove the node and link its parent to its child.
    // Two Child: Find the inorder small (or predecessor), copy its value to the node to be deleted, and then delete the inorder small.

    if(root==null){
      System.out.println("Empty Tree");
      return;
    }

    Node curr=root,parent=null;
    while(curr!=null && curr.data!=data)
    {
      parent=curr;
      if(data < curr.data) curr=curr.left;
      else curr=curr.right;
    }

    if(curr==null){ System.out.println("Data Not found to be Deleted"); return; }

    //Case 1: No Child
    if(curr.left==null && curr.right==null){
      //root node
      if(curr == root) root=null;
      //left node
      else if(parent.left == curr) parent.left=null;
      //right node
      else parent.right=null;
    }

    //Case 2: One Child
    else if(curr.left==null || curr.right==null)
    {
      Node child = (curr.left!=null) ? curr.left : curr.right;

      if(curr==root) root=child;
      else if(parent.left==curr) parent.left = child;
      else parent.right=child;
    }

    //Case 3: Two Child
    else{
      Node small = curr.right;
      Node smallParent = curr;

      //Find Smallest node of right side of curr Node.
      while(small != null)
      {
        smallParent = small;
        small=small.left;
      }

      //Copy the smallest node value -> curr node
      curr.data = small.data;

      //Delete the smallest node
      if(smallParent.left == small) smallParent.left=small.left;
      else smallParent.right=small.right;
    }

    inOrder(root);
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
    BinarySearchTree b = new BinarySearchTree();
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
