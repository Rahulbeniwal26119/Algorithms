import java.util.ArrayList;

public class Graph{

		private final int V;
		private int E;
		private ArrayList<Integer>[] adj;


		public Graph(int V){
				this.V = V; 
				this.E = 0;
				adj = (ArrayList<Integer>[])new ArrayList[V];
				for(int i =0; i<V; i++)
						adj[i] = new ArrayList<>();
		}

		//public Graph(In in){
		//		this(in.readInt());
		//		int E = in.readInt();
		//		for(int i=0; i < E; i++)
		//		{
		//				int v = in.readInt();
		//				int w = in.readInt();
		//				addEdge(v,w);
		//		}
		// }

		public int V(){
				return V;
		}

		public int E(){
				return E;
		}

		public void addEdge(int v, int w){
				adj[v].add(adj[v].size(),w);
				adj[w].add(adj[w].size(),v);
				E++;
		}


		public ArrayList<Integer> adj(int v){
				return adj[v];
		}

		public int degree(int  v){
			int degree = 0;
			for(int w :  adj(v))
				degree++;
				return degree;
		}

		public int  maximumDegree(){
			int max =0;
			for(int v = 0; v < V; v++){
				if(degree(v) > max)
					max = degree(v);
			}
			return max;
		}

		public int countSelfLoop(){
			int count=0;
			for(int v = 0; v < V; v++){
				for(int w : adj[v])
					if(v == w)
						count++;
			}
			return count;
		}

		public String toString(){
			String s = V + " vertices " + E + " edges \n";
			for(int v = 0; v < V; v++){
				s += v + ": ";
				for(int w : this.adj[v]){
					s += w + " ";
				}
				s+="\n";
			}	
			return s;
		}

		public static void main(String []args){
				Graph g = new Graph(13);
				g.addEdge(0,5);
				g.addEdge(4,3);
				g.addEdge(0,1);
				g.addEdge(9,12);
				g.addEdge(6,4);
				g.addEdge(5,4);
				g.addEdge(0,2);
				g.addEdge(11,12);
				g.addEdge(9,10);
				g.addEdge(0,6);
				g.addEdge(7,8);
				g.addEdge(9,11);
				g.addEdge(5,3);
				System.out.println(g.toString());
		}
}

