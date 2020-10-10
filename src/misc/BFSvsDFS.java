package misc;

import java.util.LinkedList;

import static misc.GraphNode.Status.*;

public class BFSvsDFS {
    static void printBFS(Graph<String> graph) {
        LinkedList<GraphNode<String>> queue = new LinkedList<>();

        for (GraphNode<String> node : graph.nodes) {
            node.status = UNVISITED;
        }

        for (GraphNode<String> start : graph.nodes) {
            queue.addLast(start);

            while (!queue.isEmpty()) {
                GraphNode<String> node = queue.pop();

                if (node.status == VISITED) continue;

                for (GraphNode<String> adjacent: node.adjacent) {
                    queue.addLast(adjacent);
                }

                System.out.println(node.value);
                node.status = VISITED;
            }
        }
    }

    static void printDFS(Graph<String> graph) {
        for (GraphNode<String> node : graph.nodes) {
            node.status = UNVISITED;
        }

        for (GraphNode<String> node : graph.nodes) {
            printNodeDFS(node);
        }
    }

    static void printNodeDFS(GraphNode<String> node) {
        if (node.status != UNVISITED) return;

        node.status = VISITING;

        for (GraphNode<String> adjacent : node.adjacent) {
            printNodeDFS(adjacent);
        }

        System.out.println(node.value);
        node.status = VISITED;
    }

    public static void main(String[] args) {
        GraphNode<String> a = new GraphNode<>("a");
        GraphNode<String> b = new GraphNode<>("b");
        GraphNode<String> c = new GraphNode<>("c");
        GraphNode<String> d = new GraphNode<>("d");
        GraphNode<String> e = new GraphNode<>("e");
        GraphNode<String> f = new GraphNode<>("f");
        GraphNode<String> g = new GraphNode<>("g");

        GraphNode.adjacent(a, b, c, d);
        GraphNode.adjacent(b, a, f);
        GraphNode.adjacent(c, e);
        GraphNode.adjacent(d, a, e);
        GraphNode.adjacent(e, c, d, e);
        GraphNode.adjacent(f, b, a);

        Graph<String> graph = new Graph<>(a, b, c, d, e, f, g);

        System.out.println("--BFS--");
        printBFS(graph);

        System.out.println("--DFS--");
        printDFS(graph);
    }
}
