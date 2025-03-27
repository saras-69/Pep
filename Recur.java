import java.util.Scanner;

public class Recur {

    public static int sum(int n) {
        // if (n < 1) {
        // System.out.println();
        // return;
        // }
        // System.out.println(n + "");
        // printNumbers(n - 1);
        // System.out.println(n + "");
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sum(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sum(n));

    }

}
