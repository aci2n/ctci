package exercises;

import structs.GraphNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static structs.GraphNode.Status.*;

public class Q4_7_BuildOrder {
    private static class Node {
        String project;
        ArrayList<Node> dependencies;
        GraphNode.Status status;

        public Node(String project) {
            this.project = project;
            dependencies = new ArrayList<>();
            status = UNVISITED;
        }
    }

    private static class Dependency {
        String depended;
        String dependent;

        public Dependency(String depended, String dependent) {
            this.depended = depended;
            this.dependent = dependent;
        }

        static Dependency of(String depended, String dependent) {
            return new Dependency(depended, dependent);
        }
    }

    private static int fillBuildOrder(String[] buildOrder, int index,
                                      Node node) {
        if (node.status == VISITED) return index;
        if (node.status == VISITING) return -1;

        node.status = VISITING;

        for (var dependency : node.dependencies) {
            index = fillBuildOrder(buildOrder, index, dependency);
            if (index == -1) return -1;
        }

        node.status = VISITED;
        buildOrder[index] = node.project;

        return index + 1;
    }

    private static String[] determineBuildOrder(
            String[] projects, Dependency[] dependencies) {
        String[] buildOrder = new String[projects.length];
        Collection<Node> graph = buildGraph(projects, dependencies);

        if (graph == null) return null;

        int index = 0;

        for (var node : graph) {
            index = fillBuildOrder(buildOrder, index, node);
            if (index == -1) return null;
        }

        return buildOrder;
    }

    private static Collection<Node> buildGraph(String[] projects,
                                               Dependency[] dependencies) {
        HashMap<String, Node> nodes = new HashMap<>();

        for (String project : projects) {
            nodes.put(project, new Node(project));
        }

        for (Dependency dependency : dependencies) {
            Node depended = nodes.get(dependency.depended);
            Node dependent = nodes.get(dependency.dependent);

            if (depended == null || dependent == null) {
                return null;
            }

            dependent.dependencies.add(depended);
        }

        return nodes.values();
    }

    public static void main(String[] args) {
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f"};
        Dependency[] dependencies = new Dependency[]{
                Dependency.of("a", "d"),
                Dependency.of("f", "b"),
                Dependency.of("b", "d"),
                Dependency.of("f", "a"),
                Dependency.of("d", "c")
        };
        String[] buildOrder = determineBuildOrder(projects, dependencies);

        for (String project : buildOrder) {
            System.out.print(project + " ");
        }
    }
}
