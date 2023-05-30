public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }
    public V getData() {
        return data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }
}
    class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> graph;

    public WeightedGraph() {
        this.graph = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        graph.put(vertex, new ArrayList<>());
    }
        public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
            if (graph.containsKey(source) && graph.containsKey(destination)) {
                source.addAdjacentVertex(destination, weight);
                graph.get(source).add(destination);
            }
        }

        public List<Vertex<V>> getAdjacentVertices(Vertex<V> vertex) {
            return graph.getOrDefault(vertex, new ArrayList<>());
        }
    }
    interface Search<V> {
    List<Vertex<V>> traverse(Vertex<V> source);
}
}

