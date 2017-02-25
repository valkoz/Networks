import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by valentin on 25.02.17.
 */
public class Test1 {
    public static void main(String[] args) {

        UndirectedGraph<Integer, DefaultEdge> graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        for (int i = 0; i < 100; i++) {
            graph.addVertex(i);
        }

        String input = "[90, 71], [62, 22], [23, 47], [82, 16], [85, 6], [37, 97], [55, 95], [60, 16], [62, 40], [49, 59], [28, 12], [89, 8], [13, 43], [33, 78], " +
                "[86, 42], [72, 18], [43, 82], [67, 70], [78, 87], [18, 24], [64, 83], [7, 51], [77, 93], [87, 96], [3, 2], [33, 79], [14, 75], [58, 38], [92, 93], " +
                "[65, 1], [73, 94], [59, 55], [19, 71], [17, 81], [21, 35], [35, 32], [68, 51], [52, 63], [38, 80], [46, 74], [31, 3], [69, 14], [86, 76], [63, 39], " +
                "[68, 10], [61, 9], [40, 75], [89, 5], [28, 71], [67, 64], [53, 36], [45, 97], [55, 44], [84, 44], [74, 32], [38, 65], [64, 22], [32, 27], [56, 11], " +
                "[99, 80], [88, 94], [73, 20], [15, 82], [47, 91], [81, 4], [30, 25], [58, 52], [72, 0], [54, 13], [98, 89], [66, 85], [57, 36], [17, 0], [7, 74], " +
                "[79, 50], [48, 2], [60, 17], [7, 17], [92, 7], [8, 61], [83, 26], [80, 37], [59, 25], [79, 28], [39, 75], [66, 25], [22, 86], [47, 3], [41, 43], " +
                "[20, 53], [45, 25], [5, 10], [90, 29], [92, 11], [36, 89], [12, 67], [65, 34], [77, 37], [51, 23]";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        int start = 0;
        while (matcher.find(start)) {
            String value = input.substring(matcher.start(), matcher.end());
            int first = Integer.parseInt(value);
            start = matcher.end();
            matcher.find(start);
            String value2 = input.substring(matcher.start(), matcher.end());
            int second = Integer.parseInt(value2);
            start = matcher.end();
            graph.addEdge(first, second);
        }

        int max = BellmanFordShortestPath.findPathBetween(graph,0,1).getLength();
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++) {
                if (BellmanFordShortestPath.findPathBetween(graph, i, j).getLength() > max)
                    max = BellmanFordShortestPath.findPathBetween(graph, i, j).getLength();
            }
        System.out.println(max);

    }
}
