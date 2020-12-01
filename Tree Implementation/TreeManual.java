package treemanual;
import java.util.Scanner;

class Node {
	int id;
	String name;
	Node left,right;
	
	Scanner input = new Scanner(System.in);
	
	void userInput() {
		System.out.print("Please enter id number: ");
		id = input.nextInt();
                System.out.print("Please enter user name: ");
                input.nextLine();
                name = input.nextLine();
	}
}

class Functions {
	Node root;
	Scanner input = new Scanner(System.in);
	
	void insert() {
		Node user = new Node();
		user.userInput();
		Node current;
		Node parent;
		if(root == null) {
			root = user;
		}
		else {
			current = root;
			while(true) {
				parent = current;
				if(user.id <= parent.id) {
                                    current = current.left;
					if(current == null) {
						parent.left = user;
						return;
					}
				}
				else {
                                    current = current.right;
					if(current == null) {
						parent.right = user;
						return;
					}
				}
			}
		}
	}
	
	void search () {
		Node current = root;
		if(root == null) {
			System.out.print("tree is empty..");
			return;
		}
		System.out.print("Plese enter id that you want to search: ");
		int data = input.nextInt();
		
		while(true) {
                    if(current.id != data) {
				if(current.id > data)
					current = current.left;
                                else if(current.id < data){
					current = current.right;
				}                    }
                    else if(current.id == data){
                        System.out.print("Your search has been found: " + current.id);
                        return;
                    }
                    if(current == null) {
                        System.out.println("that item not found...");
                        return;
                    }
            }
        }
	void display() {
		
		if(root == null) {
			System.out.println("tree is empty...");
		}
		
		else {
			while (true) {
				System.out.println("[-1] PreOrderLTR:\n"
                                        + "[+1] PreOrderRTL:\n"
                                        + "[-2] InOrderLTR\n"
                                        + "[+2] InOrderRTL\n"
                                        + "[-3] PostOrderLTR\n"
                                        + "[+3] PostOrderRTL");
				System.out.println("Select order option: ");
				int order = input.nextInt();
				if (order == -1) {
                                        System.out.println("PreOrder Left to Right format: {(root),(left),(right)}");
					preOrderLTR(root);
				}
                                else if (order == 1) {
                                        System.out.println("PreOrder Right to Left format: {(root),(right),(left)}");
					preOrderRTL(root);
				}
				else if (order == -2) {
                                        System.out.println("InOrder Left to Right format: {(left),(root),(right)}");
					inOrderLTR(root);
				}
                                else if (order == 2) {
                                        System.out.println("InOrder Right to Left format: {(right),(root),(left)}");
					inOrderRTL(root);
				}
				else if (order == -3) {
                                        System.out.println("PostOrder Left to Right format: {(left),(right),(root)}");
					postOrderLTR(root);
				}
                                else if (order == 3) {
                                        System.out.println("PostOrder Right to Left format: {(right),(left),(root)}");
					postOrderRTL(root);
				}
				else {
					System.out.println("Wrong selection ... select right option...");
				}
				return;
			}
		}
	}
	
	void preOrderLTR(Node temp) {
		if (temp == null) {
			return;
		}
		
		System.out.println("{ id: ( " + temp.id + " ); name: ( " + temp.name + " ); }");
		preOrderLTR(temp.left);
		preOrderLTR(temp.right);
	}
        
        void preOrderRTL(Node temp) {
		if (temp == null) {
			return;
		}
		
		System.out.println("{ id: ( " + temp.id + " ); name: ( " + temp.name + " ); }");
		preOrderRTL(temp.right);
		preOrderRTL(temp.left);
	}
	
	void inOrderLTR(Node temp) {
		if (temp == null) {
			return;
		}
		
		inOrderLTR(temp.left);
		System.out.println("{ id: ( " + temp.id + " ); name: ( " + temp.name + " ); }");
		inOrderLTR(temp.right);
	}
        
        void inOrderRTL(Node temp) {
		if (temp == null) {
			return;
		}
		
		inOrderLTR(temp.right);
		System.out.println("{ id: ( " + temp.id + " ); name: ( " + temp.name + " ); }");
		inOrderLTR(temp.left);
	}
	
	void postOrderLTR(Node temp) {
		if (temp == null) {
			return;
		}
		
		postOrderLTR(temp.left);
		postOrderLTR(temp.right);
		System.out.println("{ id: ( " + temp.id + " ); name: ( " + temp.name + " ); }");
	}
        void postOrderRTL(Node temp) {
		if (temp == null) {
			return;
		}
		
		postOrderRTL(temp.left);
		postOrderRTL(temp.right);
		System.out.println("{ id: ( " + temp.id + " ); name: ( " + temp.name + " ); }");
	}
}

public class TreeManual {
	public static void main(String args[]) {
		Functions ft = new Functions();
		
		Scanner input = new Scanner(System.in);
		
		boolean options = true;
		
		while(options) {
			System.out.println("\n00: Exit\n"
			+ "01: insert Tree Node\n"
			+ "02: Node display\n"
			+ "03: Search Node");
			
			int select = input.nextInt();
			
			switch(select) {
				case 0:
					options = false;
					break;
				case 1:
					ft.insert();
					break;
				case 2:
					ft.display();
					break;
				case 3:
					ft.search();
					break;
				default:
					System.out.println("please select right option: ");
			}
		}
	}
}