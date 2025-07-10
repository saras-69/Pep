import java.util.Arrays;

public class CountingSort {
    public int[] countSort(int[] arr) {
        int N = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];
        int[] solution = new int[N];

        // Count occurrences
        for (int i = 0; i < N; i++) {
            count[arr[i]]++;
        }

        // Make prefix sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array
        for (int i = N - 1; i >= 0; i--) {
            solution[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        return solution;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 0, 2, 3, 0, 3 };

        CountingSort countingSort = new CountingSort();
        int[] solution = countingSort.countSort(arr);

        for (int elt : solution) {
            System.out.print(elt + " ");
        }
    }
}
