package Pogrammieren.Klausurvorbereitung.Datenstrukturen;

public class QueueRun {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(47);
        queue.enqueue(67);
        queue.enqueue(100);
        queue.printQueue();

        System.out.println(queue.dequeue());
        queue.printQueue();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.printQueue();

        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);

        queue.printQueue();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.printQueue();
        Queue<String> queueString = new Queue<>();

        queueString.enqueue("Prozess 1");
        queueString.enqueue("Prozess 2");
        queueString.enqueue("Prozess 3");
        queueString.enqueue("Prozess 4");

        System.out.println(queueString.dequeue());
        System.out.println(queueString.dequeue());
        System.out.println(queueString.dequeue());
        System.out.println(queueString.dequeue());
        System.out.println(queueString.dequeue());

        queueString.enqueue("Prozess 1");
        queueString.enqueue("Prozess 2");

        System.out.println(queueString.dequeue());
        System.out.println(queueString.dequeue());
        System.out.println(queueString.dequeue());

    }
}
