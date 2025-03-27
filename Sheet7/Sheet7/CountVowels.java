package Sheet7;

import java.util.Scanner;

public class CountVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = countVowels(str, 0);
        System.out.println(count);

    }

    public static int countVowels(String str, int index) {
        if (index == str.length()) {
            return 0;
        }
        char ch = str.charAt(index);
        int count = 0;
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            count = 1;
        }
        return count + countVowels(str, index + 1);
    }
}
