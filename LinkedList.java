import java.util.*;

class node{
int data;
node next,first,prev,cur,temp;
Scanner sc = new Scanner(System.in);
node(){
	first = null;
}//constructor

void entry(){
	System.out.println("---------NODE ENTRY--------");
char ch ='y';
while(ch=='y' | ch =='Y'){

	node newNode = new node();
	System.out.print("Enter your Data: ");
	newNode.data = sc.nextInt();
	newNode.next=null;

	if(first==null){

	first=cur=newNode;

	}//if

	else{
        prev=cur;
		cur.next=newNode;
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

void insertTop(){
	node newNode = new node();
	System.out.println("---------INSERTION AT TOP--------");
	System.out.println("Enter the data of your node: ");
	newNode.data=sc.nextInt();
    newNode.next=first;
    first=newNode;
}
void insertLast(){
	node newNode = new node();
	System.out.println("---------INSERTION AT LAST--------");
    System.out.println("Enter the data of your node: ");
	newNode.data=sc.nextInt();
	cur.next=newNode;
	newNode.next=null;


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
		        count++;}//while
newNode.next = temp.next;
    temp.next = newNode;

    System.out.println("Node inserted successfully at position " + pos);
}//method

void delTop(){

	System.out.println("---------Deletion at TOP Index--------");
    if(first==null){
		System.out.println("List is Empty");
   }
   else{
    node temp=first.next;
    first.next=null;
    first=temp;
}
	}

void delLast(){
System.out.println("---------Deletion at Last Index--------");
if(first==null){
		System.out.println("List is Empty");
   }
   else{
	  prev.next=null;

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
   }
   else{
	   node temp=first;
	   while(temp!=null){
		   if(element==temp.data){
			  System.out.println("Element "+temp.data+" FOUND at "+count+" position");
              found=true;
		   }

     temp=temp.next;
     count++;

	   }
if(found!=true){
	System.out.println("Element NOT FOUND.");
}

   }}








}//class

public class LinkedList{
	public static void main(String [] args){

		node obj1 = new node();
        node obj2 = new node();
        node obj3 = new node();
		obj1.entry();
		obj1.displayLinkedList();
		obj1.entry();
		obj2.displayLinkedList();
		//obj.insertTop();
        //obj.displayLinkedList();
        //obj.insertLast();
        //obj.displayLinkedList();
        //obj.insertMid();
        //obj.displayLinkedList();
        //obj.delTop();
        //obj.displayLinkedList();
        //obj.delLast();
        //obj.displayLinkedList();
        //obj.getElement();


	}//main
}//class