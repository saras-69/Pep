import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        PriorityQueue<Integer> max = new PriorityQueue<>();
        for (int num : arr) {
            max.add(num);
        }
        while (!max.isEmpty()) {
            System.out.print(max.poll());

        }

    }

}
