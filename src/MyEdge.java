public class MyEdge<T> {
    private V<T> source;
    private V<T> dest;
    private double weight;

    public MyEdge(V<T> source, V<T> dest) {
        this.source = source;
        this.dest = dest;
        this.weight = 1;
    }

    public MyEdge(V<T> source, V<T> dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}
