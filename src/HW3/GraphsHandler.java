package HW3;

import java.io.*;
import java.util.*;

public class GraphsHandler {

    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        String fileName = userInput.next();
        Scanner fileSc = new Scanner(new File(  fileName));

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
                errorsGraphs.write(String.format("line number = %d, input line = \"%s\" , Error message = %s\n", lineNumber, line, e.getMessage()));
            }
            lineNumber++;
        }
        errorsGraphs.flush();
        errorsGraphs.close();
        Writer graphsOutList = new FileWriter("GraphsOutList.txt");

        for (IGraph<String> Graph : list) {
            graphsOutList.write(Graph.toString());
            graphsOutList.write("\n");
        }
        graphsOutList.flush();
        graphsOutList.close();

        Writer graphsSortOutSet = new FileWriter("GraphsSortOutSet.txt");
        for (IGraph<String> Graph : sortedSet) {
            graphsSortOutSet.write(Graph.toString());
            graphsSortOutSet.write("\n");
        }
        graphsSortOutSet.flush();
        graphsSortOutSet.close();


        Writer GraphsSortOutList = new FileWriter("GraphsSortOutList.txt");
        list.sort(GraphsHandler::compare);
        for (IGraph<String> Graph : list) {
            GraphsSortOutList.write(Graph.toString());
            GraphsSortOutList.write("\n");
        }
        GraphsSortOutList.flush();
        GraphsSortOutList.close();


    }

    private static int compare(IGraph<String> o1, IGraph<String> o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        return o1.numOfVertices() > o2.numOfVertices() ? 1 : -1;
    }
}
