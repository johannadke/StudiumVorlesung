package Pogrammieren.chapter9;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class IteratorTreeSetPage32 {
    public static void main(String[] args) {
        Set<String> mySet = new TreeSet<>();
        mySet.add("Otto");
        mySet.add("Karl");
        mySet.add("Ludwig");

        System.out.println(mySet.contains("Otto"));
        System.out.println(mySet.size());

        Iterator<String> i = mySet.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        mySet.clear();
        System.out.println(mySet.size());

        System.out.println("---------------------------------------------------------------------");

        Set<FullName> fullNameSet = new TreeSet<>();

        fullNameSet.add(new FullName("Klaus", "Schmidt"));
        fullNameSet.add(new FullName("Gabi", "Müller"));
        fullNameSet.add(new FullName("Franz", "Müller"));
        fullNameSet.add(new FullName("Zeus", "Gott"));
        fullNameSet.add(new FullName("Klaus", "Schmidt"));
        fullNameSet.add(new FullName("Aidan", "Zimmer"));
        fullNameSet.add(new FullName("Aidan", "Adams"));


        Iterator<FullName> ifn = fullNameSet.iterator();
        while (ifn.hasNext()){
            System.out.println(ifn.next());
        }

    }
}
