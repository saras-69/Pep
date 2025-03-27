import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c[] = str.toCharArray();
        int start = 0;
        int end = c.length - 1;
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
        System.out.println(new String(c));
        sc.close();
    }
}
