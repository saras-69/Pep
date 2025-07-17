import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int k = scanner.nextInt();
            int b = scanner.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }
            Arrays.sort(A);
            List<Integer> seq = new ArrayList<>();
            for (int num : A) {
                if (seq.isEmpty()) {
                    seq.add(num);
                } else {
                    if (num >= k * seq.get(seq.size() - 1) + b) {
                        seq.add(num);
                    }
                }
            }
            System.out.println(seq.size());
        }
    }
}