package correction.lab8;

import java.util.*;
import ads.graph.*;

/**
 * A class for topological sorting
 */
public class TopSort {
	
	/**
	 * Returns the list of vertices of 'G' in
	 * (one) topological order
	 */
	public static List<Vertex> sort1(DiGraph G) {
		Map<Vertex,Integer> inDegree = new HashMap<Vertex,Integer>();
		Queue<Vertex> queue = new LinkedList<Vertex>();
		List<Vertex> sorted = new LinkedList<Vertex>();
		for ( Vertex vertex : G.vertices() ) {
			inDegree.put(vertex,G.inDegree(vertex));
			if ( G.inDegree(vertex) == 0 )
				queue.offer(vertex);
		}
		while ( ! queue.isEmpty() ) {
			Vertex v = queue.poll();
			sorted.add(v);
			for ( Vertex a : G.adjacents(v) ) {
				inDegree.put(a,inDegree.get(a)-1);
				if ( inDegree.get(a) == 0 )
					queue.offer(a);
			}
		}
		return sorted;
	}
	
	/**
	 * Returns the list of vertices of 'G' in
	 * (one) topological order
	 */
	public static List<Vertex> sort2(DiGraph G) {
		Set<Vertex> visited = new HashSet<Vertex>();
		List<Vertex> sorted = new LinkedList<Vertex>();
		for ( Vertex v : G.vertices() )
			if ( ! visited.contains(v) )
				visit(G,v,visited,sorted);
		return sorted;
	}
	
	/**
	 * Visit the graph 'G' using DFS from vertex 'u' and add all the visited
	 * vertices in 'sorted' such that they appear in topological order
	 */
	private static void visit(DiGraph G, Vertex u, Set<Vertex> visited, List<Vertex> sorted) {
		visited.add(u);
		for ( Vertex a : G.adjacents(u) )
			if ( ! visited.contains(a) )
				visit(G,a,visited,sorted);
		sorted.add(0,u);
	}

	/////////////// 
	
	public static void main(String[] s) {
		// DiGraph G = GraphReader.D1;
		DiGraph G = GraphReader.DD4;
		System.out.println(TopSort.sort2(G));
	}	
}
