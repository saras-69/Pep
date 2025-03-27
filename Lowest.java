import java.util.Scanner;

public class Lowest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int low = arr[0];
        int index = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < low) {
                low = arr[i];
                index = i + 1;

            }
        }
        System.out.println(low + " " + index);

    }

}
