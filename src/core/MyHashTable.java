public class MyHashTable<K, V> {
    public interface Hasher<K> {
        int apply(K value);
    }

    public class Node {
        Node next;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    private Hasher<K> hasher;
    private Object[] nodes;

    MyHashTable(Hasher<K> hasher)  {
        this.hasher = hasher;
        nodes = new Object[100];
    }

    private int getIndex(K key) {
        int hash = hasher.apply(key);
        return hash % nodes.length;
    }

    @SuppressWarnings("unchecked")
    private Node getNode(int index) {
        return (Node) nodes[index];
    }

    public Node set(K key, V value) {
        int index = getIndex(key);
        Node root = getNode(index);
        Node newNode = new Node(key, value);

        if (root == null) {
            nodes[index] = newNode;
        } else {
            insertOrReplace(root, newNode);
        }

        return newNode;
    }

    private void insertOrReplace(Node root, Node newNode) {
        Node previous = root;

        for (Node node = root; node != null; node = node.next) {
            if (node.key.equals(newNode.key)) {
                node.value = newNode.value;
                return;
            }
            previous = node;
        }

        previous.next = newNode;
    }

    public V get(K key) {
        int index = getIndex(key);

        for (Node node = getNode(index); node != null; node = node.next) {
            if (node.key.equals(key))  {
                return node.value;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        MyHashTable<String, String> map = new MyHashTable<>(string -> {
            return string.charAt(string.length() - 1);
        });

        map.set("keyA", "valueA");
        map.set("keyB", "valueB");


        System.out.println("keyA: " + map.get("keyA"));
        System.out.println("keyB: " + map.get("keyB"));

        map.set("otraKeyA", "otroValueA");
        map.set("keyA", "valueA2");

        System.out.println("keyA: " + map.get("keyA"));
        System.out.println("keyB: " + map.get("keyB"));
        System.out.println("otraKeyA: " + map.get("otraKeyA"));
    }
}