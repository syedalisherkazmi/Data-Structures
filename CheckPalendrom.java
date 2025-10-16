import java.util.Scanner;

public class CheckPalendrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        input = input.toLowerCase(); // optional normalization
        int length = input.length();
        boolean flag = true;

        char[] stack = new char[length];
        int top = -1;

        // Push all characters into stack
        for (int i = 0; i < length; i++) {
            stack[++top] = input.charAt(i);
        }

        // Pop and compare
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) != stack[top--]) {
                flag = false;
                break;
            }
        }

        // Print result
        if (flag == false) {
            System.out.println("Not a Palindrome");
        } else {
            System.out.println("String is a Palindrome");
        }
    }
}
