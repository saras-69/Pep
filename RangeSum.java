import java.util.Scanner;

public class RangeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        for (int a = 0; a < n; a++) {
            Long b = sc.nextLong();
            Long c = sc.nextLong();
            if (b > c) {
                Long temp = b;
                b = c;
                c = temp;
            }
            Long sum = (c * (c + 1) / 2) - ((b * (b - 1) / 2));
            System.out.println(sum);
        }
    }

}
