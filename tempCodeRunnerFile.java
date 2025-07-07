public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.display();
        System.out.println("Sum b/w range 2,6");
        System.out.println(segmentTree.rangeQuery(2, 6));

    }