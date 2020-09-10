package correction.lab7;

import java.util.*;
import ads.graph.*;

/**
 * A class to find cycles in undirected and directed graphs
 */
public class Cycles {
	
	private static Graph G;
	
	/////////////// Cycle detection for undirected graphs
	
	private static Set<Vertex> visited;
	
	/**
	 * Returns true if the graph 'G' is cyclic
	 * false otherwise
	 */
	public static boolean hasCycle(UnDiGraph G) {
		visited = new HashSet<Vertex>();
		Cycles.G = G;
		
		for ( Vertex u : G.vertices() )
			if ( ! visited.contains(u) )
				if ( hasCycle(u,null) )
					return true;
		return false;
	}
	
	/**
	 * Returns true if a cycle was found by traversing
	 * the graph, coming from vertex from and going by vertex u
	 * Precondition: vertex 'from' is visited and vertex 'u' is
	 * not visited
	 */
	private static boolean hasCycle(Vertex u, Vertex from) {
		visited.add(u);
		for ( Vertex a : G.adjacents(u) )
			if ( ! visited.contains(a) ) {
				if ( hasCycle(a,u) )
					return true;
			}
			else if ( a != from )
				return true;
		return false;
	}
	
	/////////////// Cycle detection for directed graphs
	
	private enum Status { UnDiscovered, InProgress, Completed } // status of vertex
	
	private static Map<Vertex,Status> vertexStatus; // to set the status of each vertex

	/**
	 * Returns true if the graph 'G' is cyclic
	 * false otherwise
	 */
	public static boolean hasCycle(DiGraph G) {
		vertexStatus = new HashMap<Vertex,Status>();
		Cycles.G = G;
		
		for ( Vertex u : G.vertices() )
			if ( status(u) == Status.UnDiscovered )
				if ( hasCycle(u) )
					return true;
		return false;
	}
	
	/**
	 * Returns true if a cycle was found by traversing
	 * the graph from vertex u
	 * Precondition: vertex 'u' is 'UnDiscovered'
	 */
	private static boolean hasCycle(Vertex u) {
		setStatus(u,Status.InProgress);
		for ( Vertex a : G.adjacents(u) )
			if ( status(a) == Status.UnDiscovered ) {
				if ( hasCycle(a) )
					return true;
			}
			else if ( status(a) == Status.InProgress )
				return true;
		setStatus(u,Status.Completed);
		return false;
	}
	
	
	/**
	 * Returns the status of vertex 'u'
	 */
	private static Status status(Vertex u) {
		Status s = vertexStatus.get(u);
		if ( s == null )
			return Status.UnDiscovered;
		return s;
	}
	
	/**
	 * Sets the status of vertex 'u' to 's'
	 */	
	private static void setStatus(Vertex u, Status s) {
		vertexStatus.put(u,s);
	}
	
	/////////////// 
	
	public static void main(String[] s) {
		DiGraph G = GraphReader.D1;
		
		System.out.println(hasCycle(G));
	}
}
