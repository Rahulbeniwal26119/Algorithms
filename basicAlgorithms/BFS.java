import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Graph{
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked") Graph(int v){
		V = v;
		adj = new LinkedList[v];

		for(int i = 0; i<v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w){
		adj[v].add(w);
	}

	void BFS(int s){
		boolean visited[] = new boolean[V];

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);

		while (q.size() != 0){
			s = q.poll();
			System.out.println(s + " ");
			visited[s] = true;

			Iterator<Integer> i = adj[s].iterator();
			while (i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					q.add(n);
					visited[n] = true;
				}
			}
			
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
		g.BFS(2);
	}
}