import java.util.Scanner;

public class Searching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        int ind = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == a) {
                ind = i;
                break;
            }
        }
        System.out.println(ind);

    }

}
