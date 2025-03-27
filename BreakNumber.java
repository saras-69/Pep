import java.util.Scanner;

public class BreakNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        for (int i = 0; i < n; i++) {
            long fx = sc.nextLong();
            int count = 0;

            while (fx % 2 == 0) {
                fx = fx / 2;
                count++;

            }
            if (count > num) {
                num = count;
            }

        }
        System.out.println(num);

    }

}
