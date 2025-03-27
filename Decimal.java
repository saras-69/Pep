import java.util.Scanner;

public class Decimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();

            int count = 0;
            int temp = N;
            while (temp > 0) {
                if ((temp & 1) == 1) {
                    count++;
                }
                temp >>= 1;
            }

            int result = (1 << count) - 1;

            System.out.println(result);
        }
    }
}