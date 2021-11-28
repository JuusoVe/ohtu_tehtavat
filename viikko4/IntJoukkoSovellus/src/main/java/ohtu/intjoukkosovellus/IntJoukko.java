
package ohtu.intjoukkosovellus;

import java.util.stream.IntStream;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] luvutArr;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        luvutArr = new int[OLETUSKAPASITEETTI];
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti <= 0) {
            return;
        }
        alustaJoukko(kapasiteetti);
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti <= 0  || kasvatuskoko <= 0) {
            return;
        }
        alustaJoukko(kapasiteetti);
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    private void alustaJoukko(int kapasiteetti) {
        luvutArr = new int[kapasiteetti];
        for (int i = 0; i < kapasiteetti; i++) {
            luvutArr[i] = Integer.MAX_VALUE;
        }
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        if (alkioidenLkm >= luvutArr.length) {
            kasvata();
        }
        luvutArr[alkioidenLkm] = luku;
        alkioidenLkm++;
        return true;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luvutArr[i] == luku) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        boolean shifting = false;
        for (int i = 0; i < luvutArr.length; i++) {
            if (luvutArr[i] == luku) {
                shifting = true;
                alkioidenLkm--;
            }
            if (shifting && i + 1 < luvutArr.length) {
                luvutArr[i] = luvutArr[i+1];
            }
        }
        return !shifting;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        if (vanha.length > uusi.length) {
            return;
        }
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    private void kasvata() {
        int[] uusiTaulukko = new int[luvutArr.length + kasvatuskoko];
        kopioiTaulukko(luvutArr, uusiTaulukko);
        luvutArr = uusiTaulukko;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvutArr[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        for (int alkio : a.toIntArray()) {
            yhdiste.lisaa(alkio);
        }
        for (int alkio : b.toIntArray()) {
            yhdiste.lisaa(alkio);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        for(int alkioA : a.toIntArray()) {
            if (IntStream.of(b.toIntArray()).anyMatch(alkioB -> alkioB == alkioA) ) {
                leikkaus.lisaa(alkioA);
            }
        }
        return leikkaus;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(bTaulu[i]);
        }
        return erotus;
    }


    

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + luvutArr[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += luvutArr[i];
                tuotos += ", ";
            }
            tuotos += luvutArr[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }
        
}
