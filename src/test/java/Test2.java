import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.shortestpath.BellmanFordShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Pseudograph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by valentin on 24.02.17.
 */
public class Test2 {
    public static void main(String[] args) {

        UndirectedGraph<Integer, DefaultEdge> graph = new Pseudograph<Integer, DefaultEdge>(DefaultEdge.class);
        for (int i = 0; i < 75; i++) {
            graph.addVertex(i);
        }

        String input = "[64, 47], [27, 43], [40, 63], [34, 2], [49, 56], [21, 51], [23, 15], [57, 32], [16, 70], [31, 25], [48, 6], [22, 74], [20, 45], [5, 38]," +
                " [59, 28], [58, 39], [52, 58], [71, 11], [13, 48], [19, 30], [40, 22], [57, 45], [69, 2], [24, 0], [14, 30], [73, 62], [61, 70], [55, 25], [54, 10]," +
                " [72, 51], [36, 64], [49, 37], [68, 18], [5, 23], [66, 73], [13, 59], [51, 41], [26, 8], [46, 64], [16, 24], [1, 4], [33, 27], [19, 31], [7, 51]," +
                " [9, 49], [21, 28], [4, 35], [17, 67], [23, 44], [39, 11], [12, 22], [42, 18], [4, 18], [3, 64], [4, 34], [54, 29], [24, 22], [59, 17], [52, 60]," +
                " [53, 47], [50, 65], [54, 16], [43, 52], [44, 68], [41, 35], [19, 50], [32, 8], [41, 74], [49, 1], [6, 20], [14, 12], [33, 49], [47, 4], [62, 48]," +
                " [69, 25], [47, 57], [66, 73], [58, 63], [52, 30], [73, 69], [21, 43], [13, 48], [5, 27], [25, 30], [41, 9], [17, 43], [72, 4], [61, 18], [34, 59]," +
                " [33, 47], [19, 27], [12, 21], [74, 28], [61, 24], [7, 52], [21, 25], [6, 15], [21, 40], [49, 41], [15, 41], [67, 9], [48, 62], [37, 24], [2, 44], " +
                "[26, 25], [3, 21], [11, 62], [30, 54], [54, 27], [25, 24], [17, 59], [15, 20], [70, 63], [38, 72], [44, 69], [48, 13], [56, 57], [58, 24], [68, 9]," +
                " [3, 34], [27, 52], [50, 16], [8, 24], [59, 9], [34, 54], [59, 12], [59, 65], [73, 9], [13, 35], [4, 44], [53, 20], [35, 29], [1, 44], [57, 30], " +
                "[49, 47], [62, 60], [44, 63], [38, 65], [16, 49], [69, 48], [70, 9], [73, 20], [70, 10], [27, 13], [19, 26], [25, 8], [72, 50], [30, 51], [59, 62], " +
                "[53, 74], [59, 33], [5, 65], [33, 65], [13, 42], [55, 40], [9, 14], [66, 38], [59, 2], [13, 14], [15, 74], [67, 68], [40, 20], [33, 6], [61, 30], " +
                "[35, 23], [60, 69], [27, 60], [74, 62], [72, 33], [47, 28], [14, 35], [54, 27], [46, 5], [72, 35], [2, 2], [36, 63], [17, 11], [31, 12], [37, 18], " +
                "[41, 7], [44, 60], [12, 49], [2, 71], [69, 26], [1, 66], [56, 28], [1, 72], [74, 26], [51, 72], [0, 9], [69, 23], [24, 2], [73, 11], [38, 21], " +
                "[33, 51], [32, 20], [61, 23], [64, 2], [7, 65], [23, 24], [44, 69], [21, 70], [16, 39], [39, 0], [8, 20], [22, 7], [25, 41], [45, 31], [51, 73], " +
                "[65, 32], [35, 1], [13, 42], [61, 74], [60, 63], [13, 26], [36, 5], [57, 48], [27, 11], [39, 8], [8, 53], [4, 22], [46, 0], [8, 74], [12, 14]";
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
        for (int i = 0; i < 75; i++)
            for (int j = 0; j < 75; j++) {
                if (BellmanFordShortestPath.findPathBetween(graph, i, j).getLength() > max)
                    max = BellmanFordShortestPath.findPathBetween(graph, i, j).getLength();
            }
        System.out.println(max);

    }
}
