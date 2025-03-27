import java.util.Scanner;

public class AreaofCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        double area = r * r * 3.141592653;
        System.out.printf("%.9f\n", area);

    }

}
