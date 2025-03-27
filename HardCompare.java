import java.util.Scanner;

public class HardCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();
        double loga = Math.log(a);
        double logb = Math.log(c);
        if (b * loga > d * logb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
