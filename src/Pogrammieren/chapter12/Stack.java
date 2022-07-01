package Pogrammieren.chapter12;

public class Stack<T> {
    Node<T> firstNode = null;

    public void push(T data){
        firstNode = new Node<>(data, firstNode);
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
            return data;
        }
        return  null;
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
