package Pogrammieren.chapter12;

public class BinaryTreeExample {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.add(30);
        binaryTree.add(60);
        binaryTree.add(80);
        binaryTree.add(50);
        binaryTree.add(10);
        binaryTree.add(20);
        binaryTree.add(15);
        binaryTree.add(0);
        binaryTree.add(100);

        System.out.println("Binary Tree - path traversals");
        binaryTree.printInOrder();
        binaryTree.printPreOrder();
        binaryTree.printPostOrder();

        System.out.println("Baum ist fertig");

        System.out.println("Größe: " + binaryTree.size());
    }
}
