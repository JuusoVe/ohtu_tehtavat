package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void hakuLöytääPelaajan() {
        Player pelaaja = stats.search("Kurri");
        assertEquals("Kurri", pelaaja.getName());
    }
    
    @Test
    public void hakuPalauttaaNullJosEiPelaajaa() {
        Player pelaaja = stats.search("Körri");
        assertEquals(null, pelaaja);
    }
    
    @Test
    public void joukkueHakuPalauttaaOikeinMäärän() {
        List<Player> joukkue = stats.team("EDM");
        assertEquals(3, joukkue.size());
    }
    
    @Test
    public void parhaatPisteet() {
        List<Player> parhaat = stats.topScorers(2);
        assertEquals(2, parhaat.size());
    }
    
    
}