package Pogrammieren.Klausurvorbereitung.Probeklausur.Datenstrukturen;

public class WordIWantToLearnRun {
    public static void main(String[] args) {
        WordsIWantToLearn stack = new WordsIWantToLearn();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
