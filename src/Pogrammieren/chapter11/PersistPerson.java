package Pogrammieren.chapter11;

import java.io.*;
import java.util.ArrayList;

public class PersistPerson {
    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("Klaus", "Müller"));
        personArrayList.add(new Person("Gabi", "Müller"));
        personArrayList.add(new Person("Hans", "Wurst"));
        personArrayList.add(new Person("Peter", "Andris"));

        File myPersonFile = new File(System.getProperty("user.dir") + File.separator + "personFile.txt");

        try{
            myPersonFile.createNewFile();
        } catch
        (IOException e){
            e.printStackTrace();
        }

        try(FileWriter myTextFileWriter = new FileWriter(myPersonFile)){
            for (Person currentPerson : personArrayList){
                String personStringLine = currentPerson.getName() + "," + currentPerson.getFamilyName() + "\n";

                myTextFileWriter.write(personStringLine);
            }
        } catch(IOException e){
            System.out.println("Fehler beim Schreiben der Personen Datei");
        }

        try (FileReader myPersonFileReader = new FileReader(myPersonFile);
             BufferedReader myPersonBufferedReader = new BufferedReader(myPersonFileReader)){

           String line;

           while ((line = myPersonBufferedReader.readLine()) != null){
               String[] personData = line.split(",");
               Person currentPerson = new Person(personData[0], personData[1]);

               System.out.println(currentPerson);
           }
        } catch (IOException e){
            System.out.println("Fehler beim Lesen der Personen Datei");
        }
    }
}
