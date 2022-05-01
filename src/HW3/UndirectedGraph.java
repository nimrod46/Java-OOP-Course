package HW3;

import java.util.TreeMap;

public class UndirectedGraph<V extends Comparable<V>> extends GraphBase<V> {

    public UndirectedGraph() {
        super("Undirected", new TreeMap<>());
    }

    @Override
    public void addEdge(V u, V v) {
        super.addEdge(u, v);
        super.addEdge(v, u);
    }

    @Override
    public boolean removeEdge(V u, V v) {
        return super.removeEdge(u, v) && super.removeEdge(v, u);
    }
}
