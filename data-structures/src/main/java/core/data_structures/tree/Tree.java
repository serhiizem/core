package core.data_structures.tree;

import core.data_structures.tree.Node;

public interface Tree<Key, Value> {
    void put(Key key, Value value);
    Value get(Key key);
    Node<Key, Value> getRoot();
}
