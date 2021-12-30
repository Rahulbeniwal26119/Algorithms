import java.util.LinkedList;
import java.util.Queue;


public class BFSAdMatrix {

    public static void  BFS(int u, int adj[][], int n){
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(u);
        visited[u] = true;
        System.out.println(u + " ");
        while(q.size() != 0){
            int val = q.poll();
            for(int i=0; i<n; i++){
                if(adj[val][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    System.out.println(i + " ");
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int adjacencyMatrix[][] = new int[][]{
            {0,1,1,0},
            {0,0,0,0},
            {1,1,0,1},
            {0,0,0,1}
        };

        BFS(2 , adjacencyMatrix, 4);
    }
}
