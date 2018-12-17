import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public Game() {
    }

    public static int losowanieLiczby() throws FileNotFoundException {
        Random random = new Random();
        int wylosowanaLiczba = random.nextInt(100);
        System.out.println(wylosowanaLiczba);
        return wylosowanaLiczba;
    }

    public static void gra() throws IOException {
        int licznik = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj nick graczu: ");
        String nick = in.nextLine();
        System.out.println("Podaj liczbę graczu: ");
        int liczbaGracza = in.nextInt();
        System.out.println("Liczba gracza to: " + liczbaGracza);

        for(int wylosowanaLiczba = losowanieLiczby(); liczbaGracza != wylosowanaLiczba; ++licznik) {
            System.out.println("Podaj kolejną liczbę: ");
            liczbaGracza = in.nextInt();
            if (liczbaGracza < wylosowanaLiczba) {
                System.out.println("Podałeś za małą wartość");
            }

            if (liczbaGracza > wylosowanaLiczba) {
                System.out.println("Podałeś za dużą wartość");
            }
        }

        System.out.println("Gratulacje");
        zapiszDoPliku(nick, licznik);
    }

    public static void zapiszDoPliku(String nick, int wynik) throws IOException {
        FileWriter fileWriter = new FileWriter("plikGra.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("\n" + nick + wynik);
        bufferedWriter.close();
    }}

//    public static String[] sortowanie(String []tabliceGraczy){
//
//    }
//}
