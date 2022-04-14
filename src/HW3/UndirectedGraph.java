package HW3;

public class UndirectedGraph<V extends Comparable<V>> extends BaseGraph<V> {

    public UndirectedGraph() {
        super("Undirected");
    }

    @Override
    public void addEdge(V u, V v) {
        super.addEdge(u, v);
        super.addEdge(v, u);
        //vertices.get(v).add(u);
    }

    @Override
    public boolean removeEdge(V u, V v) {
        return super.removeEdge(u, v) && super.removeEdge(v, u);
    }

    @Override
    public String getGraphType() {
        return "Undirected";
    }
}
