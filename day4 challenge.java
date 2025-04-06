import java.util.Scanner;

public class Day4Challenge {
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1; 
        return n * factorial(n - 1); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println("Factorial of " + n + " is: " + factorial(n));
    }
}