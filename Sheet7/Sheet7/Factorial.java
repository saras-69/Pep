package Sheet7;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        System.out.print(fac(n));

    }

    public static Long fac(Long n) {
        if (n == 0) {
            return 1L;
        }
        return n * fac(n - 1);
    }

}
