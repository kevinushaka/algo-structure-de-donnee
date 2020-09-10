package correction.lab7;

import java.util.*;
import ads.graph.*;

/**
 * A class to find a path between two vertices in a graph (directed or undirected)
 */
public class PathFinder {
	
	private static Graph G;
	
	private static Set<Vertex> visited;
	
	/**
	 * Returns a path as from vertex 'u' to vertex 'v' in the graph 'G'
	 * as a list of vertices if such a path exists, the empty list otherwise
	 */
	public static List<Vertex> findPath(Graph G, Vertex u, Vertex v) {
		PathFinder.G = G;
		PathFinder.visited = new HashSet<Vertex>();
		
		List<Vertex> path = new LinkedList<Vertex>();
		
		findPath(u,v,path);
		return path;
	}
	
	/**
	 * If there is a path from vertex 'u' to vertex 'v' in the graph, the
	 * vertices of this path are stored in the list 'path' and the method
	 * returns true. Else the list 'path' remains unchanged and the method
	 * returns false
	 */
	private static boolean findPath(Vertex u, Vertex v, List<Vertex> path) {
		visited.add(u);
		if ( u == v ) {
			path.add(u);
			return true;
		}
		for ( Vertex a : G.adjacents(u) ) {
			if ( ! visited.contains(a) ) {
				if ( findPath(a,v,path) ) {
					path.add(0,u);
					return true;
				}
			}
		}
		return false;
	}

	private enum Color { Blue, White, Red };

	private static Color other(Color c) {
		if ( c == Color.Red )
			return Color.Blue;
		return Color.Red;
	}

	public static boolean coloriable(UnDiGraph G) {
		Map<Vertex,Color> vertexColor = new HashMap<Vertex,Color>();
		return coloriable(G,Color.Blue,G.getRandomVertex(),vertexColor);
	}

	private static boolean coloriable(UnDiGraph G, Color c, Vertex u, Map<Vertex,Color> vertexColor) {
		vertexColor.put(u,c);
		int nb=0;
		for(Vertex a: G.adjacents(u)){
			if(!vertexColor.containsKey(a)){
				if(coloriable(G,other(c),a,vertexColor)){
					return true;
				}
			}else if(c==vertexColor.get(a)){
				return  false;
			}
		}

		return false;
	}


	public static void main(String[] s) {
		DiGraph G = GraphReader.D3;
		System.out.println(G);
		
		System.out.println(findPath(G,G.getVertex("F"),G.getVertex("E")));
	}
}
