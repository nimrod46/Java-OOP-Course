package HW3;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

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

    public static IGraph<String> toGraph(String s) {
        String[] asrrs = s.replace("\n", "").replace("\t", "").replaceAll(" ", ":").split(":");
        IGraph<String> graph;
        if (asrrs[0].equals("DirectedGraph")) {
            graph = new DirectedGraph<>();
        } else {
            graph = new UndirectedGraph<>();
        }

        for (int i = 1; i < asrrs.length; i += 2) {
            String vertex = asrrs[i];
            String[] edges = asrrs[i + 1].replace("{", "").replace("}", "").split(",");
            graph.addVertex(vertex);
            Arrays.stream(edges).filter(st -> !st.isEmpty()).forEach(e -> graph.addEdge(vertex,e));
        }
        return graph;
    }
}
