import java.util.*;

class node{
int data;
node next,first,back,prev,cur,temp;
Scanner sc = new Scanner(System.in);
node(){
	first = null;
	back = null;
}//constructor

void entry(){
	System.out.println("---------NODE ENTRY--------");
char ch ='y';
while(ch=='y' | ch =='Y'){

	node newNode = new node();
	System.out.print("Enter your Data: ");
	newNode.data = sc.nextInt();
	newNode.next=null;
	newNode.back=null;

	if(first==null){
	first=cur=newNode;
	}//if
	else{
        prev=cur;
		cur.next=newNode;
		newNode.back=cur;
		cur=newNode;
	}//else
System.out.println("Do you want a new node [y/n]:");
ch=sc.next().charAt(0);
}//while loop
}//method


void displayLinkedList() {
	System.out.print("---------Linked List--------");
    if (first == null) {
        System.out.println("The linked list is empty.");
        return;
    }

    node temp = first;
    while (temp != null) {
        System.out.print(temp.data);
        if (temp.next != null) {
            System.out.print(" -> ");
        }
        temp = temp.next;
    }
    System.out.println(); // Move to new line at end
}

void displayBackward() {
    if (first == null) {
        System.out.println("List is empty");
        return;
    }
    node temp = first;
    while (temp.next != null) temp = temp.next; // go to last
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.back;
    }
    System.out.println();
}


void insertTop(){
	node newNode = new node();
	System.out.println("---------INSERTION AT TOP--------");
	System.out.println("Enter the data of your node: ");
	newNode.data=sc.nextInt();
    newNode.next=first;
    first.back = newNode;
    newNode.back=null;
    first=newNode;
	displayLinkedList();
}
void insertLast(){
	node newNode = new node();
	System.out.println("---------INSERTION AT LAST--------");
    System.out.println("Enter the data of your node: ");
	newNode.data=sc.nextInt();
	cur.next=newNode;
	newNode.back=cur;
	newNode.next=null;
	displayLinkedList();
}

void insertMid(){
	node newNode = new node();
	System.out.println("---------INSERTION AT Any Index--------");
	System.out.println("Enter the Position: ");
	int pos = sc.nextInt();
	int count=1;
	System.out.println("Enter the data of your node: ");
	newNode.data=sc.nextInt();
	node temp=first;
	while (temp != null && count < pos - 1) {
		temp = temp.next;
		count++;
	}
	newNode.next = temp.next;
	newNode.back = temp;
	temp.next = newNode;
	System.out.println("Node inserted successfully at position " + pos);
	displayLinkedList();
}

void delTop(){
	System.out.println("---------Deletion at TOP Index--------");
    if(first==null){
		System.out.println("List is Empty");
   } else {
    node temp=first.next;
    first.next=null;
    temp.back=null;
    first=temp;
	displayLinkedList();
   }
}

void delLast(){
	System.out.println("---------Deletion at Last Index--------");
	if(first==null){
		System.out.println("List is Empty");
	} else {
		prev.next=null;
		cur.back=null;
		displayLinkedList();
	}
}

void getElement(){
	System.out.println("---------Find an element--------");
	System.out.println("Enter an Element To check :");
	int element=sc.nextInt();
    int count=1;
    boolean found=false;
	if(first==null){
		System.out.println("List is Empty");
   } else {
	   node temp=first;
	   while(temp!=null){
		   if(element==temp.data){
			  System.out.println("Element "+temp.data+" FOUND at "+count+" position");
              found=true;
		   }
		   temp=temp.next;
		   count++;
	   }
	   if(!found){
			System.out.println("Element NOT FOUND.");
	   }
   }
}
}//class


public class DoubleLinkedList{
	public static void main(String [] args){
		node obj = new node();  // only one object
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== DOUBLE LINKED LIST MENU ======");
            System.out.println("1. Create (Entry)");
            System.out.println("2. Display");
            System.out.println("3. Insert at Top");
            System.out.println("4. Insert at Last");
            System.out.println("5. Insert at Any Index");
            System.out.println("6. Delete at Top");
            System.out.println("7. Delete at Last");
            System.out.println("8. Search Element");
            System.out.println("9. Backward Display");
            System.out.println("10. Exit the Programm");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.entry();
                    obj.displayLinkedList();
                    break;
                case 2:
                    obj.displayLinkedList();
                    break;
                case 3:
                    obj.insertTop();
                    break;
                case 4:
                    obj.insertLast();
                    break;
                case 5:
                    obj.insertMid();
                    break;
                case 6:
                    obj.delTop();
                    break;
                case 7:
                    obj.delLast();
                    break;
                case 8:
                    obj.getElement();
                    break;
                case 9:
                    obj.displayBackward();
                    break;
                case 10:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 10);
	}
}
