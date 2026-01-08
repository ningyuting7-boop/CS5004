import java.util.Scanner;

public class AddFromKbd {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int a = scanner.nextInt();
        System.out.println("Enter another integer: ");
        int b = scanner.nextInt();
        System.out.println("The sum of two integers is " + Integer.toString(a + b) + ".");
        scanner.close();
    }
}
