class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<Vertex<V>> traverse(Vertex<V> source) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        Set<Vertex<V>> visited = new HashSet<>();

        distances.put(source, 0.0);
        queue.offer(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            visited.add(current);

            List<Vertex<V>> neighbors = graph.getAdjacentVertices(current);
            for (Vertex<V> neighbor : neighbors) {
                double weight = current.getAdjacentVertices().get(neighbor);
                double totalDistance = distances.get(current) + weight;

                if (!visited.contains(neighbor) && (!distances.containsKey(neighbor) || totalDistance < distances.get(neighbor))) {
                    distances.put(neighbor, totalDistance);
                    previous.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }

        List<Vertex<V>> result = new ArrayList<>();
        Vertex<V> current = graph.getAdjacentVertices().keySet().iterator().next(); // Get any vertex from the graph
        while (current != null) {
            result.add(0, current);
            current = previous.get(current);
        }

        return result;
    }
}