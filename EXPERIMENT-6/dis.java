import java.io.*;
import java.lang.*;
import java.util.*;

class dis {
	static final int V = 4;
	int minDistance(int dist[], Boolean sptSet[])
	{
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	void printSolution(int dist[])
	{
		System.out.println(
			"Vertex \t\t Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}


	void dijkstra(int graph[][], int src)
	{
		int dist[] = new int[V]; 
		Boolean sptSet[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {

			int u = minDistance(dist, sptSet);
			sptSet[u] = true;

			for (int v = 0; v < V; v++)

				if (!sptSet[v] && graph[u][v] != 0
					&& dist[u] != Integer.MAX_VALUE
					&& dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		printSolution(dist);
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int graph[][]
			= new int[4][4] ;

        System.out.println("Enter the elements of the graph");
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                {
                    System.out.println("Enter the weight of : A["+Integer.toString(i)+"]["+Integer.toString(j)+"]" );
                    graph[i][j] = in.nextInt();
                }
		dis t= new dis();

		t.dijkstra(graph, 0);
	}
}

// 0 1 4 1
// 5 0 8 6
// 2 8 0 5
// 1 6 5 0