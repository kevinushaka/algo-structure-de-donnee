package correction.lab7;

import java.util.*;
import ads.graph.*;

/**
 * A class to find a root in a direct graph
 */
public class RootFinder {
	
	private static DiGraph G;
	private static Set<Vertex> visited;
	
	/**
	 * Returns a root of the graph 'G' if
	 * such root exists, null otherwise
	 */
	public static Vertex findRoot(DiGraph G) {
		RootFinder.G = G;
		RootFinder.visited = new HashSet<Vertex>();
		
		Vertex candidate = candidate();
		
		visited.clear();
		if ( visit(candidate) == G.nbVertices() )
			return candidate;
		return null;
	}
	
	/**
	 * Returns a root candidate
	 */
	private static Vertex candidate() {
		Vertex last = null;
		for ( Vertex u : G.vertices() )
			if ( ! visited.contains(u) ) {
				last = u;
				visit(u);
			}
		return last;
	}
	
	/**
	 * Visits all the reachable vertices from
	 * vertex 'u' and returns the number of
	 * those vertices
	 */
	private static int visit(Vertex u) {
		visited.add(u);
		int n = 1;
		for ( Vertex a : G.adjacents(u) )
			if ( ! visited.contains(a) )
				n += visit(a);
		return n;
	}
	
	public static void main(String[] s) {
		DiGraph G = GraphReader.D2;
		System.out.println(findRoot(G));
	}	
}
