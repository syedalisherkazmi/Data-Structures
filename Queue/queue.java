import java.util.Scanner;
class queue{
	Scanner sc = new Scanner(System.in);
int data;
int size;
int front,rear;
int[] queue;

queue(int size){

	front=rear=-1;
	this.size=size;
    queue=new int[size];
}


void add(){


System.out.print("Enter the Data to add in Queue:");
data=sc.nextInt();

	if(rear==size-1){
		System.out.println("Stack overflow / Stack is full");


	}//if

	else if(front==-1 && rear==-1){
		front=rear=0;
		queue[rear]=data;
		System.out.println(data+" Added at " + rear +" Position in Queue.");

	}//else if

     else{
		rear++;
		queue[rear]=data;
		System.out.println(data+" Added at " + rear +" Position in Queue.");



	    }//else
	 }//add
void del(){int data;

	 	if(front==-1 && rear==-1){
	 		System.out.println("Stack empty / Stack is null.");
	 	}//if

	 	else if(front==rear){
	 		data=queue[front];
	 		front = rear =-1;
System.out.println("Queue is Empty ");
	 	}//else if

	      else{
            front++;
	 		data=queue[front];
	 		System.out.println(data+" Removed at " + front +" Position in Queue.");



	 }//else

}//del


void display() {
    if (front == -1 && rear == -1) {
        System.out.println("Queue is empty.");
    } else {
        System.out.println("Queue contents:");
        for (int i = front; i <= rear; i++) {
            System.out.println("Data " + queue[i] + " at position " + i);
        }
    }
}


void isFull(){
	if(rear==size-1){
			System.out.print("Stack overflow / Stack is full");
		front=rear=-1;

}//if

}//isFull
void isEmpty(){

if(front==-1 && rear==-1){
	 		System.out.print("Stack empty / Stack is null.");
	 	}//if
	}//isEmpty



public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the Size of Queue: ");
    int s = sc.nextInt();
    queue obj1 = new queue(s);
    char choice;
    boolean cond = true;

    while(cond) {
        System.out.println("\nChoose an operation:");
        System.out.println("[a] ADD DATA");
        System.out.println("[d] Display Data");
        System.out.println("[r] remove from front");
        System.out.println("[f] Retreive from front");
        System.out.println("[e] CHECK IF FULL/EMPTY");
        System.out.println("[x] EXIT");
        System.out.print("Enter your choice: ");
        choice = sc.next().charAt(0);

        switch(choice) {
            case 'a':
                obj1.add();
                break;
            case 'd':
                obj1.display();
                break;
            case 'r':
                obj1.del();
                break;
            case 'f':
            System.out.println(obj1.queue[0]);

                break;
            case 'e':
               obj1.isFull();
                obj1.isEmpty();
                break;
            case 'x':
                cond = false;
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

}
