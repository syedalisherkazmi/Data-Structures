import java.util.*;
import java.io.*;

class node {
    String zone;
    int timberId;
    String kind;
    float weight;
    String status;
    float height;
    int quantity;
    int price;
    Date cutDate;
    node next;

    // Stack Top pointer
    node top = null;

    Scanner sc = new Scanner(System.in);

    // ---------------- PUSH OPERATION ----------------
    void push() {
        node newNode = new node();

        System.out.println("......Enter the details of timber......\n");

        System.out.print("Zone:   ");
        newNode.zone = sc.next();

        System.out.print("Id:   ");
        newNode.timberId = sc.nextInt();

        System.out.print("Kind:    ");
        newNode.kind = sc.next();

        System.out.print("Status:    ");
        newNode.status = sc.next();

        System.out.print("Quantity:    ");
        newNode.quantity = sc.nextInt();

        System.out.print("Height(m):  ");
        newNode.height = sc.nextFloat();

        System.out.print("Weight(kg):   ");
        newNode.weight = sc.nextFloat();

        System.out.print("Price(PKR):    ");
        newNode.price = sc.nextInt();

        newNode.cutDate = new Date();
        System.out.println("Cut Date: " + newNode.cutDate);

        // Stack push: add at top
        newNode.next = top;
        top = newNode;

        System.out.println("Record pushed successfully onto stack!");
    }

    // ---------------- POP OPERATION ----------------
    void pop() {
        if (top == null) {
            System.out.println("Stack is empty. No record to pop.");
            return;
        }

        System.out.println("Popped record:");
        display(top);
        top = top.next;
    }

    // ---------------- PEEK OPERATION ----------------
    void peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top record in the stack:");
        display(top);
    }

    // ---------------- DISPLAY STACK ----------------
    void displayAll() {
        if (top == null) {
            System.out.println("Stack is empty. No records to display.");
            return;
        }

        System.out.println("\n---------- TIMBER STACK RECORDS ----------");
        node temp = top;
        int count = 0;
        while (temp != null) {
            display(temp);
            temp = temp.next;
            count++;
        }
        System.out.println("Total records: " + count);
    }

    // ---------------- DISPLAY ONE RECORD ----------------
    void display(node node) {
        System.out.println("------------------------------------------");
        System.out.println("Zone: " + node.zone);
        System.out.println("ID: " + node.timberId);
        System.out.println("Kind: " + node.kind);
        System.out.println("Weight(kg): " + node.weight);
        System.out.println("Status: " + node.status);
        System.out.println("Height(m): " + node.height);
        System.out.println("Quantity: " + node.quantity);
        System.out.println("Price(PKR): " + node.price);
        System.out.println("Cut Date: " + node.cutDate);
        System.out.println("------------------------------------------");
    }

    // ---------------- SEARCH ----------------
    void searchById() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Enter the ID to search: ");
        int id = sc.nextInt();

        node temp = top;
        int found = 0;

        while (temp != null) {
            if (temp.timberId == id) {
                display(temp);
                found = 1;
                break;
            }
            temp = temp.next;
        }

        if (found == 0) {
            System.out.println("No record found with ID " + id);
        }
    }

    // ---------------- WRITE TO FILE ----------------
    void writeToFile() {
        try {
            FileWriter fw = new FileWriter("Timber_Stack_Data.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            if (top == null) {
                bw.write("No records in the stack.\n");
            } else {
                node temp = top;
                bw.write(String.format("%-10s %-6s %-15s %-10s %-10s %-10s %-10s %-8s %-20s\n",
                        "Zone", "ID", "Kind", "Weight", "Status", "Height", "Quantity", "Price", "Cut Date"));

                while (temp != null) {
                    bw.write(String.format("%-10s %-6d %-15s %-8.2f %-10s %-8.2f %-10d %-8d %-20s\n",
                            temp.zone, temp.timberId, temp.kind, temp.weight,
                            temp.status, temp.height, temp.quantity, temp.price, temp.cutDate));
                    temp = temp.next;
                }
            }

            bw.close();
            fw.close();
            System.out.println("Data successfully written to file: Timber_Stack_Data.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class StackProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        node stack = new node();
        int choice;
        System.out.println("------ Timber Stack Management System ------");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Push (Add New Timber)");
            System.out.println("2. Pop (Remove Last Timber)");
            System.out.println("3. Peek (View Top Timber)");
            System.out.println("4. Display All Records");
            System.out.println("5. Search by ID");
            System.out.println("6. Write to File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: stack.push(); break;
                case 2: stack.pop(); break;
                case 3: stack.peek(); break;
                case 4: stack.displayAll(); break;
                case 5: stack.searchById(); break;
                case 6: stack.writeToFile(); break;
                case 7:
                    System.out.println("Exiting... Saving data...");
                    stack.writeToFile();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
