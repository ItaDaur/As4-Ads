import java.util.*;

public class MyWeightedGraph<T> {
    private boolean undirected;
    private Map<Vertex<T>, Vertex<T>> connect = new HashMap<>();
//    private Set<Vertex<T>> map = new HashSet<>();

    public MyWeightedGraph() {
        this.undirected = true;
    }

    public MyWeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<T> v) {
        connect.put(v, new Vertex<T>(v.getSource()));
    }

    public void addEdge(Vertex<T> source, Vertex<T> dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || hasEdge(dest,source) || source.equals(dest))
            return; // reject parallels & self-loops

        connect.get(source).insertVertex(dest, weight);

        if (undirected)
            connect.get(dest).insertVertex(source, weight);
    }

    public int getVerticesCount() {
        return connect.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<T> v : connect.keySet()) {
            count += connect.get(v).sizeAdj();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(Vertex<T> v) {
        return connect.containsKey(v);
    }

    public boolean hasEdge(Vertex<T> source, Vertex<T> dest) {
        if (!hasVertex(source)) return false;
        return connect.get(source).isVertex(dest);
//        return connect.get(source).containsValue(dest);
//        return map.get(source).contains(new Edge<>(source, dest));
    }

    public Iterable<Vertex<T>> getEdges(Vertex<T> v) {
        if (!hasVertex(v)) return null;
        return (Iterable<Vertex<T>>) connect.get(v);
    }
}
