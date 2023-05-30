class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;

    }@Override
    public List<Vertex<V>> traverse(Vertex<V> source) {
        List<Vertex<V>> result = new ArrayList<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            result.add(current);

            List<Vertex<V>> neighbors = graph.getAdjacentVertices(current);
            for (Vertex<V> neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return result;