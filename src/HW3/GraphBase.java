package HW3;

import java.util.*;
import java.util.stream.Collectors;

public abstract class GraphBase<V extends Comparable<V>> implements IGraph<V> {

    private final SortedMap<V, SortedSet<V>> vertices;

    public GraphBase() {
        this.vertices = new TreeMap<>();
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) {
            return;
        }
        vertices.put(v, new TreeSet<>());
    }

    @Override
    public void addEdge(V u, V v) {
        addVertex(v);
        addVertex(u);
        vertices.get(u).add(v);

    }

    @Override
    public boolean containsVertex(V v) {
        return vertices.containsKey(v);
    }

    @Override
    public boolean containsEdge(V u, V v) {
        if (!vertices.containsKey(u)) {
            return false;
        }
        return vertices.get(u).contains(v);
    }

    @Override
    public Set<V> removeVertex(V v) {
        for (V k : vertices.keySet()) {
            vertices.get(k).remove(v);
        }
        return vertices.remove(v);
    }

    @Override
    public boolean removeEdge(V u, V v) {
        if (!vertices.containsKey(u)) {
            return false;
        }
        return vertices.get(u).remove(v);
    }

    @Override
    public String getGraphType() {
        return "Directed";
    }

    @Override
    public int numOfVertices() {
        return vertices.size();
    }

    @Override
    public int numOfEdges() {
        int counter = 0;
        for (Set<V> s : vertices.values()) {
            counter += s.size();
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(getGraphType() + "Graph:\t");
        for (V v : vertices.keySet()) {
            s.append(v).append(":").append("{").append(vertices.get(v).stream().map(Object::toString).collect(Collectors.joining(","))).append("} ");
        }
        return s.substring(0, s.length() + (vertices.isEmpty() ? 0 : -1));
    }

}
