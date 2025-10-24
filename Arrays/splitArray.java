
import java.util.Scanner;
public class splitArray {
    public static void main(String[] args) {

int[] array = {10, 20, 30, 40, 50, 60, 70};
        int size = array.length;

 System.out.println("\nNormal Array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
        int flag=0;
System.out.println("");

Scanner s = new Scanner(System.in);

System.out.println("Enter the position you want to split:");
    int pos=s.nextInt();

        System.out.println("Split Array:");
        System.out.println("First Part:");

        for(int i=0;i<size;i++)
        {
			if(i<pos){
			System.out.print(array[i]+"\t");
            flag=1;

}


else{
if (flag==1){
	System.out.println("\nNext part \n");
	flag=0;
}
System.out.print(array[i]+"\t");
}
		}//for


	}//main
	}//class