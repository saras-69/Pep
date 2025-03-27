import java.util.Scanner;

public class findMinimum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a < min) {
                min = a;
            }
            count++;
            if (count == k) {
                System.out.print(min + " ");
                count = 0;
                min = Integer.MAX_VALUE;
            }
        }

        if (count > 0) {
            System.out.print(min + " ");
        }
    }
}