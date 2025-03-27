import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int year = n / 365;
        n = n % 365;
        int month = n / 30;
        n = n % 30;
        int day = n;
        System.out.println(year + " years");
        System.out.println(month + " months");
        System.out.println(day + " days");

    }
}