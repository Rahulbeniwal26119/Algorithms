import java.util.ArrayList;

public class RingTopology {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static boolean checkStar(ArrayList<ArrayList<Integer>> adj, int V, int E) {
        if (E != V - 1)
            return false;
        if (V == 1)
            return true;
        int degree[] = new int[V + 1];
        for (int i = 1; i <= V; i++)
            for (var v : adj.get(i)) {
                degree[v]++;
            }
        int countCentralNode = 0, centralNode = 0;
        for (int i = 1; i <= V; i++)
            if (degree[i] == (V - 1)) {
                countCentralNode++;
                centralNode = i;
            }
        if (countCentralNode != 1)
            return false;
        for (int i = 1; i <= V; i++) {
            if (i == centralNode)
                continue;
            if (degree[i] != 1)
                return false;
        }
        return true;
    }

    static void checkStarTopology(ArrayList<ArrayList<Integer>> adj, int V, int E) {
        boolean isStart = checkStar(adj, V, E);
        if (isStart)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    void print(ArrayList<ArrayList<Integer>> adj, int V) {
        for (int i = 0; i <= V - 1; i++)
            for (int x : adj.get(i))
                System.out.print(x);
    }

    public static void main(String[] args) {
		int V=7, E=4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
           adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(10);
        adj.get(1).add(12);
        adj.get(2).add(1);
        adj.get(3).add(11);
        checkStarTopology(adj, V, E);
    }
}
