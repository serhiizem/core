package core.data_structures;

@SuppressWarnings("StatementWithEmptyBody")
public class QueueTreePrinter implements TreePrinter {

    @Override
    public <Key, Value> void printTree(Tree<Key, Value> tree) {

        Stack<Node<Key, Value>> nodes = new Stack<>();

        Node<Key, Value> currentNode = tree.getRoot();

        while (currentNode != null) {
            nodes.push(currentNode);
            currentNode = currentNode.left;
        }

        while (nodes.size() > 0) {
            Node<Key, Value> node = nodes.pop();

            if (node.right != null) {
                node = node.right;

                while (node != null) {
                    nodes.push(node);
                    node = node.left;
                }
            }
        }
    }
}
