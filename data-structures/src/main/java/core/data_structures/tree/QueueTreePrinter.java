package core.data_structures.tree;

import core.data_structures.stack.SequentialStack;

public class QueueTreePrinter implements TreePrinter {

    @Override
    public <Key, Value> void printTree(Tree<Key, Value> tree) {

        SequentialStack<Node<Key, Value>> nodes = new SequentialStack<>();

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
