package ModerneProgrammierkonzepte;

import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        //begrenzung = input()
        int begrenzung = 40;
        fibonacci();
    }

    private static void fibonacci() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter max:");
        int begrenzung = input.nextInt();
        int vorherigerWert = 1;
        int aktuellerWert = 1;
        System.out.println(vorherigerWert);
        while (aktuellerWert <= begrenzung) {
            System.out.println(aktuellerWert);
            int zwischenwert = aktuellerWert;
            aktuellerWert = vorherigerWert + aktuellerWert;
            vorherigerWert = zwischenwert;
        }
    }
}
