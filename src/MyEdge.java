import java.util.Objects;

public class MyEdge<T> {
    private Vertex<T> source;
    private Vertex<T> dest;
    private double weight;

    public MyEdge(Vertex<T> source, Vertex<T> dest) {
        this.source = source;
        this.dest = dest;
        this.weight = 1;
    }

    public MyEdge(Vertex<T> source, Vertex<T> dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}
