import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b % a != 0) {
            int rem = b % a;
            b = a;
            a = rem;
        }
        System.out.println(a);

    }

}
