import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count++;

            System.out.println(count);
        }

    }
}