import java.util.Arrays;

public class CountingSort {
    public int[] countSort(int[] arr) {
        int N = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];
        int[] solution = new int[N];
        for (int i = 0; i < N; i++) {
            count[arr[i]] = ++count[arr[i]];
            for (int c : count) {
                System.out.println(c + " ");
            }
        }
        // make prefix sum
        for (int i = 0; i < count.length; i++) {
            count[i] += count[i - 1];
        }

    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 3, 0, 2, 3, 0, 3 };
        int[] solution = new int[arr.length];

        CountingSort countingSort = new countingSort(arr);
        solution = countingSort.countSort(arr);
        for (int elt : solution) {
            System.out.println(elt + " ");
        }

    }

}
