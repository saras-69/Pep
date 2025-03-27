package Sheet7;

import java.util.Scanner;

public class Nto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);

    }

    public static void print(int n) {
        if (n <= 0) {
            return;
        }

        System.out.print(n);
        if (n > 1) {
            System.out.print(" ");
        }
        print(n - 1);
    }

}
