package structs;

public class Graph<T> {
    public GraphNode<T>[] nodes;

    public Graph(GraphNode<T>[] nodes) {
        this.nodes = nodes;
    }
}
