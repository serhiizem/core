package core.data_structures;

public class QueueTreePrinter implements TreePrinter {

    @Override
    public <Key, Value> void printTree(Tree<Key, Value> tree) {
        Queue<Node<Key, Value>> nodes = new Queue<>();

        Node<Key, Value> root = tree.getRoot();
        if (root != null) {
            nodes.enqueue(root);
        }

        while (!nodes.isEmpty()) {
            Node<Key, Value> node = nodes.dequeue();

            Node<Key, Value> left = node.left;
            if (left != null) {
                nodes.enqueue(left);
            }

            Node<Key, Value> right = node.right;
            if (right != null) {
                nodes.enqueue(right);
            }
        }
    }
}
