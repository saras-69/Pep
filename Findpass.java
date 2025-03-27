import java.util.Scanner;

public class Findpass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long password = 1999;
        while (true) {
            long input = sc.nextLong();
            if (input == password) {
                System.out.println("Correct");
                break;
            } else {
                System.out.println("Wrong");
            }
        }

    }

}
