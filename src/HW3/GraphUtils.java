package HW3;

import java.util.Arrays;

public class GraphUtils {
    private static final double PRECISION = 1.0e-2;

    /**
     * @param d : double
     * @return String represents d with 2 places after the decimal point.
     */
    public static String formatDouble(double d) {
        String res = String.format("%.2f", d);
        if (res.equals("-0.00"))
            res = "0.00";
        return res;
    }

    public static boolean areEqual(double d1, double d2) {
        return Math.abs(d1 - d2) < PRECISION;
    }

    public static IGraph<String> toGraph(String s) throws HW3Exception {
        try {
            if (s.split(":")[1].charAt(0) != '\t') {
                throw new HW3Exception("The graph string is not valid");
            }

            String[] verticesAndEdges = s.replace("\n", "").replace("\t", "")
                    .replaceAll(" ", ":").split(":");


            IGraph<String> graph = graphByType(verticesAndEdges[0]);

            fillGraphByVertices(verticesAndEdges, graph);
            return graph;
        } catch (HW3Exception e) {
            throw e;
        } catch (Exception e) {
            throw new HW3Exception("");
        }
    }

    private static IGraph<String> graphByType(String graphType) throws HW3Exception {
        if (graphType.equals("DirectedGraph")) {
            return new DirectedGraph<>();
        }
        if (graphType.equals("UndirectedGraph")) {
            return new UndirectedGraph<>();
        }
        throw new HW3Exception("The graph type is not valid");
    }

    private static void fillGraphByVertices(String[] verticesAndEdges, IGraph<String> graph) throws HW3Exception {
        for (int i = 1; i < verticesAndEdges.length; i += 2) {
            String vertex = verticesAndEdges[i];
            if (verticesAndEdges[i + 1].indexOf("{") != 0 || verticesAndEdges[i + 1].indexOf("}") != verticesAndEdges[i + 1].length() - 1) {
                throw new HW3Exception("The graph string is not valid");
            }
            String[] edges = verticesAndEdges[i + 1].replace("{", "").replace("}", "")
                    .split(",");
            graph.addVertex(vertex);
            Arrays.stream(edges).filter(st -> !st.isEmpty()).forEach(e -> graph.addEdge(vertex, e));
        }
    }
}
