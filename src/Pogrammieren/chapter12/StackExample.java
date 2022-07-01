package Pogrammieren.chapter12;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();

        myStack.push("Hello");
        myStack.push("my");
        myStack.push("darling");
        myStack.push("i");
        myStack.push("l");
        myStack.push("u");

        System.out.println(myStack.pop());

        System.out.println(myStack.peek());
    }


}
