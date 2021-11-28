package ohtu;

import java.util.List;

import java.util.ArrayList;

public class Ostoskori {

    private List<Ostos> ostokset;

    public Ostoskori() {
        this.ostokset = new ArrayList<Ostos>();
    }
 
    public int tavaroitaKorissa() {
        if (ostokset.size() < 1) {
            return 0;
        }
        int tavaroita = 0;
        for (Ostos ostos : ostokset) {
            tavaroita = tavaroita + ostos.lukumaara();
        }
        return tavaroita;
    }
 
    public int hinta() {
        if (ostokset.size() < 1) {
            return 0;
        }
        int hinta = 0;
        for (Ostos ostos : ostokset) {
            hinta += ostos.hinta();
        }
        return hinta;
    }
 
    public void lisaaTuote(Tuote lisattava) {
        for (Ostos ostos : ostokset) {
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(1);
                return;
            }
        }
        ostokset.add(new Ostos(lisattava));
    }
 
    public void poista(Tuote poistettava) {
        for (Ostos ostos : ostokset) {
            if (ostos.tuotteenNimi().equals(poistettava.getNimi())) {
                ostos.muutaLukumaaraa(-1);
                if (ostos.lukumaara() <= 0) {
                    ostokset.remove(ostos);
                }
                return;
            }
        }
    }
 
    public List<Ostos> ostokset() {
        return ostokset;
    }
 
    public void tyhjenna() {
        this.ostokset = new ArrayList<Ostos>();
    }
}
