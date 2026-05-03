import java.util.*;
public class BST<K extends Comparable<K>, V> {

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node x, K key, V val) {
        if (x == null) return new Node(key, val);

        int cmp = key.compareTo(x.key);

        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;

        return x;
    }

    public V get(K key) {
        Node x = root;

        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }

        return null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }

    public Iterable<Node> iterator() {
        List<Node> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(Node x, List<Node> list) {
        if (x == null) return;
        inorder(x.left, list);
        list.add(x);
        inorder(x.right, list);
    }

    public K getKey(Node node) {
        return node.key;
    }

    public V getValue(Node node) {
        return node.val;
    }
}