package searching.bfs;

public class App {

	public static void main(String[] args) {

		BreadthFirstSearch bfs = new BreadthFirstSearch();
		
		Vertex<Integer> vertex1 = new Vertex<>(1);
		Vertex<Integer> vertex2 = new Vertex<>(2);
		Vertex<Integer> vertex3 = new Vertex<>(3);
		Vertex<Integer> vertex4 = new Vertex<>(4);
		Vertex<Integer> vertex5 = new Vertex<>(5);
		Vertex<Integer> vertex6 = new Vertex<>(6);
		Vertex<Integer> vertex7 = new Vertex<>(7);
		
		vertex1.addNeighbour(vertex2);
		vertex1.addNeighbour(vertex4);
		vertex4.addNeighbour(vertex5);
		vertex4.addNeighbour(vertex7);
		vertex7.addNeighbour(vertex6);
		vertex5.addNeighbour(vertex3);
		
		bfs.bfs(vertex1);
		
	}

}
