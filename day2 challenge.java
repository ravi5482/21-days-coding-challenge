
import java.util.Arrays;

public class Day2Challenge {
    public static int countOccurrences(int[] arr, int x) {
        int first = firstOccurrence(arr, x);
        if (first == -1) return 0; 
        int last = lastOccurrence(arr, x);
        return last - first + 1;
    }

    private static int firstOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                high = mid - 1; 
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static int lastOccurrence(int[] arr, int x) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                low = mid + 1; 
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 14, 19, 26, 27, 31, 33, 35, 42, 44};
        int x = 14;
        System.out.println("Count of " + x + " in array: " + countOccurrences(arr, x));
    }
}



