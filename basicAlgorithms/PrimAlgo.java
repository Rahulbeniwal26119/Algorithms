
public class PrimAlgo {
    static private int I = 75785875;  // consider this as a infinity value 

    public static void main(String[] args) {
        int adjacencyMatrix[][] = new int[][]{
            {0 , 0 , 0  , 0 , 0 , 0 , 0 , 0},
            {0 , I , 25 , I , I , I , 5 , I},
            {0 , 25, I  , 12, I , I , I ,10},
            {0 , I , 12 , I , 8 , I ,I , I },
            {0 , I , I , 8 , I , 16 ,I , 14 },
            {0 , I , I , I , 16 , I ,20 , 18 },
            {0 , 5 , I , I , I , 20 ,I, I},
            {I , I , 10 , I , 14 , 18 , I , I}
        };
        int i , j , k=I , u=I , v=I , n=7 , min = I;  // donot worry about i , j , k value they will be modify 
        int solution[][] = new int[2][n-1];
        int near[] = new int[] {I , I , I , I , I , I , I , I};
        // FInd the minimum cost edge 
        for( i=1; i<=7; i++)
        {
            for(j=i;j<=7;j++) // upper and lower triangular matrix contains same values 
            {
                if(adjacencyMatrix[i][j] < min)
                    {
                        min = adjacencyMatrix[i][j];
                        // new mark that edge that contains the minimum value
                        u = i;
                        v = j;
                    }
            }
        }
        // we get the first edge not update the both array of solution and near 
        solution[0][0] = u;
        solution[1][0] = v;
        near[u] = 0;
        near[v] = 0;
        for(i=1;i<=n; i++)  // now marking all vertex to nwar array to traversed vertex
        {
            if(near[i]!=0) // if vertext is not included than modify near array 
            {
                if(adjacencyMatrix[u][i] < adjacencyMatrix[v][i])
            {
                near[i]  = u ;
            }
            else 
            {
                near[i] = v;
            }
            }
            
        }
        // get remaining set of edges 
        //find minimum from near array
        for(i=1; i<n-1; i++)
        {
            min=I; 
            for(j=1; j<=n ; j++) // find the minimum value as new edge cost 
            {
                if(near[j] != 0 && adjacencyMatrix[j][near[j]] < min)
                {
                    k=j;
                    min = adjacencyMatrix[j][near[j]];
                }
            }
            solution[0][i] = k;
            solution[1][i] = near[k]; 
            near[k] = 0;
            //now update the near array as new vertex has arrived 
            for(j=1; j<=n; j++)
            {
                if(near[j]!=0 &&  adjacencyMatrix[j][k] <  adjacencyMatrix[j][near[j]])
                {
                    near[j] = k;
                }
            }
        }   
        for(i=0;i<n-1; i++)
        {
            System.out.println(solution[0][i] + "  " + solution[1][i]);
        }
    }
}
