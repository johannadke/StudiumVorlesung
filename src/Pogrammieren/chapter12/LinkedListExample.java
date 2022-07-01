package Pogrammieren.chapter12;

public class LinkedListExample {
    public static void main(String[] args) {

        LinkedList wordList = new LinkedList();

        System.out.println("Listenelement Erstens: " + wordList.contain("Erstens"));

        wordList.add("Erstens");
        wordList.add("Zweitens");
        wordList.add("Drittens");

        //System.out.println("Liste beendet");

        System.out.println("Listengröße: " + wordList.size());
        wordList.printList();
        System.out.println("Listenelement Erstens: " + wordList.contain("Erstens"));

        System.out.println(wordList.remove("Zweitens"));
        wordList.printList();
        System.out.println("Listenelement Zweitens: " + wordList.contain("Zweitens"));
        System.out.println("Listenelement Drittens: " + wordList.contain("Drittens"));
        System.out.println("Listengröße: " + wordList.size());

    }
}
