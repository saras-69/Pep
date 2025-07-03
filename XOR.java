import java.io.*;

public class XOR {
    static int computeXor(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = res ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(computeXor(n));
    }
}