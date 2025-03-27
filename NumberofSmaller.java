import java.util.Scanner;

public class NumberofSmaller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] arr1 = new long[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextLong();

        }
        long arr2[] = new long[m];
        for (int j = 0; j < m; j++) {
            arr2[j] = sc.nextLong();

        }
        int ans[] = new int[m];
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && arr1[j] < arr2[i]) {
                j++;
            }
            ans[i] = j;
        }
        for (int i = 0; i < m; i++) {
            System.out.print(ans[i] + " ");
        }

    }

}
