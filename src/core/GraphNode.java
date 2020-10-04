public class GraphNode<T> {
    public T value;
    public GraphNode<T>[] adjacent;

    public GraphNode(T value, GraphNode<T>[] adjacent) {
        this.value = value;
        this.adjacent = adjacent;
    }
}
