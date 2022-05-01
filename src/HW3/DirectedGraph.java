package HW3;

import java.util.TreeMap;

public class DirectedGraph<V extends Comparable<V>> extends GraphBase<V> {

    public DirectedGraph() {
        super("Directed", new TreeMap<>());
    }
}
