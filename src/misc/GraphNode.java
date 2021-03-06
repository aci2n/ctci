package misc;

public class GraphNode<T> {
    public T value;
    public GraphNode<T>[] adjacent;
    public Status status;

    public enum Status {
        UNVISITED, VISITING, VISITED;
    }

    public GraphNode(T value, GraphNode<T>[] adjacent) {
        this.value = value;
        this.adjacent = adjacent;
        status = Status.UNVISITED;
    }

    @SuppressWarnings("unchecked")
    public GraphNode(T value) {
        this(value, new GraphNode[0]);
    }

    public static GraphNode<Integer> intNode(int value) {
        return new GraphNode<>(value);
    }

    @SafeVarargs
    public static <T> void adjacent(GraphNode<T> node, GraphNode<T>... nodes) {
        node.adjacent = nodes;
    }
}
