public class FenwickTree {
    int arr[];
    int bits[];
    int N;

    FenwickTree(int N) {
        this.N = N;
        this.arr = new int[N];
        this.bits = new int[N + 1];
    }

    public void update(int idx, int elt) {
        while (idx <= N) {
            bits[idx] += elt;
            idx += idx & -idx;
        }
    }

    public int range(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += bits[idx];
            idx -= idx & -idx;

        }
        return sum;
    }

    public int rangeQuery(int i, int j) {
        return range(j) - range(i - 1);
    }



    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };
        int N = arr.length;
        FenwickTree fenwickTree = new FenwickTree(N);
        for (int i = 1; i <= N; i++) {
            fenwickTree.update(i, arr[i - 1]);

        }
        for (int bit : fenwickTree.bits) {
            System.out.println(bit + " ");
        }
        System.out.println();
        System.out.println(fenwickTree.range(3));

    }

}
