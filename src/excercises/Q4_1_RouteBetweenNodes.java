package excercises;

import structs.Graph;
import structs.GraphNode;

import java.util.LinkedList;

import static structs.GraphNode.Status.*;

public class Q4_1_RouteBetweenNodes {
    // DFS
    private static boolean hasRouteDFS(
            GraphNode<Integer> from,
            GraphNode<Integer> to) {
        if (from == to) {
            return true;
        }

        for (GraphNode<Integer> node : from.adjacent) {
            if (node == to) {
                return true;
            }

            if (node.status == UNVISITED) {
                node.status = VISITED;

                if (hasRouteDFS(node, to)) {
                    return true;
                }
            }
        }

        return false;
    }

    // BFS
    private static boolean hasRoute(
            Graph<Integer> graph,
            GraphNode<Integer> from,
            GraphNode<Integer> to) {
        LinkedList<GraphNode<Integer>> queue = new LinkedList<>();

        for (var node : graph.nodes) {
            node.status = UNVISITED;
        }

        queue.add(from);

        while (!queue.isEmpty()) {
            var node = queue.removeFirst();

            for (var adjacent : node.adjacent) {
                if (adjacent.status == UNVISITED) {
                    if (adjacent == to) {
                        return true;
                    }

                    adjacent.status = VISITING;
                    queue.add(adjacent);
                }
            }

            node.status = VISITED;
        }

        return false;
    }

    public static void main(String[] args) {
        var a = GraphNode.intNode(1);
        var b = GraphNode.intNode(2);
        var c = GraphNode.intNode(3);
        var d = GraphNode.intNode(4);

        GraphNode.adjacent(a, b, c);
        GraphNode.adjacent(b, c, d);
        GraphNode.adjacent(c, d);
        GraphNode.adjacent(d);

        var graph = new Graph<>(a, b, c, d);

        assert hasRoute(graph, a, b);
        assert hasRoute(graph, a, c);
        assert hasRoute(graph, a, d);
        assert hasRoute(graph, b, c);
        assert hasRoute(graph, b, d);
        assert hasRoute(graph, c, d);

        assert !hasRoute(graph, c, b);
        assert !hasRoute(graph, d, a);
    }
}
