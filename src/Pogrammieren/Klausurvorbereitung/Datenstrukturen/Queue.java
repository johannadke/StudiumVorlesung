package Pogrammieren.Klausurvorbereitung.Datenstrukturen;

public class Queue<T> {
    public Node<T> firstNode;
    public Node<T> lastNode;

    public boolean enqueue(T data){
        Node<T> newNode = new Node<>(data);

        if(this.firstNode == null){
            this.firstNode = newNode;
            this.lastNode = newNode;
            return true;
        }

        firstNode.setLeftNode(newNode);
        newNode.setRightNode(firstNode);
        firstNode = newNode;
        return true;
    }

    public void printQueue(){
        if(firstNode == null){
            System.out.println("Queue ist leer");
            return;
        }
        System.out.println("Queue:");
        printQueue(firstNode);
        System.out.println();
    }

    private void printQueue(Node<T> currentNode){
        System.out.print(currentNode.getData() + ", ");
        if(currentNode.getRightNode() != null){
            printQueue(currentNode.getRightNode());
        }
    }

    public T dequeue(){
        T result;
        if(lastNode != null) {
             result = this.lastNode.getData();
            if (firstNode != lastNode) {
                lastNode.getLeftNode().setRightNode(null);
                this.lastNode = lastNode.getLeftNode();
            } else {
                this.lastNode = null;
                this.firstNode = null;
            }
        } else{
            result = null;
        }
        return result;

    }

    private class Node<T>{
        private T data;
        private Node<T> rightNode;
        private Node<T> leftNode;

        public Node(T data){
            this.data = data;
        }

        public void setData(T data){
            this.data = data;
        }

        public T getData(){
            return this.data;
        }

        public void setLeftNode(Node<T> leftNode){
            this.leftNode = leftNode;
        }

        public Node<T> getLeftNode(){
            return this.leftNode;
        }

        public void setRightNode(Node<T> rightNode){
            this.rightNode = rightNode;
        }

        public Node<T> getRightNode(){
            return this.rightNode;
        }
    }
}
