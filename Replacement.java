import java.util.Scanner;

public class Replacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                arr[i] = 2;
            } else if (arr[i] == 0) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
