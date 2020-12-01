import java.util.Scanner;

class Node { 
        int key; 
        Node left, right; 
		Scanner input = new Scanner(System.in);
		
        public Node(int item) { 
            key = item; 
            left = right = null; 
        }
		
    }
class BinarySearchTree {  
    Node root;
	
    void insert(int key) {
		root = insertRec(root, key); 
    } 
      

    Node insertRec(Node temp, int key) { 
  
  
        if (temp == null) {
            temp = new Node(key); 
            return temp; 
        } 
  
        if (key < temp.key) 
            temp.left = insertRec(temp.left, key); 
        else if (key > temp.key) 
            temp.right = insertRec(temp.right, key); 
		
        return temp; 
    } 
  
    void inorder()  { 
       inorderRec(root); 
    } 
  
    void inorderRec(Node root) { 
        if (root != null) { 
            System.out.println(root.key); 
            inorderRec(root.left); 
            inorderRec(root.right); 
        } 
    } 
}
public class Trees {
	public static void main(String[] args) { 
        BinarySearchTree tree = new BinarySearchTree();
		Scanner input = new Scanner(System.in);
  
		System.out.println("00- Exit");
		System.out.println("01- Insert");
		System.out.println("02- Display In Order:");
        
        System.out.println("\nSelect options value:[0 to exit]");
		int options = input.nextInt();
		
		while(options!=0) {
			switch(options) {
				case 1:
					System.out.println("Enter item Key: ");
					int item = input.nextInt();
					tree.insert(item);
					break;
				case 2:
					System.out.println("Trees Node:\n---------- ");
					tree.inorder();
					break;
				default:
				System.out.println("You entered incorrect options value, try again...!");
			}
				System.out.println("\nSelect options value: [0 to exit]");
				options = input.nextInt();
		}
    }
}