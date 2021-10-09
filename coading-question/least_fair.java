class LeastFair{

    static int calculateFair(int s, int d, int [][]fairChart){
        if(s == d || s == d-1) // there exist only one way for no way to reach from s to d 
            return fairChart[s][d];
        int minCost = fairChart[s][d]; 
        for(int i = s + 1; i < d; i++){
            int temp = calculateFair(s , i, fairChart) + calculateFair(i , d, fairChart);
            if(temp < minCost){
                minCost = temp;
            }
        }
        return minCost;
    }

    public static void main(String []args){
        int arr[][] = new int[][]{
            {0, 10, 75, 94},
            {-1, 0, 35, 50},
            {-1, -1, 0, 50},
            {-1, -1, -1, 0}
        };
        System.out.println(calculateFair(0, 3, arr));
    }
}
