import java.util.*;

public class Solution {
   public static String Count(long n) {
      if (n == 1) {
         return "Richard";
      }

      int moves = 0;

      while (n > 1) {
         if (isPowerOfTwo(n)) {
            n = n / 2;
         } else {
            long largestPowerOf2 = LargestPowerless(n);
            n = n - largestPowerOf2;
         }
         moves++;
      }
      if (moves % 2 == 1) {
         return "Louise";
      } else {
         return "Richard";
      }
   }

   public static boolean isPowerOfTwo(long n) {
      return n > 0 && (n & (n - 1)) == 0;
   }

   public static long LargestPowerless(long n) {
      long power = 1;
      while (power * 2 < n) {
         power *= 2;
      }
      return power;
   }

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);

      int t = s.nextInt();
      for (int i = 1; i <= t; i++) {
         long n = s.nextLong();
         System.out.println(Count(n));
      }

   }

}
