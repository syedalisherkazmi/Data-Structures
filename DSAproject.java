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

    node first = null;
    node temp = null;

    Scanner sc = new Scanner(System.in);

    void readFromFile() {
        try {
            File file = new File("Umar Timber Store.txt");
            if (!file.exists()) {
                System.out.println("No previous data file found. Starting with empty list.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            first = null;
            temp = null;

            // Skip firster line
            line = br.readLine();
            if (line == null) {
                br.close();
                return;
            }

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.trim().split("\\s{2,}");

                if (parts.length < 9) continue;

                node newNode = new node();
                newNode.zone = parts[0];
                newNode.timberId = Integer.parseInt(parts[1]);
                newNode.kind = parts[2];
                newNode.weight = Float.parseFloat(parts[3]);
                newNode.status = parts[4];
                newNode.height = Float.parseFloat(parts[5]);
                newNode.quantity = Integer.parseInt(parts[6]);
                newNode.price = Integer.parseInt(parts[7]);
                newNode.cutDate = new Date(parts[8]);

                newNode.next = null;

                if (first == null) {
                    first = temp = newNode;
                } else {
                    temp.next = newNode;
                    temp = newNode;
                }
            }

            br.close();
            System.out.println("Data loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Error parsing file: " + ex.getMessage());
        }
    }

    void addNew() {
        node newNode = new node();

        System.out.println("......Enter the details of timber......\n");

        System.out.print("Zone:   ");
        newNode.zone = sc.next();

        while (true) {
            System.out.print("Id:   ");
            int id = sc.nextInt();
            if (checkId(id) == 0) {
                newNode.timberId = id;
                break;
            } else {
                System.out.println("This ID already exists. Please enter a different ID.");
            }
        }

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

        newNode.next = null;

        if (first == null) {
            first = temp = newNode;
        } else {
            temp.next = newNode;
            temp = newNode;
        }
    }

    int checkId(int id) {
        node temp = first;
        while (temp != null) {
            if (temp.timberId == id) {
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }

    void display(node node) {
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

    void displayZone(String zone) {
        node temp = first;
        int found = 0;
        while (temp != null) {
            if (temp.zone.equalsIgnoreCase(zone)) {
                display(temp);
                found++;
            }
            temp = temp.next;
        }
        if (found == 0) {
            System.out.println("No records found for zone: " + zone);
        } else {
            System.out.println("Total records found: " + found);
        }
    }

    void displayKind(String kind) {
        node temp = first;
        int found = 0;
        while (temp != null) {
            if (temp.kind.equalsIgnoreCase(kind)) {
                display(temp);
                found++;
            }
            temp = temp.next;
        }
        if (found == 0) {
            System.out.println("No records found for kind: " + kind);
        } else {
            System.out.println("Total records found: " + found);
        }
    }

    void analysis() {
        node temp = first;
        int found = 0;
        while (temp != null) {
            if (temp.quantity < 100) {
                display(temp);
                found++;
            }
            temp = temp.next;
        }
        if (found == 0) {
            System.out.println("no reords founded where qunatity is less 100");
        } else {
            System.out.println("Total records found where quantity is less than 100: " + found);
        }
    }

    void salesUpdate() {
        node temp = first;
        int flag = 0;
        System.out.println("enter the id to search....");
        int id = sc.nextInt();
        while (temp != null) {
            if (temp.timberId == id) {
                flag = 1;
                break;
            }
            temp = temp.next;
        }
        if (flag == 1) {
            System.out.println("enter the quantity to be sold");
            int quan = sc.nextInt();
            if (quan > temp.quantity) {
                System.out.println("quantity to be sold is moe than the quantity on hand");
            } else {
                temp.quantity = temp.quantity - quan;
                temp.status = "sold";
                System.out.println("sales updats successfully...");
            }
        } else {
            System.out.println("no id found in the record list...");
        }
    }

    void deletion() {
        System.out.println("Enter the id to be deleted");
        int id = sc.nextInt();
        node temp = first;
        node arzi = first;
        int flag = 0;
        while (temp != null) {
            if (temp.timberId == id) {
                flag = 1;
                break;
            }
            arzi = temp;
            temp = temp.next;
        }
        if (flag == 1) {
            del_AtTop(temp);
            del_AtEnd(temp);
            del_AtMid(temp, arzi);
        } else {
            System.out.println("no id found to be deleted for id that you have entered");
        }
    }

    void del_AtTop(node temp) {
        if (temp == first) {
            first = first.next;
            temp.next = null;
            System.out.println("record has been deleted form top");
        }
    }

    void del_AtEnd(node temp) {
        if (temp == null) {
            temp = first;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            System.out.println("record has been deleted from end");
        }
    }

    void del_AtMid(node temp, node arzi) {
        arzi.next = temp.next;
        temp.next = null;
        System.out.println("node has been deleted from mid successfully");
    }

    void update() {
        System.out.println("enter the id to be updated...");
        int id = sc.nextInt();
        int flag = 0;
        node temp = first;
        while (temp != null) {
            if (temp.timberId == id) {
                flag = 1;
                break;
            }
            temp = temp.next;
        }
        if (flag == 1) {
            updation(temp);
            System.out.println("id data has been updated successfully");
        } else {
            System.out.println("no id found for updation of data");
        }
    }

    void updation(node temp) {
        System.out.print("Zone:   ");
        temp.zone = sc.next();

        System.out.print("Kind:    ");
        temp.kind = sc.next();

        System.out.print("Status:    ");
        temp.status = sc.next();

        System.out.print("Quantity:    ");
        temp.quantity = sc.nextInt();

        System.out.print("Height(m):  ");
        temp.height = sc.nextFloat();

        System.out.print("Weight(kg):   ");
        temp.weight = sc.nextFloat();

        System.out.print("Price:    ");
        temp.price = sc.nextInt();

        temp.cutDate = new Date();
        System.out.println("Cut Date: " + temp.cutDate);
    }

    void inventory() {
        if (first == null) {
            System.out.println("No records found in the inventory.");
            return;
        }

        node temprent = first;
        int totalRecords = 0;
        int totalQuantity = 0;
        float totalWeight = 0;
        float totalHeight = 0;
        long totalValue = 0;

        System.out.println("------------------------------------------------------------");
        System.out.println("                    INVENTORY REPORT                        ");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-6s %-8s %-15s %-10s %-10s %-10s %-10s %-8s %-20s\n",
                "Zone", "ID", "Kind", "Weight(kg)", "Status", "Height(m)", "Quantity", "Price", "Cut Date");
        System.out.println("-----------------------------------------------------------------------");

        while (temprent != null) {
            System.out.printf("%-6s %-8d %-15s %-8.2f %-10s %-8.2f %-10d %-8d %-20s\n",
                    temprent.zone, temprent.timberId, temprent.kind, temprent.weight, temprent.status,
                    temprent.height, temprent.quantity, temprent.price, temprent.cutDate);

            totalRecords++;
            totalQuantity += temprent.quantity;
            totalWeight += temprent.weight;
            totalValue += (long) temprent.price * temprent.quantity;

            temprent = temprent.next;
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Total Records    : " + totalRecords);
        System.out.println("Total Quantity   : " + totalQuantity);
        System.out.printf("Average Weight   : %.1f\n", totalRecords > 0 ? totalWeight / totalRecords : 0);
        System.out.println("Total Inventory Value (PKR): " + totalValue);
        System.out.println("---------------------------------------------------------------------------");
    }

    void writeToFile() {
        try {
            FileWriter fw = new FileWriter("Umar Timber Store.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            if (first == null) {
                bw.write("No records in the inventory.\n");
            } else {
                node temprent = first;

                // firster
                bw.write(String.format("%-10s %-6s %-20s %-15.1s %-15s %-15.1s %-15s %-12s %-35s\n",
                        "Zone", "ID", "Kind", "Weight(kg)", "Status", "Height(m)", "Quantity", "Price", "Cut Date"));

                // Data rows
                while (temprent != null) {
                    bw.write(String.format("%-10s %-6d %-20s %-15.1f %-15s %-15.1f %-15d %-12d %-35s\n",
                            temprent.zone, temprent.timberId, temprent.kind, temprent.weight,
                            temprent.status, temprent.height, temprent.quantity,
                            temprent.price, temprent.cutDate.toString()));

                    temprent = temprent.next;
                }
            }

            bw.close();
            fw.close();
            System.out.println("Data written to file successfully. File name: Umar Timber Store.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}


public class DSAproject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        node obj = new node();
        obj.readFromFile();
int flag=0;
        int choice;
        String zone, kind;

        System.out.println("------ Timber Management System ------");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add new timber record...");
            System.out.println("2. Display records for a given zone...");
            System.out.println("3. Display records for a given kind...");
            System.out.println("4. Analysis of record...");
            System.out.println("5. Sales update ...");
            System.out.println("6. Delete a record");
            System.out.println("7. Update a timber record");
            System.out.println("8. Inventory report");
            System.out.println("9. Store data into file..");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ..... ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: obj.addNew(); break;
                case 2:
                    System.out.print("Enter the zone to search: ");
                    zone = sc.next();
                    obj.displayZone(zone);
                    break;
                case 3:
                    System.out.print("Enter the kind to search: ");
                    kind = sc.next();
                    obj.displayKind(kind);
                    break;
                case 4: obj.analysis(); break;
                case 5: obj.salesUpdate(); break;
                case 6: obj.deletion(); break;
                case 7: obj.update(); break;
                case 8: obj.inventory(); break;
                case 9:
                    obj.writeToFile();
                    System.out.println("Data stored into file successfully");
                    break;
                case 10:
                    flag=1;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            if(flag==1){
                System.out.println("exiting.....");
                System.out.println("...................................................");
                break;
            }


        }
    }
}
