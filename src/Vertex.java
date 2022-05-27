import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices  = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public void insertVertex(Vertex<V> vertex, double weight) {
        adjacentVertices.put(vertex, weight);
    }

    public int sizeAdj() {
        return adjacentVertices.size();
    }

    public boolean isVertex(Vertex<V> vertex) {
        return adjacentVertices.containsKey(vertex);
    }

    public void setData(V data) {
        this.data = data;
    }

    public V getSource() {
        return data;
    }
}
