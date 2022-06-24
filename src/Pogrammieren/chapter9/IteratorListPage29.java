package Pogrammieren.chapter9;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorListPage29 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Otto");
        myList.add("Karl");
        myList.add("Ludwig");
        myList.add("AUTOOOOOO");
        myList.add(2,"Otto");
        myList.set(3,"Überschreibt den Ludwig!");


        System.out.println(myList.contains("Otto"));
        //System.out.println(myList.indexOf("Ludwig"));
        System.out.println(myList.get(3));
        System.out.println(myList.size());

        System.out.println("Iterator forwards");
        Iterator<String> i = myList.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        System.out.println("Iterator backwards");
        ListIterator listIterator = myList.listIterator(myList.size());
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

        myList.clear();
        System.out.println(myList.size());

    }
}
