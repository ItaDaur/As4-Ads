import java.util.*;

public class MyWeightedGraph<T> {
    private boolean undirected;
    private Map<T, Vertex<T>> connect = new HashMap<>();
//    private Set<Vertex<T>> map = new HashSet<>();

    public MyWeightedGraph() {
        this.undirected = true;
    }

    public MyWeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T v) {
        connect.put(v, new Vertex<>(v));
    }

    public Vertex<T> getVertex(T info) {
        return connect.get(info);
    }

    public void addEdge(T source, T dest, double weight) {
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
//        for (Vertex<T> v : connect.keySet()) {
//            count += connect.get(v).sizeAdj();
//        }

        for (int i=0;i<getVerticesCount();i++) {
            count+= connect.get(i).sizeAdj();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return connect.containsKey(v);
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;
        return connect.get(source).isVertex(dest);
//        return connect.get(source).containsValue(dest);
//        return map.get(source).contains(new Edge<>(source, dest));
    }

    public Iterable<T> adjacencyList(T v) {
        if (!hasVertex(v)) return null;
        Vertex<T> vertex = connect.get(v);
        return vertex.getAdj();
    }

    public Iterable<Vertex<T>> getEdges(T v) {
        if (!hasVertex(v)) return null;
        return (Iterable<Vertex<T>>) connect.get(v);
    }
}
