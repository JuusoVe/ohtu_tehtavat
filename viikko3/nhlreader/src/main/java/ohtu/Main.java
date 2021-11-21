package ohtu;

import java.util.*;
import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        /*
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );
        */

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        ArrayList<Player> finnishPlayers = new ArrayList();
        for (int i = 0; i < players.length ; i++) {
            if ((players[i].getNationality()).equals("FIN")) {
                finnishPlayers.add(players[i]);
            }
        }
        
        Collections.sort(finnishPlayers);
        Collections.reverse(finnishPlayers);
        
        System.out.println("Oliot:");
        for (Player player : finnishPlayers) {
            System.out.println(player);
        }   
    }
  
}