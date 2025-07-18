public class MCM {
    public static int mcmRecursiveUtil(int[] arr, int i, int j) {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans = mcmRecursiveUtil(arr, i, k) + mcmRecursiveUtil(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            if (ans < min)
                min = ans;
        }
        return min;
    }

    public static int mcmRecursive(int[] arr) {
        int n = arr.length;
        return mcmRecursiveUtil(arr, 1, n - 1);
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 2, 2 };
        System.out.println(mcmRecursive(arr));

    }

}