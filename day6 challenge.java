import java.util.Scanner;

public class Day6Challenge {
    public static boolean search(int[] arr, int x) {
        for (int num : arr) {
            if (num == x) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 1, 7, 5, 9, 10, 14, 17, 77, 54, 4};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int x = scanner.nextInt();
        scanner.close();

        if (search(arr, x)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}