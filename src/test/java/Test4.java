import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.flow.EdmondsKarpMFImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by valentin on 25.02.17.
 */
public class Test4 {
    public static void main(String[] args) {
        UndirectedGraph<Integer, DefaultEdge> graph = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
        for (int i = 0; i < 100; i++) {
            graph.addVertex(i);
        }
        String input ="[[0, 1], [0, 2], [0, 3], [0, 5], [0, 7], [0, 10], [0, 14], [0, 19], [0, 31], [0, 36], [0, 42], [0, 48], [0, 48], [0, 51], [0, 55], [0, 55], [0, 75], [0, 82], [0, 86], [0, 87], [0, 87], [0, 96], [0, 97], [0, 99], [1, 2], [1, 7], [1, 10], [1, 10], [1, 10], [1, 10], [1, 12], [1, 19], [1, 20], [1, 23], [1, 23], [1, 23], [1, 24], [1, 31], [1, 33], [1, 39], [1, 45], [1, 47], [1, 48], [1, 48], [1, 51], [1, 55], [1, 55], [1, 57], [1, 57], [1, 59], [1, 64], [1, 71], [1, 75], [1, 75], [1, 76], [1, 80], [1, 82], [1, 85], [1, 87], [1, 87], [1, 87], [1, 92], [1, 92], [1, 97], [1, 99], [1, 99], [2, 9], [2, 9], [2, 12], [2, 12], [2, 17], [2, 25], [2, 29], [2, 31], [2, 31], [2, 31], [2, 31], [2, 36], [2, 36], [2, 39], [2, 42], [2, 42], [2, 47], [2, 48], [2, 51], [2, 51], [2, 51], [2, 55], [2, 57], [2, 59], [2, 59], [2, 60], [2, 65], [2, 65], [2, 75], [2, 76], [2, 77], [2, 86], [2, 86], [2, 87], [2, 91], [2, 91], [2, 91], [2, 97], [2, 97], [3, 10], [3, 12], [3, 23], [3, 29], [3, 33], [3, 34], [3, 39], [3, 43], [3, 43], [3, 45], [3, 47], [3, 47], [3, 47], [3, 49], [3, 49], [3, 51], [3, 55], [3, 55], [3, 58], [3, 59], [3, 64], [3, 64], [3, 65], [3, 75], [3, 77], [3, 79], [3, 86], [3, 87], [3, 87], [3, 92], [3, 97], [3, 98], [3, 98], [4, 15], [4, 28], [4, 30], [4, 32], [4, 38], [4, 44], [4, 44], [4, 50], [4, 50], [4, 54], [4, 61], [4, 66], [4, 67], [4, 68], [4, 68], [4, 70], [4, 72], [4, 78], [4, 84], [4, 84], [4, 90], [4, 90], [4, 90], [4, 93], [4, 94], [4, 95], [5, 7], [5, 12], [5, 14], [5, 14], [5, 17], [5, 17], [5, 23], [5, 23], [5, 24], [5, 24], [5, 29], [5, 31], [5, 39], [5, 42], [5, 42], [5, 42], [5, 42], [5, 47], [5, 47], [5, 51], [5, 51], [5, 60], [5, 71], [5, 77], [5, 79], [5, 87], [5, 87], [6, 11], [6, 13], [6, 13], [6, 15], [6, 18], [6, 21], [6, 22], [6, 28], [6, 35], [6, 40], [6, 40], [6, 41], [6, 44], [6, 44], [6, 46], [6, 50], [6, 52], [6, 52], [6, 56], [6, 63], [6, 67], [6, 67], [6, 70], [6, 73], [6, 73], [6, 74], [6, 78], [6, 78], [6, 81], [6, 89], [6, 90], [6, 93], [6, 93], [6, 96], [7, 14], [7, 14], [7, 19], [7, 19], [7, 23], [7, 23], [7, 23], [7, 29], [7, 31], [7, 36], [7, 43], [7, 43], [7, 43], [7, 47], [7, 49], [7, 49], [7, 51], [7, 60], [7, 64], [7, 64], [7, 75], [7, 76], [7, 79], [7, 79], [7, 82], [7, 92], [7, 98], [8, 25], [8, 26], [8, 28], [8, 28], [8, 32], [8, 35], [8, 35], [8, 38], [8, 40], [8, 41], [8, 41], [8, 44], [8, 53], [8, 53], [8, 54], [8, 54], [8, 56], [8, 62], [8, 63], [8, 63], [8, 63], [8, 70], [8, 70], [8, 73], [8, 73], [8, 95], [8, 96], [8, 96], [8, 96], [9, 12], [9, 17], [9, 20], [9, 24], [9, 29], [9, 29], [9, 29], [9, 31], [9, 33], [9, 42], [9, 45], [9, 48], [9, 51], [9, 57], [9, 57], [9, 65], [9, 65], [9, 68], [9, 71], [9, 71], [9, 75], [9, 75], [9, 76], [9, 77], [9, 86], [9, 97], [10, 14], [10, 17], [10, 19], [10, 24], [10, 33], [10, 36], [10, 42], [10, 42], [10, 43], [10, 45], [10, 45], [10, 57], [10, 58], [10, 58], [10, 71], [10, 77], [10, 77], [10, 80], [10, 82], [10, 82], [10, 86], [10, 87], [10, 98], [11, 13], [11, 13], [11, 22], [11, 25], [11, 28], [11, 37], [11, 44], [11, 44], [11, 46], [11, 46], [11, 53], [11, 53], [11, 53], [11, 56], [11, 61], [11, 66], [11, 67], [11, 69], [11, 69], [11, 73], [11, 74], [11, 78], [11, 78], [11, 83], [11, 88], [11, 94], [11, 94], [11, 96], [11, 96], [12, 14], [12, 23], [12, 23], [12, 29], [12, 29], [12, 29], [12, 33], [12, 34], [12, 36], [12, 39], [12, 45], [12, 48], [12, 51], [12, 57], [12, 57], [12, 59], [12, 59], [12, 64], [12, 64], [12, 75], [12, 80], [12, 80], [12, 91], [12, 91], [12, 97], [13, 15], [13, 21], [13, 22], [13, 25], [13, 37], [13, 38], [13, 40], [13, 44], [13, 44], [13, 46], [13, 50], [13, 50], [13, 56], [13, 56], [13, 62], [13, 62], [13, 63], [13, 66], [13, 67], [13, 68], [13, 68], [13, 72], [13, 78], [13, 83], [13, 83], [13, 83], [13, 88], [13, 89], [13, 90], [13, 94], [13, 94], [13, 95], [13, 96], [14, 17], [14, 17], [14, 19], [14, 20], [14, 31], [14, 33], [14, 33], [14, 36], [14, 42], [14, 43], [14, 43], [14, 47], [14, 49], [14, 55], [14, 55], [14, 55], [14, 60], [14, 60], [14, 64], [14, 75], [14, 79], [14, 80], [14, 80], [14, 80], [14, 85], [14, 86], [14, 87], [14, 92], [14, 98], [14, 98], [14, 98], [15, 16], [15, 16], [15, 27], [15, 27], [15, 28], [15, 28], [15, 30], [15, 32], [15, 35], [15, 40], [15, 46], [15, 52], [15, 52], [15, 54], [15, 56], [15, 56], [15, 56], [15, 61], [15, 62], [15, 63], [15, 66], [15, 69], [15, 70], [15, 72], [15, 81], [15, 81], [15, 88], [15, 88], [15, 90], [15, 90], [15, 94], [15, 96], [15, 96], [16, 18], [16, 21], [16, 25], [16, 28], [16, 30], [16, 35], [16, 37], [16, 37], [16, 38], [16, 40], [16, 41], [16, 50], [16, 52], [16, 52], [16, 56], [16, 63], [16, 66], [16, 66], [16, 67], [16, 67], [16, 67], [16, 69], [16, 83], [16, 84], [16, 90], [16, 93], [16, 96], [17, 20], [17, 23], [17, 29], [17, 29], [17, 34], [17, 34], [17, 39], [17, 39], [17, 39], [17, 43], [17, 45], [17, 49], [17, 51], [17, 51], [17, 60], [17, 64], [17, 65], [17, 65], [17, 75], [17, 75], [17, 77], [17, 87], [17, 91], [17, 92], [17, 92], [17, 99], [18, 21], [18, 21], [18, 22], [18, 24], [18, 26], [18, 32], [18, 32], [18, 35], [18, 37], [18, 44], [18, 50], [18, 52], [18, 53], [18, 54], [18, 56], [18, 61], [18, 62], [18, 62], [18, 67], [18, 73], [18, 83], [18, 83], [18, 89], [18, 89], [18, 94], [18, 96], [19, 20], [19, 20], [19, 33], [19, 33], [19, 39], [19, 39], [19, 43], [19, 45], [19, 48], [19, 48], [19, 48], [19, 49], [19, 51], [19, 55], [19, 60], [19, 71], [19, 75], [19, 76], [19, 77], [19, 77], [19, 80], [19, 92], [19, 92], [19, 97], [19, 98], [19, 98], [19, 99], [19, 99], [20, 24], [20, 24], [20, 36], [20, 45], [20, 47], [20, 51], [20, 55], [20, 60], [20, 60], [20, 64], [20, 65], [20, 75], [20, 75], [20, 76], [20, 76], [20, 77], [20, 77], [20, 79], [20, 79], [20, 80], [20, 82], [20, 91], [21, 22], [21, 30], [21, 30], [21, 35], [21, 35], [21, 38], [21, 38], [21, 40], [21, 52], [21, 53], [21, 61], [21, 62], [21, 62], [21, 66], [21, 66], [21, 67], [21, 69], [21, 69], [21, 70], [21, 72], [21, 74], [21, 78], [21, 81], [21, 81], [21, 84], [21, 84], [21, 88], [21, 95], [21, 96], [22, 27], [22, 32], [22, 35], [22, 37], [22, 38], [22, 40], [22, 41], [22, 50], [22, 52], [22, 53], [22, 56], [22, 66], [22, 67], [22, 67], [22, 67], [22, 69], [22, 70], [22, 72], [22, 72], [22, 72], [22, 73], [22, 74], [22, 81], [22, 83], [22, 88], [22, 89], [22, 90], [22, 90], [22, 91], [22, 94], [22, 96], [22, 96], [23, 24], [23, 34], [23, 34], [23, 36], [23, 42], [23, 42], [23, 47], [23, 55], [23, 57], [23, 58], [23, 58], [23, 65], [23, 77], [23, 77], [23, 85], [23, 85], [23, 86], [23, 87], [23, 92], [23, 92], [23, 97], [23, 97], [23, 98], [23, 99], [24, 29], [24, 29], [24, 31], [24, 36], [24, 36], [24, 43], [24, 43], [24, 48], [24, 51], [24, 51], [24, 51], [24, 57], [24, 58], [24, 59], [24, 59], [24, 59], [24, 64], [24, 64], [24, 75], [24, 75], [24, 76], [24, 85], [24, 91], [24, 91], [24, 99], [25, 26], [25, 26], [25, 26], [25, 32], [25, 35], [25, 35], [25, 40], [25, 53], [25, 53], [25, 53], [25, 53], [25, 62], [25, 68], [25, 69], [25, 69], [25, 72], [25, 72], [25, 72], [25, 81], [25, 83], [25, 89], [25, 89], [25, 89], [25, 89], [25, 90], [25, 93], [25, 94], [25, 94], [25, 95], [26, 27], [26, 30], [26, 30], [26, 41], [26, 44], [26, 53], [26, 53], [26, 54], [26, 54], [26, 56], [26, 56], [26, 66], [26, 70], [26, 74], [26, 74], [26, 81], [26, 84], [26, 88], [26, 88], [26, 90], [26, 94], [26, 95], [26, 96], [27, 30], [27, 30], [27, 40], [27, 40], [27, 41], [27, 44], [27, 50], [27, 53], [27, 54], [27, 54], [27, 69], [27, 69], [27, 70], [27, 73], [27, 78], [27, 81], [27, 81], [27, 81], [27, 83], [27, 83], [27, 83], [27, 84], [27, 84], [27, 84], [27, 95], [28, 30], [28, 30], [28, 35], [28, 40], [28, 40], [28, 41], [28, 41], [28, 52], [28, 53], [28, 56], [28, 56], [28, 61], [28, 61], [28, 62], [28, 62], [28, 66], [28, 66], [28, 69], [28, 70], [28, 78], [28, 83], [28, 93], [28, 96], [29, 42], [29, 43], [29, 45], [29, 45], [29, 47], [29, 55], [29, 55], [29, 58], [29, 64], [29, 65], [29, 71], [29, 75], [29, 80], [29, 80], [29, 91], [29, 91], [29, 92], [29, 97], [29, 97], [30, 37], [30, 37], [30, 38], [30, 40], [30, 40], [30, 41], [30, 41], [30, 44], [30, 46], [30, 46], [30, 52], [30, 54], [30, 61], [30, 61], [30, 62], [30, 66], [30, 68], [30, 70], [30, 74], [30, 74], [30, 78], [30, 81], [30, 83], [30, 84], [30, 84], [30, 88], [30, 96], [31, 33], [31, 39], [31, 43], [31, 49], [31, 51], [31, 59], [31, 60], [31, 64], [31, 71], [31, 76], [31, 80], [31, 82], [31, 86], [31, 91], [31, 92], [31, 97], [31, 98], [32, 35], [32, 37], [32, 38], [32, 38], [32, 40], [32, 41], [32, 41], [32, 46], [32, 50], [32, 50], [32, 54], [32, 56], [32, 63], [32, 66], [32, 68], [32, 72], [32, 73], [32, 74], [32, 78], [32, 83], [32, 84], [32, 94], [32, 94], [32, 94], [32, 94], [32, 96], [32, 96], [33, 39], [33, 42], [33, 42], [33, 45], [33, 45], [33, 47], [33, 49], [33, 75], [33, 76], [33, 80], [33, 80], [33, 82], [33, 85], [33, 85], [33, 86], [33, 87], [33, 92], [33, 97], [33, 97], [33, 98], [34, 38], [34, 43], [34, 48], [34, 49], [34, 55], [34, 57], [34, 58], [34, 58], [34, 59], [34, 59], [34, 60], [34, 60], [34, 65], [34, 75], [34, 76], [34, 77], [34, 79], [34, 82], [34, 85], [34, 91], [34, 97], [34, 99], [35, 38], [35, 38], [35, 41], [35, 50], [35, 52], [35, 52], [35, 52], [35, 56], [35, 56], [35, 61], [35, 68], [35, 69], [35, 72], [35, 74], [35, 78], [35, 81], [35, 83], [35, 83], [35, 89], [35, 93], [35, 95], [35, 96], [36, 42], [36, 42], [36, 49], [36, 58], [36, 59], [36, 59], [36, 60], [36, 64], [36, 64], [36, 64], [36, 64], [36, 67], [36, 75], [36, 76], [36, 76], [36, 77], [36, 77], [36, 79], [36, 80], [36, 82], [36, 85], [36, 86], [36, 99], [37, 38], [37, 38], [37, 40], [37, 41], [37, 44], [37, 46], [37, 50], [37, 50], [37, 54], [37, 54], [37, 62], [37, 63], [37, 63], [37, 67], [37, 68], [37, 73], [37, 74], [37, 78], [37, 81], [37, 84], [37, 89], [37, 93], [38, 40], [38, 53], [38, 53], [38, 54], [38, 54], [38, 63], [38, 66], [38, 68], [38, 72], [38, 81], [38, 81], [38, 90], [38, 93], [38, 94], [38, 95], [38, 96], [39, 48], [39, 49], [39, 51], [39, 57], [39, 60], [39, 65], [39, 77], [39, 80], [39, 80], [39, 82], [39, 82], [39, 87], [39, 91], [39, 99], [40, 41], [40, 46], [40, 54], [40, 56], [40, 61], [40, 63], [40, 67], [40, 68], [40, 69], [40, 73], [40, 73], [40, 74], [40, 81], [40, 84], [40, 84], [40, 85], [40, 90], [40, 93], [40, 93], [40, 94], [40, 95], [41, 44], [41, 50], [41, 53], [41, 62], [41, 69], [41, 73], [41, 73], [41, 89], [41, 89], [41, 93], [41, 93], [41, 94], [41, 95], [42, 49], [42, 49], [42, 57], [42, 60], [42, 71], [42, 71], [42, 76], [42, 76], [42, 76], [42, 77], [42, 85], [42, 85], [42, 87], [42, 97], [42, 98], [43, 45], [43, 45], [43, 47], [43, 47], [43, 47], [43, 48], [43, 49], [43, 51], [43, 57], [43, 60], [43, 64], [43, 64], [43, 65], [43, 76], [43, 77], [43, 79], [43, 87], [43, 91], [43, 91], [43, 97], [43, 97], [43, 97], [43, 99], [44, 46], [44, 46], [44, 50], [44, 50], [44, 56], [44, 56], [44, 61], [44, 67], [44, 76], [44, 84], [44, 88], [44, 89], [44, 93], [44, 96], [44, 96], [44, 96], [45, 47], [45, 47], [45, 48], [45, 55], [45, 55], [45, 57], [45, 59], [45, 65], [45, 71], [45, 75], [45, 76], [45, 80], [45, 82], [45, 82], [45, 86], [45, 86], [45, 86], [45, 87], [45, 92], [45, 98], [45, 98], [45, 99], [46, 50], [46, 50], [46, 52], [46, 52], [46, 53], [46, 53], [46, 62], [46, 62], [46, 69], [46, 70], [46, 70], [46, 72], [46, 72], [46, 74], [46, 78], [46, 90], [46, 93], [46, 94], [46, 95], [47, 51], [47, 55], [47, 58], [47, 59], [47, 64], [47, 65], [47, 75], [47, 77], [47, 80], [47, 85], [47, 86], [47, 87], [47, 91], [47, 98], [48, 49], [48, 49], [48, 55], [48, 57], [48, 58], [48, 58], [48, 71], [48, 71], [48, 71], [48, 79], [48, 80], [48, 87], [48, 87], [48, 91], [48, 97], [48, 98], [48, 99], [48, 99], [49, 55], [49, 57], [49, 57], [49, 60], [49, 64], [49, 65], [49, 75], [49, 76], [49, 79], [49, 92], [49, 92], [49, 98], [49, 99], [50, 54], [50, 54], [50, 66], [50, 72], [50, 73], [50, 73], [50, 74], [50, 78], [50, 81], [50, 83], [50, 84], [50, 94], [50, 94], [50, 95], [50, 96], [50, 96], [51, 60], [51, 80], [51, 80], [51, 86], [51, 87], [51, 92], [52, 61], [52, 63], [52, 66], [52, 66], [52, 70], [52, 81], [52, 83], [52, 83], [52, 84], [52, 84], [52, 94], [52, 96], [53, 56], [53, 56], [53, 67], [53, 67], [53, 68], [53, 69], [53, 69], [53, 73], [53, 74], [53, 81], [53, 84], [53, 88], [53, 88], [53, 89], [53, 90], [53, 93], [53, 96], [53, 96], [54, 61], [54, 70], [54, 70], [54, 74], [54, 83], [54, 83], [54, 84], [54, 94], [54, 94], [55, 57], [55, 57], [55, 57], [55, 65], [55, 71], [55, 76], [55, 77], [55, 79], [55, 82], [55, 85], [55, 85], [55, 86], [55, 91], [55, 92], [55, 98], [56, 61], [56, 62], [56, 62], [56, 66], [56, 67], [56, 68], [56, 74], [56, 78], [56, 81], [56, 81], [56, 83], [56, 88], [56, 89], [56, 89], [57, 58], [57, 59], [57, 60], [57, 60], [57, 65], [57, 75], [57, 76], [57, 79], [57, 79], [57, 86], [57, 92], [57, 92], [57, 97], [57, 97], [57, 98], [57, 98], [57, 99], [58, 59], [58, 64], [58, 65], [58, 75], [58, 75], [58, 75], [58, 79], [58, 79], [58, 86], [58, 87], [58, 92], [58, 97], [58, 98], [59, 60], [59, 60], [59, 60], [59, 71], [59, 75], [59, 75], [59, 76], [59, 79], [59, 82], [59, 82], [59, 82], [59, 85], [59, 87], [59, 91], [59, 91], [59, 92], [59, 92], [59, 99], [60, 71], [60, 76], [60, 77], [60, 79], [60, 82], [60, 91], [60, 92], [60, 92], [60, 97], [60, 99], [61, 67], [61, 67], [61, 68], [61, 68], [61, 70], [61, 70], [61, 72], [61, 73], [61, 73], [61, 84], [61, 94], [62, 66], [62, 66], [62, 67], [62, 67], [62, 68], [62, 68], [62, 69], [62, 69], [62, 78], [62, 81], [62, 83], [62, 83], [62, 84], [62, 89], [62, 89], [62, 93], [62, 93], [63, 66], [63, 69], [63, 69], [63, 72], [63, 73], [63, 78], [63, 88], [63, 89], [63, 94], [63, 94], [63, 94], [63, 95], [63, 96], [63, 96], [64, 65], [64, 75], [64, 76], [64, 79], [64, 82], [64, 86], [64, 87], [64, 87], [64, 98], [64, 99], [64, 99], [65, 75], [65, 76], [65, 77], [65, 79], [65, 80], [65, 82], [65, 85], [65, 86], [65, 92], [65, 99], [66, 68], [66, 69], [66, 69], [66, 70], [66, 73], [66, 74], [66, 74], [66, 83], [66, 83], [66, 88], [66, 89], [66, 90], [66, 90], [66, 90], [66, 94], [66, 98], [67, 68], [67, 68], [67, 69], [67, 69], [67, 72], [67, 74], [67, 74], [67, 81], [67, 81], [67, 90], [67, 94], [67, 95], [68, 70], [68, 73], [68, 78], [68, 83], [68, 84], [68, 84], [68, 88], [68, 90], [69, 72], [69, 81], [69, 83], [69, 93], [69, 93], [70, 72], [70, 88], [70, 90], [70, 96], [71, 79], [71, 79], [71, 82], [71, 85], [71, 87], [71, 91], [71, 91], [71, 98], [72, 73], [72, 74], [72, 78], [72, 81], [72, 83], [72, 84], [72, 88], [72, 89], [72, 93], [72, 94], [72, 95], [73, 81], [73, 88], [73, 88], [73, 94], [73, 95], [73, 95], [73, 96], [74, 83], [74, 90], [74, 90], [74, 93], [74, 94], [74, 94], [74, 95], [74, 95], [74, 95], [75, 80], [75, 85], [75, 97], [75, 97], [76, 77], [76, 77], [76, 82], [76, 85], [76, 85], [76, 85], [76, 91], [76, 98], [76, 98], [77, 79], [77, 80], [77, 82], [77, 91], [77, 91], [77, 92], [78, 88], [78, 89], [78, 89], [78, 90], [78, 93], [78, 93], [78, 94], [78, 96], [79, 85], [79, 87], [79, 97], [79, 99], [79, 99], [80, 82], [80, 87], [80, 92], [80, 97], [80, 97], [81, 83], [81, 84], [81, 93], [81, 93], [81, 93], [81, 96], [82, 85], [82, 86], [82, 87], [82, 87], [82, 92], [82, 98], [83, 84], [83, 89], [83, 89], [83, 89], [83, 90], [83, 93], [83, 94], [83, 95], [84, 90], [84, 93], [84, 94], [85, 86], [85, 92], [85, 97], [85, 99], [85, 99], [86, 91], [86, 91], [86, 97], [86, 99], [87, 97], [87, 99], [88, 90], [88, 93], [88, 93], [88, 94], [88, 95], [88, 95], [88, 96], [89, 94], [90, 94], [90, 95], [90, 96], [91, 98], [91, 98], [91, 98], [92, 99], [93, 95], [93, 96], [94, 95], [95, 96], [97, 98], [97, 99], [98, 99], [98, 99]";

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
        EdmondsKarpMFImpl<Integer, DefaultEdge> flows = new EdmondsKarpMFImpl<Integer, DefaultEdge>(graph);
        double min = flows.calculateMaximumFlow(0,1);

        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                if (i != j)
                    if (flows.calculateMaximumFlow(i, j) < min)
                        min = flows.calculateMaximumFlow(i, j);
        System.out.println((int)min);

    }
}