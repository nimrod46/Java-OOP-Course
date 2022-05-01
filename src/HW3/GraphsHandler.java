package HW3;

import java.io.*;
import java.util.*;

public class GraphsHandler {

    public static void main(String[] args) throws IOException {

        Scanner fileSc = new Scanner(new File( args[0]));

        List<IGraph<String>> list = new LinkedList<>();
        SortedSet<IGraph<String>> sortedSet = new TreeSet<>(GraphsHandler::compare);

        Writer errorsGraphs = new FileWriter("errorsGraphs.txt");

        String line;
        int lineNumber = 1;
        while (fileSc.hasNextLine()) {
            line = fileSc.nextLine();
            IGraph<String> graph;
            try {
                graph = GraphUtils.toGraph(line);
                list.add(0, graph);
                sortedSet.add(graph);
            } catch (HW3Exception e) {
                e.writeToWriter(errorsGraphs, lineNumber, line);
            }
            lineNumber++;
        }

        errorsGraphs.close();

        Writer graphsOutList = new FileWriter("GraphsOutList.txt");
        writeGraphsToFile(list, graphsOutList);

        Writer graphsSortOutSet = new FileWriter("GraphsSortOutSet.txt");
        writeGraphsToFile(sortedSet, graphsSortOutSet);

        Writer GraphsSortOutList = new FileWriter("GraphsSortOutList.txt");
        list.sort(GraphsHandler::compare);
        writeGraphsToFile(list, GraphsSortOutList);
    }

    private static void writeGraphsToFile(Iterable<IGraph<String>> list, Writer writer) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (IGraph<String> Graph : list) {
            sb.append(Graph);
            sb.append("\n");
        }
        sb.delete(sb.lastIndexOf("\n"), sb.length());
        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }

    private static int compare(IGraph<String> o1, IGraph<String> o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        return o1.numOfVertices() > o2.numOfVertices() ? 1 : -1;
    }
}
