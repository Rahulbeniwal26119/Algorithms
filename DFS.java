public class DFS {
    public static  int visited[]  = new int[7];

   static  public void  DeapthFirstSearch(int u , int adjacenyMatrix[][] , int n)
    {
        if(visited[u]==0)
        {
            System.out.println(u);
            visited[u] = 1;
            for(int v=1; v<=n; v++)
            {
                if(adjacenyMatrix[u][v] == 1 && visited[v]==0 )
                {
                    DeapthFirstSearch(v, adjacenyMatrix, n);
                }
            }
        }


    }
    public static void main(String[] args) {
        int adjacencyMatrix[][] = new int[][] {
            {0 , 0 , 0 , 0 , 0 , 0 , 0},
            {0 , 0 , 1 , 1 , 0 , 0 , 1},
            {0 , 1 , 0 , 0 , 1 , 0 , 1},
            {0 , 1 , 0 , 0 , 1 , 1 , 0},
            {0 , 0 , 1 , 1 , 0 , 1 , 0},
            {0 , 0 , 0 , 1 , 1 , 0 , 0},
            {0 , 1 , 1 , 0 , 0 , 0 , 0}
        } ;
        DeapthFirstSearch(5 , adjacencyMatrix , 6);
    }

}
