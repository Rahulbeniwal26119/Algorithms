
public class KruskalAlgo {
    static  int I=896349834;
    static int V = 7; // number of vertex in graph , answer has V-1 edges
    static int E = 9; // number of edges in given graph 
    static void print(int t[][]){
        System.out.println("\n Minimum cost spannig tree Edges\n");
        for(int i =0; i < V-1; i++)
        {
            System.out.println("[" + t[0][i] + "]----[" + t[1][i] + "]"); 
        }
    }
    static void union(int u , int v , int s[])  // use to union two vertex 
    {
        if(s[u] < s[v])
        {
            s[u]+=s[v];
            s[v] = u;
        }
        else 
        {
            s[v]+=s[u];
            s[u] = v;
        }
    }
    static int find(int u  , int s[])  // use to find the cycle , connect to same parent and try to meet each other 
    {
        int x = u;
        int v =0;
        while(s[x] > 0)
        {
            x = s[x];
        }
        while(u!=x) //collapsing find 
        {
            v = s[u];
            s[u] = x;
            u = v;
        }
        return x;
    }
    static void KruskalMCST(int A[][])
    {
        int t[][] = new int[2][V-1]; // solution array 
        int track[] = new int[]{0,0,0,0,0,0,0,0,0}; //edges which has been included in the solution
        int set[] = {-1 , -1 , -1 , -1 ,-1 , -1 , -1 , -1}; // checking if connecting edges are forming cycle
        int i=0;
        while(i < V-1)  // till solution array is not fully filled 
        {
            int min = I;
            int   u=0 , v=0 , k=0;
            for(int j=0; j<E; j++)
            {
                if(track[j]==0 && A[2][j] < min)  // find minimum and untraversed edge 
                {
                    min = A[2][j];
                    u = A[0][j];
                    v = A[1][j];
                    k = j;
                }
                System.out.println(E);
            }
            if(find(u , set) != find(v , set))  // check for cycle 
            {
                t[0][i] = u;  // no cycle add this edge in solution array 
                t[1][i] = v;

                union(find(u , set) , find(v , set) , set);
                i++;
            }
            track[k] =1;
        }
        print(t);
    }
    public static void main(String []args)
    {
        int edges[][] = new int[][]{
            {1,1,2,2,3,4,4,5,5},
            {2,6,3,7,4,5,7,6,7},
            {25 , 5 , 12 , 10 , 8 , 16 , 14 , 20 , 18 }
        };
        KruskalMCST(edges);

    }
}
