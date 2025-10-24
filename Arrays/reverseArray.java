

public class reverseArray {
    public static void main(String[] args) {

int[] array = {10, 20, 30, 40, 50, 60, 70};
        int size = array.length;

 System.out.println("\nNormal Array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
System.out.println("");

        System.out.println("Reversed Array:");

        for(int i=size-1;i>=0;i--)
        {
			System.out.print(array[i]+"\t");


		}//for


	}//main
	}//class