import java.util.Scanner;

public class swapArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] array = {10, 20, 30, 40, 50, 60, 70};
        int size = array.length;

        System.out.println("\nBEFORE swap array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
                                        }//for
        System.out.println();


    System.out.println("Enter the position you want to swap:");
    int pos1=s.nextInt();
System.out.println("Enter the position you want to swap with:");
    int pos2=s.nextInt();
    int temp;
    for(int i=0;i<size;i++){

		if(array[i]==array[pos1]){
		temp=array[pos1];
		array[pos1]=array[pos2];
		array[pos2]=temp;}//if

}//for

 System.out.println("\nAFTER swap array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }//for


}


    }

