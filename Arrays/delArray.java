import java.util.Scanner;

public class delArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] array = {10, 20, 30, 40, 50, 60, 70, 0}; // one extra space
        int size = 7;

        System.out.println("\nBEFORE insertion array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println("");

        System.out.println("Enter a location (0–" + size + "): ");
        int location = s.nextInt();

        // shift elements right from the end
        for (int i = location; i <size - 1; i++) {
            array[i] = array[i+1];
	}

        size--; // now 8 valid elements (0–7)

        System.out.println("\nAFTER Insertion array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }

        s.close();
    }
}
