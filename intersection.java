import java.util.Scanner;

public class intersection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] arr1 = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        for (int j = 0; j < m; j++) {
            arr1[j] = sc.nextInt();

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i] == arr1[j]) {
                    System.out.println(arr[i]);
                    arr1[j] = Integer.MAX_VALUE;
                    break;
                }

            }

        }
    }
}