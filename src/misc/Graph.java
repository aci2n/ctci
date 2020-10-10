package misc;

public class Graph<T> {
    public GraphNode<T>[] nodes;

    @SafeVarargs
    public Graph(GraphNode<T>... nodes) {
        this.nodes = nodes;
    }
}
