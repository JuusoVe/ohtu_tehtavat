package ohtu;

import java.util.Arrays;
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
    public void kahdenTuotteenLisaamisenJalkeenOnKaksiTuotettaKorissa() { 
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

}
