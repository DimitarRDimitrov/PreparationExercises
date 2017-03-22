package searching.dfs;

public class Main {

	public static void main(String[] args) {

		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		Vertex vertexF = new Vertex("F");
		Vertex vertexG = new Vertex("G");
		
		vertexA.addNeighbour(vertexC);
		vertexA.addNeighbour(vertexB);
		
		vertexB.addNeighbour(vertexD);
		vertexB.addNeighbour(vertexE);
		
		vertexC.addNeighbour(vertexF);
		vertexF.addNeighbour(vertexG);
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		
//		dfs.dfs(vertexA);
		dfs.dfsRecursive(vertexA);
		
		
		
	}

}
