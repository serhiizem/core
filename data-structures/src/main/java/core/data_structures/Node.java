package core.data_structures;

@SuppressWarnings("WeakerAccess")
public class Node<K, V> {
    public K key;
    public V value;
    public Node<K, V> left;
    public Node<K, V> right;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + " " + value;
    }
}
