package ohtu;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;
    Tuote maito;
    Tuote leipä;

    @Before
    public void setUp() {
        kori = new Ostoskori();
        maito = new Tuote("maito", 3);
        leipä = new Tuote("leipä", 5);
    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() { 
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.tavaroitaKorissa());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenOnYksiTuoteKorissa() { 
        kori.lisaaTuote(maito);
        assertEquals(1, kori.tavaroitaKorissa());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenHintaOnTuottenHinta() { 
        kori.lisaaTuote(maito);
        assertEquals(3, kori.hinta());
    }

    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenOnKaksiTuotettaKorissa() { 
        kori.lisaaTuote(maito);
        kori.lisaaTuote(leipä);
        assertEquals(2, kori.tavaroitaKorissa());
    }

    @Test
    public void kahdenTuotteenLisaamisenJalkeenHintaOnHintojenSumma() { 
        kori.lisaaTuote(maito);
        kori.lisaaTuote(leipä);
        assertEquals(8, kori.hinta());
    }

    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenOnYksiKorissaJaHinta2x() { 
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        assertEquals(2, kori.tavaroitaKorissa());
        assertEquals(1, kori.ostokset().size());
        assertEquals(6, kori.hinta());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        kori.lisaaTuote(maito);
        List<Ostos> ostokset = kori.ostokset();
        assertEquals(1, ostokset.size());
    }

    @Test
    public void yhdenTuotteenLisaamisenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        kori.lisaaTuote(maito);
        Ostos ostos = kori.ostokset().get(0);
        assertEquals(ostos.tuotteenNimi(), "maito");
        assertEquals(1, ostos.lukumaara());
    }
    @Test
    public void kahdenSamanTuotteenLisaamisenJaYhdenPoistamisenJalkeenKorissaYksiOstosJossaLkmYksi() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);
        kori.poista(maito);
        Ostos ostos = kori.ostokset().get(0);
        assertEquals(1, kori.tavaroitaKorissa());
        assertEquals(1, ostos.lukumaara());
    }

    @Test
    public void yhdenTuottenLisaamisenJaPoistamisenJalkeenKoriOnTyhja() {
        kori.lisaaTuote(maito);
        kori.poista(maito);
        assertEquals(0, kori.tavaroitaKorissa());
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.ostokset().size());
    } 

}
