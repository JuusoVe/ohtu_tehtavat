package ohtu;

public class Main {
    public static void main(String[] args) {
        // testikoodi tänne
        Ostoskori kori = new Ostoskori();
        Tuote maito = new Tuote("maito", 3);
        Tuote leipä = new Tuote("leipä", 5);
        kori.lisaaTuote(maito);
        kori.poista(maito);

    }
}