import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<V, Double> adjacentVertices  = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public void insertVertex(V vertex, double weight) {
        adjacentVertices.put(vertex, weight);
    }

    public Double getWeight(V vertex) {
        return adjacentVertices.get(vertex);
    }

    public int sizeAdj() {
        return adjacentVertices.size();
    }

    public boolean isVertex(V vertex) {
        return adjacentVertices.containsKey(vertex);
    }

    public Iterable<V> getAdj() {
        LinkedList<V> vertices = new LinkedList<>();
        for(V v: adjacentVertices.keySet()){
            vertices.addFirst(v);
        }
        return vertices;
    }

    public void setData(V data) {
        this.data = data;
    }

    public V getSource() {
        return data;
    }
}
