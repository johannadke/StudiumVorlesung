package Pogrammieren.chapter11;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class FileSystemAccess {
    public static void main(String[] args) {

        //some Code missing :-)

        Properties systemProperties = System.getProperties();
        /*Set systemPropertyKeys = System.*/

        System.out.println("user.dir Information");
        System.out.println("=====================");
        File userDir = new File(System.getProperty("user.dir"));

        System.out.println("Name: " + userDir.getName());
        System.out.println("Pfad: " + userDir.getPath());
        System.out.println("Existiert: " + userDir.exists());
        System.out.println("Lesezugriff: " + userDir.canRead());
        System.out.println("Schreibzugriff: " + userDir.canWrite());
        System.out.println("Ist Verzeichnis: " + userDir.isDirectory());
        System.out.println("Ist Datei: " + userDir.isFile());

        File[] userDirContent = userDir.listFiles();
        for (File currentFile : userDirContent){
            System.out.println("- Name: " + currentFile.getName() + "; Pfad" + currentFile.getPath());
        }

        //Ausgabe aller Dateien
        //listFilesForFolders(userDir, 0);

        System.out.println("Umgang mit Verzeichnissen uns Dateien");
        System.out.println("=====================");

        //Verzeichnis anlegen
        File myDirectory = new File(System.getProperty("user.dir") + File.separator + "myDirectory"); //Backslash mit File.separator

        System.out.println("Name: " + myDirectory.getName());
        System.out.println("Pfad: " + myDirectory.getPath());
        System.out.println("Existiert: " + myDirectory.exists());

        System.out.println(myDirectory.mkdir()); //wirklich als Verzeichnis anlegen

        System.out.println("Name: " + myDirectory.getName());
        System.out.println("Pfad: " + myDirectory.getPath());
        System.out.println("Existiert: " + myDirectory.exists());

        //Datei anlegen
        File myFile = new File(myDirectory.getPath() + File.separator + "myFile.txt");

        System.out.println("Name: " + myFile.getName());
        System.out.println("Pfad: " + myFile.getPath());
        System.out.println("Existiert: " + myFile.exists());

        try {
            System.out.println(myFile.createNewFile()); // bei Directory keine Exception, aber bei File
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Name: " + myFile.getName());
        System.out.println("Pfad: " + myFile.getPath());
        System.out.println("Existiert: " + myFile.exists());

        File myRenamedFile = new File(myDirectory.getPath() + File.separator + "myRenamedFile.txt"); //eher move als rename

        System.out.println("Name: " + myRenamedFile.getName());
        System.out.println("Pfad: " + myRenamedFile.getPath());
        System.out.println("Existiert: " + myRenamedFile.exists());

        myFile.renameTo(myRenamedFile);

        System.out.println("Name: " + myFile.getName());
        System.out.println("Pfad: " + myFile.getPath());
        System.out.println("Existiert: " + myFile.exists());

        System.out.println("Name: " + myRenamedFile.getName());
        System.out.println("Pfad: " + myRenamedFile.getPath());
        System.out.println("Existiert: " + myRenamedFile.exists());

        //Input Byte Stream
        System.out.println("Einlesen von Daten über System.in (Byte)");
        System.out.println("=================================");

        System.out.println("Bitte einen Text eingeben:");

        byte[] input = new byte[255];

        try{
            System.in.read(input, 0, input.length);
        } catch (IOException e){
            System.out.println("Fehler beim lesen von der Konsole");
        }

        System.out.println(input);
        System.out.println(new String(input));

        //Input Character Stream
        System.out.println("Einlesen von Daten über System.in (Character)");
        System.out.println("=================================");

        InputStreamReader systemInReader = new InputStreamReader(System.in);
        BufferedReader systemInBufferedReader = new BufferedReader(systemInReader);

        ArrayList<String> linesReadFromConsole = new ArrayList();

        System.out.println("Bitte Text eingeben (beenden mit exit)");

        while (true){

            try {
                String inputLine = systemInBufferedReader.readLine();
                if (inputLine.equalsIgnoreCase("exit")){
                    break;
                }
                linesReadFromConsole.add(inputLine);
            } catch (IOException e) {
                System.out.println("Fehler beim Lesen von der Konsole");
            }
        }
        System.out.println("Ausgabe von Konsolen Text: ");
        for (String line : linesReadFromConsole) {
            System.out.println(line);
        }
        FileWriter myTextFileWriter = null;

        try {
            myTextFileWriter = new FileWriter(myRenamedFile);
            for (String line : linesReadFromConsole) {
                //myTextFileWriter.write(line + "\n");
                myTextFileWriter.append(line + "\n");
            }

        } catch (IOException e) {
            System.out.println("Fehler beim SChreiben der Datei!");
        } finally {
            try {
                myTextFileWriter.close();
            } catch (IOException e){
                System.out.println("Fehler beim Schließen des File Writers");
            }
        }

        System.out.println("Datei auslesen:");
        System.out.println("=================");

        try (FileReader myTextFileReader = new FileReader(myRenamedFile);
        BufferedReader myTextFileBufferedReader = new BufferedReader(myTextFileReader)){
            String line;
            while ((line = myTextFileBufferedReader.readLine()) != null){ // Wenn null nicht mehr in While Schleife
                System.out.println(line);
            }

        } catch (IOException e){
            System.out.println("Fehler beim Lesen der Datei.");
        }

        //myRenamedFile.delete();
        //myDirectory.delete(); // wenn was im Verzeichnis ist wird Verzeichnis nicht gelöscht --> es gibt eine Force Methode
    }

    private static void listFilesForFolders(File folder, int identation) {
        for (File currentFile : folder.listFiles()) {
            if (currentFile.isDirectory()) {
                listFilesForFolders(currentFile, identation+1);
            } else {
                System.out.println("- Name: " + currentFile.getName() + "; Pfad" + currentFile.getPath());
            }
        }
    }


}
