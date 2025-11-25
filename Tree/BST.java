import java.util.Scanner;
class node{
int data;
node right, left, temp;
int count = 1;

Scanner sc = new Scanner(System.in);

void create(node ptr){
count++;
node newNode = new node();
System.out.print("Enter your Data: ");
newNode.data = sc.nextInt();
newNode.right = null;
newNode.left = null;

while(ptr != null){

if(newNode.data<ptr.data){
	temp = ptr;
	ptr = ptr.left;
}

else{
	temp = ptr;
	ptr = ptr.right;

}
}
if(newNode.data<temp.data){
	System.out.println("Data is at left. ");
	temp.left = newNode;

}
else{
	System.out.println("Data is at Right. ");
	temp.right = newNode;

}

}


void preOrder(node ptr){
if(ptr!=null){
	System.out.print(ptr.data + "\t");
	preOrder(ptr.left);
	preOrder(ptr.right);
}}

void inOrder(node ptr){

if(ptr!=null){

	inOrder(ptr.left);
	System.out.print(ptr.data + "\t");
	inOrder(ptr.right);

}}

void postOrder(node ptr){
if(ptr!=null){

	postOrder(ptr.left);
	postOrder(ptr.right);
System.out.print(ptr.data + "\t");
}}

void showCount(){

	System.out.println("Total Nodes :" + count);
}

void showMin(node ptr){
    if(ptr == null){
        System.out.println("Tree is empty");
        return;
    }
    while(ptr.left != null){
        ptr = ptr.left;
    }
    System.out.println("Minimum value: " + ptr.data);
}

void showMax(node ptr){
    if(ptr == null){
        System.out.println("Tree is empty");
        return;
    }
    while(ptr.right != null){
        ptr = ptr.right;
    }
    System.out.println("Maximum value : " + ptr.data);
}

}

public class BST {
public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
node obj = new node();

 System.out.print("Enter root data: ");
 node root = new node();
 root.data = sc.nextInt();
 root.right = null;
 root.left = null;
boolean isExit = false;
   while (!isExit) {
    System.out.println("\n--- MENU ---");
    System.out.println("[1] Add Node");
    System.out.println("[2] Preorder Traversal");
    System.out.println("[3] Inorder Traversal");
    System.out.println("[4] Postorder Traversal");
    System.out.println("[5] Show Count");
    System.out.println("[6] Show Minimum");
    System.out.println("[7] Show Maximum");
    System.out.println("[8] Exit");
    System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.create(root);
                    break;
                case 2:
                    System.out.println("Preorder Traversal:");
                    obj.preOrder(root);
                    break;
                case 3:
                    System.out.println("Inorder Traversal:");
                    obj.inOrder(root);
                    break;
                case 4:
                    System.out.println("Postorder Traversal:");
                    obj.postOrder(root);
                    break;
                case 5:
                    obj.showCount();
                    break;
                case 6:
                    obj.showMin(root);
                    break;
                case 7:
                    obj.showMax(root);
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        sc.close();
    }
}
