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
            tavaroita += ostokset.get(i).lukumaara();
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
        ostokset.add(new Ostos(lisattava));
    }
 
    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }
 
    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
 
        return null;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
