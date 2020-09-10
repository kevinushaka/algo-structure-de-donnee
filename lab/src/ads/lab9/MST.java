package ads.lab9;

import java.util.*;
import ads.graph.*;
import ads.lab5.*;

/**
 * A class for Minimum Spanning Tree algorithms (Prim ad Kruskal)
 */
public class MST {
	
	/**
	 * Returns the list of edges of an MST of weighted undirected graph G
	 * using the Prim algorithm
	 * Precondition: G is connected
	 */
	public static List<Edge> prim(UnDiGraph G) throws FullHeapException, EmptyHeapException {
		// the edges of the MST
		List<Edge> mst = new LinkedList<Edge>();
		// to make a minimum-heap of weighted edges
		Comparator<Edge> c = new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e2.compareTo(e1);
			}
		};
		// the minimum-heap of weighted edges
		BinaryHeap<Edge> minHeap = new BinaryHeap<Edge>(G.nbEdges(),c);
		// known.contains(u) == true <==> u is known
		Set<Vertex> known = new HashSet<Vertex>();

		known.add(G.getRandomVertex());
		for(Edge edge : G.edges()){
			if(edge.origin()==notKnown(edge,known) ||edge.destination()==notKnown(edge,known) ){
				minHeap.add(edge);
			}
		}
		while(known.size()!=G.nbVertices()){
			Edge e=minHeap.deleteExtreme();
			mst.add(e);
			known.add(notKnown(e,known));
			minHeap = new BinaryHeap<Edge>(G.nbEdges(),c);
			for(Edge edge : G.edges()){
				if(edge.origin()==notKnown(edge,known) ||edge.destination()==notKnown(edge,known) ){
					minHeap.add(edge);
				}
			}
		}
		
		return mst;
	}
	
	/**
	 * Given the edge 'e' = (u,v) and the current set of known vertices
	 * returns the vertex (u or v) which is not in 'know', or null if they
	 * are both in 'known'
	 * Precondition: if 'e' = (u,v), at least one of u and v is in 'known'
	 */
	private static Vertex notKnown(Edge e, Set<Vertex> known) {
		Vertex v = null;
		if ( ! known.contains(e.origin()) )
			v = e.origin();
		else if ( ! known.contains(e.destination()))
			v = e.destination();
		return v;
	}
	
	/**
	 * Returns the list of edges of an MST of weighted undirected graph G
	 * using the Kruskal algorithm
	 * Precondition: G is connected
	 */
	public static List<Edge> kruskal(UnDiGraph G) throws FullHeapException, EmptyHeapException {
		// the edges of the MST
		List<Edge> mst = new LinkedList<Edge>(); 
		// to make a minimum-heap of weighted edges		
		Comparator<Edge> c = new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return e2.compareTo(e1);
			}
		};
		// a minimum-heap	
		BinaryHeap<Edge> minHeap = new BinaryHeap<Edge>(G.nbEdges(),c);
		for (Edge edge:G.edges()){
			minHeap.add(edge);
		}
		Partition<Vertex> partition= new Partition<Vertex>();
		for(Vertex vertex:G.vertices()){
			partition.newTree(vertex);
		}
		while(partition.nbTrees()>1){
			Edge edge=minHeap.deleteExtreme();
			if (partition.find(edge.origin())!=partition.find(edge.destination())){
				mst.add(edge);
				partition.union(partition.find(edge.origin()),partition.find(edge.destination()));
			}
		}
		
		return mst;
	}
	
	public static void main(String[] s) throws FullHeapException, EmptyHeapException {
		UnDiGraph G = GraphReader.U4;
		System.out.println(prim(G));
		// System.out.println(kruskal(G));
	}
}
