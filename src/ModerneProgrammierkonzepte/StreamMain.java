package ModerneProgrammierkonzepte;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        String file = "C:\\Users\\I550820\\OneDrive\\Studium\\2. Semester\\Programmieren 2\\Progr2TestRepo\\src\\ModerneProgrammierkonzepte\\Personen.txt";
        try {
            Stream<String> personStream = Files.lines(Paths.get(file));
            personStream
                    .map(x -> x.split(","))
                    .filter(x -> Integer.parseInt(x[1]) >= 50)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
            System.out.println(personStream.getClass());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
