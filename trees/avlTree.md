**An AVL Tree** is a self-balancing Binary Search Tree (BST) where the heights of two child subtrees of any node differ by no more than one.

To maintain this property, we perform rotations during insertions and deletions to keep the tree balanced. AVL Tree rotations are the key operations to ensure the tree remains balanced.
***
### Basic Operations in an AVL Tree: **O(log n)**

1.  **Insertion**: Insert a node like in a normal BST, but after insertion, check the balance factor of each ancestor node. If any node becomes unbalanced (i.e., the balance factor becomes more than 1 or less than -1), perform the appropriate rotation to restore balance.
    
2.  **Balancing**: If a node becomes unbalanced, we perform one of the following rotations:
    
    *   **Left-Left (LL)**: Single right rotation.
        
    *   **Right-Right (RR)**: Single left rotation.
        
    *   **Left-Right (LR)**: Left rotation followed by right rotation.
        
    *   **Right-Left (RL)**: Right rotation followed by left rotation.
        
3.  javaCopyBalance Factor = height(left subtree) - height(right subtree)If the balance factor is:
    
    *   \> 1: Left-heavy (needs rotation)
        
    *   < -1: Right-heavy (needs rotation)
        
    *   \= 0: Balanced
        
4.  **Height Calculation**: The height of a node is the number of edges on the longest path from that node to a leaf.

### Code Implementation

```
class Node {
    int data;
    Node left, right;
    int height; // height of the node

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
        this.height = 1; // new node has height 1
    }
}

public class AVLTree {
    private Node root;

    // Get the height of the node
    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Get balance factor of a node
    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Right rotation
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // new root
    }

    // Left rotation
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // new root
    }

    // Insert a node iteratively
    public void insert(int data) {
        root = insertIteratively(root, data);
    }

    private Node insertIteratively(Node root, int data) {
        Node newNode = new Node(data);

        // Step 1: Perform standard BST insertion
        if (root == null) {
            root = newNode;
            return root;
        }

        Node parent = null, current = root;
        while (current != null) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                // Duplicate values are not allowed in this implementation
                return root;
            }
        }

        // Insert new node as a child of parent node
        if (data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        // Step 2: Re-balance the tree
        return rebalanceAfterInsertion(root, newNode);
    }

    // Re-balance the tree starting from the inserted node's parent
    private Node rebalanceAfterInsertion(Node root, Node newNode) {
        Node current = root;
        
        // Traverse upwards to the root to fix balance
        while (current != null) {
            int balance = getBalanceFactor(current);
            // Left heavy
            if (balance > 1) {
                if (getBalanceFactor(current.left) >= 0) {
                    // Left-Left (LL) case
                    current = rightRotate(current);
                } else {
                    // Left-Right (LR) case
                    current.left = leftRotate(current.left);
                    current = rightRotate(current);
                }
            }
            // Right heavy
            else if (balance < -1) {
                if (getBalanceFactor(current.right) <= 0) {
                    // Right-Right (RR) case
                    current = leftRotate(current);
                } else {
                    // Right-Left (RL) case
                    current.right = rightRotate(current.right);
                    current = leftRotate(current);
                }
            }

            // Update height after each rotation
            current.height = Math.max(height(current.left), height(current.right)) + 1;

            if (current == newNode) {
                break;
            }
            current = current == current.parent.left ? current.parent : current.parent.right;
        }

        return current;
    }

    // Inorder Traversal (non-recursive)
    public void inOrder() {
        inOrderIterative(root);
    }

    private void inOrderIterative(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.data + " -> ");
            curr = curr.right;
        }
    }

    // Main function for testing
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("Inorder Traversal of AVL Tree:");
        tree.inOrder(); // Expected balanced tree output
    }
}

```