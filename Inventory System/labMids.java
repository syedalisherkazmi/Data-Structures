import java.util.Scanner;
class node{

	int partID;
	String Description;
	int quantity;
	int price;
	node next,newNode,head,cur,temp;
	 Scanner sc = new Scanner(System.in);
int tempQuann;
node(){
	head = null;
}

	void add(){
		newNode = new node();
        System.out.println("Enter part ID:");
        newNode.partID = sc.nextInt();
        System.out.println("Enter the Description:");
        newNode.Description = sc.next();
        int tempQuann;
		do {
		    System.out.println("Enter the Quantity:");
		    tempQuann = sc.nextInt();
		    if (tempQuann < 0) {
		        System.out.println("Quantity cannot be negative");
		    }
		    else{
				newNode.quantity = tempQuann;
			}
		} while (tempQuann < 0);//quantity check

        System.out.println("Enter part Price:");
        newNode.price = sc.nextInt();

        if(head==null){
        head=cur=newNode;

		}

		else{
			cur.next = newNode;
			cur = newNode;
		}

	}// add method

	void Analysis(){
		temp = new node();
      temp = head;

System.out.println("RECORDS ANALYSIS:");
    int flag = 0;
      while(temp!=null){

		  if(temp.quantity<50){
			  flag++;
			  System.out.println("Record NO:"+ flag);
			  System.out.println("part ID:"+ temp.partID);
			  System.out.println("Description:"+ temp.Description);
			  System.out.println("Quantity:"+ temp.quantity);
			  System.out.println("Price:"+ temp.price);
		  }//IF
		  if(flag==0){
			  System.out.println("NO RECORD FOUND");
		  }//IF

temp = temp.next;
	  }//WHILE
	}//ANALYSIS METHOD

	void displayRec(){
		temp = new node();
      temp = head;
      System.out.println("Enter Part Id:");
      int tempId = sc.nextInt();
      int flag= 0;
  while(temp!=null){
	  if(tempId == temp.partID){
		  flag =1;
		  System.out.println("RECORD FOUND:");
		  System.out.println("ADD MODIFIED VALUES:");

		          System.out.println("Enter part ID:");
		          temp.partID = sc.nextInt();
		          System.out.println("Enter the Description:");
		          newNode.Description = sc.next();

		          int tempQuann;
				  		do {
				  		    System.out.println("Enter the Quantity:");
				  		    tempQuann = sc.nextInt();
				  		    if (tempQuann < 0) {
				  		        System.out.println("Quantity cannot be negative");
				  		    }
				  		    else{
				  				temp.quantity = tempQuann;
				  			}
		} while (tempQuann < 0);//quantity check

		          System.out.println("Enter part Price:");
                  temp.price = sc.nextInt();

                   }//if

                   if(flag==0){
					  System.out.println("NO RECORD FOUND");

				   }
                temp = temp.next;
                }//while
	}//Method

	void salesUpdate(){
      temp = new node();
      temp = head;
      System.out.println("Enter Part Id:");
      int tempId = sc.nextInt();
      int flag= 0;
      System.out.println("Enter the Quantity TO BUY:");
      int tempQuantity = sc.nextInt();

 while(temp!=null){

		  if(tempId==temp.partID){
			  flag++;
			  System.out.println("\nRecord NO:"+ flag);
			 if(tempQuantity>temp.quantity)
			 {
				System.out.println("Quantity IS GREATER THAN STOCK");
			 }
			 else{
				 temp.quantity = tempQuantity - temp.quantity;
			     System.out.println("NEW Quantity:"+ temp.quantity);
		  }

		  }//IF
		  if(flag==0){
			  System.out.println("\nNO RECORD FOUND");
		  }//IF
    temp = temp.next;
	}//while
}//displayRec

}//class node

public class labMids{


public static void main(String [] args){

 Scanner sc = new Scanner(System.in);

node obj1 = new node();
boolean condition = true;
int choice;
while(condition==true){

 System.out.println("[1]ADD NODE:");
 System.out.println("[2]ANALYSIS OF RECORD:");
 System.out.println("[3]DISPLAY PARTICULAR RECORD:");
 System.out.println("[4]SALES UPDATE:");
 System.out.println("[5]Exit:");
  System.out.println("ENTER YOUR CHOICE:");
 choice = sc.nextInt();
switch(choice){
case 1:
obj1.add();
break;
case 2:
obj1.Analysis();
break;
case 3:
obj1.displayRec();
break;
case 4:
obj1.salesUpdate();
break;
case 5:
 System.out.println("Exiting....:");
condition = false;
break;
default:
 System.out.println("YOUR CHOICE IS INVALID");
}//while
}
}//main


}//class