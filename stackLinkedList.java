import java.util.*;

class node {
    int data;
    node next, top;
    Scanner sc = new Scanner(System.in);

    node() {
        top = null;
    }

    void push() {
        System.out.println("---------PUSH OPERATION--------");
        System.out.print("Enter data to push: ");
        int value = sc.nextInt();

        node newNode = new node();
        newNode.data = value;
        newNode.next = top;
        top = newNode;

        System.out.println(value + " pushed to stack.");
        display();
    }

    void pop() {
        System.out.println("---------POP OPERATION--------");
        if (top == null) {
            System.out.println("Stack Underflow! Nothing to pop.");
        } else {
            System.out.println(top.data + " popped from stack.");
            top = top.next;
            display();
        }
    }

    void peek() {
        System.out.println("---------PEEK OPERATION--------");
        if (top == null) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element is: " + top.data);
        }
    }

    void display() {
        System.out.println("---------STACK ELEMENTS--------");
        if (top == null) {
            System.out.println("Stack is empty.");
        } else {
            node temp = top;
            System.out.print("TOP → ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}

public class stackLinkedList {
    public static void main(String[] args) {
        node obj = new node();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== STACK USING LINKED LIST MENU ======");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.push();
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                    obj.peek();
                    break;
                case 4:
                    obj.display();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 5);
    }
}
