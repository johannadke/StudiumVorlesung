package Pogrammieren.chapter12;

public class Stack<T> {
    Node<T> firstNode = null;
    private int size = 0;

    public void push(T data){
        firstNode = new Node<>(data, firstNode);
        size ++;
    }

    public T peek(){
        if(firstNode != null) {
            return firstNode.getData();
        }
        return null;
    }

    public T pop(){
        if (firstNode != null){
            T data = firstNode.getData();
            firstNode = firstNode.getNextNode();
            size --;
            return data;
        }
        return  null;
    }

    public int getSize() {
        return size;
    }

    private class Node<T>{

        private Node<T> nextNode;
        private T data;

        public Node(T data, Node<T> nextNode){
            this.setData(data);
            this.setNextNode(nextNode);
        }

        private void setData(T data) {
            this.data = data;
        }

        private void setNextNode(Node<T> nextNode){
            this.nextNode = nextNode;
        }

        public T getData(){
            return this.data;
        }

        public Node<T> getNextNode(){
            return this.nextNode;
        }
    }
}
