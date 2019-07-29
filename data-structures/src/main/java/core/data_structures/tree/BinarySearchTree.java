package core.data_structures.tree;

public class BinarySearchTree<Key extends Comparable<Key>, Value>
        implements Tree<Key, Value> {

    private Node<Key, Value> root;

    public BinarySearchTree(Node<Key, Value> root) {
        this.root = root;
    }

    @Override
    public void put(Key key, Value value) {
        this.put(this.root, key, value);
    }

    private Node<Key, Value> put(Node<Key, Value> root, Key key, Value value) {
        if (root == null) {
            return new Node<>(key, value);
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        }
        if (cmp > 0) {
            root.right = put(root.right, key, value);
        }
        if (cmp == 0) {
            root.value = value;
        }
        return root;
    }

    @Override
    public Value get(Key key) {
        Node<Key, Value> currentNode = this.root;
        while (currentNode != null) {
            int cmp = currentNode.key.compareTo(key);
            if (cmp < 0) {
                currentNode = currentNode.left;
            }
            if (cmp > 0) {
                currentNode = currentNode.right;
            }
            if (cmp == 0) {
                return currentNode.value;
            }
        }
        return null;
    }

    @Override
    public Node<Key, Value> getRoot() {
        return this.root;
    }
}
