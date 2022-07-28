package Pogrammieren.Klausurvorbereitung.Probeklausur.Datenstrukturen;

public class Tree<V> {
    Node<V> root = null;
    public void insert(V data) {
        if (root == null) {
            root = new Node<V>(data);
        } else {
            insert(root, data);
        }
    }
    @SuppressWarnings("unchecked")
    private void insert(Node<V> node, V data) {
        if (((Comparable<V>)node.getData()).compareTo((V) data) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<V>(data));
            } else {
                insert(node.getLeft(), data);
            }
        } else if (((Comparable<V>)node.getData())
                .compareTo((V) data) < 0) {
            if (node.getRight() == null) {
                node.setRight(new Node<V>(data));
            } else {
                insert(node.getRight(), data);
            }
        }
    }
    @Override
    public String toString() {
        String s = "";
        if (root != null) {
            s = toString(root);
        } else {
            s = "Empty Tree";
        }
        return s;
    }
    private String toString(Node<V> node) {
        String s = "";

        if(node.getLeft() != null){
            s += toString(node.getLeft());
        }

        s += node.getData();
        s += ", ";

        if(node.getRight() != null){
            s += toString(node.getRight());
        }

        return s;
    }

    public void delete(V data) {
        root = deleteNode(root, data);
    }
    @SuppressWarnings("unchecked")
    private Node<V> deleteNode(Node<V> node, V data) {
        if (node != null) {
            if (data.equals(node.getData())) {
                if ((node.getLeft() == null)
                        && (node.getRight() == null)) {
                    node = null;
                } else {
                    if (node.getRight() == null)
                        node = node.getLeft();
                    else {
                        if (node.getLeft() == null)
                            node = node.getRight();
                        else {
                            Node<V> preRight = null;
                            Node<V> right = node.getLeft();
                            while (right.getRight() != null){
                                preRight = right;
                                right = right.getRight();
                            }
                            if (preRight != null) {
                                preRight
                                        .setRight(right.getLeft());
                                right
                                        .setLeft(node.getLeft());
                            }
                            right.setRight(node.getRight());
                            node = right;
                        }
                    }
                }
            } else {
                if (((Comparable<V>) data)
                        .compareTo((V) node.getData()) > 0)
                    node.setRight(deleteNode(node
                            .getRight(), data));
                else
                    node
                            .setLeft(deleteNode(node.getLeft(), data));
            }
        }
        return node;
    }

    private class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        public Node(T data) {
            this.data = data;
        }
        public T getData() {
            return data;
        }
        public Node<T> getLeft() {
            return left;
        }
        public Node<T> getRight() {
            return right;
        }
        public void setLeft(Node<T> left) {
            this.left = left;
        }
        public void setRight(Node<T> right) {
            this.right = right;
        }
    }
}
