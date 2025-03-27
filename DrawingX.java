import java.util.Scanner;

public class DrawingX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == n / 2 && j == n / 2) {
                    System.out.print("X");
                } else if (i == j) {
                    System.out.print("/");
                } else if (i == n - j + 1) {
                    System.out.print("\\");
                } else {
                    System.out.print("*");
                }
            }
        }
        System.out.println();
    }
}
