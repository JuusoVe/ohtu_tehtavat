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
        for (int i = 0; i < ostokset.size() ; i++) {
            tavaroita = tavaroita + ostokset.get(i).lukumaara();
        }
        return tavaroita;
    }
 
    public int hinta() {
        if (ostokset.size() < 1) {
            return 0;
        }
        int hinta = 0;
        for (int i = 0; i < ostokset.size() ; i++) {
            hinta += ostokset.get(i).hinta();
        }
        return hinta;
    }
 
    public void lisaaTuote(Tuote lisattava) {
        if ((ostokset.size() < 1)) {
            ostokset.add(new Ostos(lisattava));
            return;
        }
        for (int i = 0; i < ostokset.size() ; i++) {
            Ostos ostos = ostokset.get(i);
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(1);
                return;
            }
        }
        ostokset.add(new Ostos(lisattava));
    }
 
    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }
 
    public List<Ostos> ostokset() {
        return ostokset;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
