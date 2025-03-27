import java.util.Scanner;

public class MaxSubarray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int maxsum = maxSubarray(arr, n, k);
        System.out.println(maxsum);

    }

    public static int maxSubarray(int arr[], int n, int k) {
        int maxsum = 0;
        for (int i = 0; i < k; i++) {
            maxsum = maxsum + arr[i];
        }
        int sum = maxsum;
        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }
}