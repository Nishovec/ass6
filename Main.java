public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);

        graph.addEdge(vertexA, vertexB, 5);
        graph.addEdge(vertexA, vertexC, 3);
        graph.addEdge(vertexB, vertexD, 2);
        graph.addEdge(vertexC, vertexD, 1);
        graph.addEdge(vertexD, vertexE, 4);

        Search<String> bfs = new BreadthFirstSearch<>(graph);
        List<Vertex<String>> bfsTraversal = bfs.traverse(vertexA);
        System.out.println("BFS Traversal: " + bfsTraversal);

        Search<String> dijkstra = new DijkstraSearch<>(graph);
        List<Vertex<String>> dijkstraTraversal = dijkstra.traverse(vertexA);
        System.out.println("Dijkstra Traversal: " + dijkstraTraversal);
    }
}