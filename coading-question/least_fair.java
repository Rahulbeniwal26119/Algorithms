class LeastFair {

    static int calculateFair(int s, int d, int[][] fairChart, int[][] memo) {
        if (s == d || s == d - 1) // there exist only one way for no way to reach from s to d
            return fairChart[s][d];
        if (memo[s][d] == 0) {
            int minCost = fairChart[s][d];
            for (int i = s + 1; i < d; i++) {
                int temp = calculateFair(s, i, fairChart, memo) + calculateFair(i, d, fairChart, memo);
                if (temp < minCost) {
                    minCost = temp;
                }
                memo[s][d] = minCost;
            }
        }
        return memo[s][d];
    }

    public static int fibDynamicProgramming(int n) {
        if (n == 1 || n == 2)
            return 1;
        int a = 1;
        int b = 1;
        int c = 0;

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
        // dynamic programming without tabulation or memoization
    }

    static int calculateMinFairDynamicProgramming(int cost[][]) {
        int NS = cost[0].length;
        int minCost[] = new int[NS];
        minCost[0] = 0;
        minCost[1] = cost[0][1];

        for (int i = 2; i < NS; i++) {
            minCost[i] = cost[0][i];

            for (int j = 1; j < i; j++) {
                if (minCost[i] > (minCost[j] + cost[j][i]))
                    minCost[i] = minCost[j] + cost[j][i];
            }

            // min cost is minCost[i] + minCost[i][j]
        }
        return minCost[NS - 1];

    }

    public static void main(String[] args) {
        int arr[][] = new int[][] { { 0, 10, 75, 94 }, { -1, 0, 35, 50 }, { -1, -1, 0, 50 }, { -1, -1, -1, 0 } };
        int memo[][] = new int[4][4];
        System.out.println(calculateFair(0, 3, arr, memo));
        System.out.println(calculateMinFairDynamicProgramming(arr));
    }
}
