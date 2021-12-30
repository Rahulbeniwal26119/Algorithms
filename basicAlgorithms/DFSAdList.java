import java.io.*;
import java.util.*;

class Graph{
		private int V;

		private LinkedList<Integer> adj[];


		@SuppressWarnings("unchecked") Graph(int v){
				V = v;
				adj = new LinkedList[v];
				for(int i=0; i<v; i++)
						adj[i] = new LinkedList();
		}

		void addEdge(int v, int w){
				adj[v].add(w);
		}

		void DFSHelper(int v, boolean visited[]){
				visited[v] = true;
				System.out.println(v + " ");

				Iterator<Integer> i = adj[v].listIterator();
				while(i.hasNext())
				{
						int n = i.next();
						if(!visited[n])
								DFSHelper(n, visited);
				}
		}

		void DFSDisconnected(int v){
				boolean visited[] = new boolean[V];
				for(int i =0; i<V; i++)
						if(visited[i] == false)
							DFSHelper(i , visited);
		}
		
		void DFS(int v){
				boolean visited[] = new boolean[V];
				DFSHelper(v,visited);
		}



		public static void main(String []args)
		{
				Graph g = new Graph(4);

				g.addEdge(0,1);
				g.addEdge(0,2);
				g.addEdge(1,2);
				g.addEdge(2,0);
				g.addEdge(2,3);
				g.addEdge(3,3);
				g.DFS(2);
		}
}
