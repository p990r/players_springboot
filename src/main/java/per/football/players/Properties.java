package per.football.players;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import per.football.players.Entity.Position;
import per.football.players.Entity.Stats;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class Properties {
    private Random rand = new Random(); //instance of random class
    private RestTemplate restTemplate = new RestTemplate();
    static final String countriesApi = "https://restcountries.com/v2/all";

    public int getRandomNumber(int lowerbound, int upperbound) {
        return rand.nextInt(lowerbound, upperbound);
    }

    public Position findPosition(Stats stats) {
        if (stats.getAttack() > (stats.getDefence() * 2)) {
            return Position.Striker;
        }
        if (stats.getDefence() > (stats.getAttack() * 2)) {
            if (stats.getDribble() + stats.getStamina() < stats.getSpeed()) {
                return Position.Goalkeeper;
            } else {
                return Position.Defender;
            }
        }
        if (stats.getDribble() + stats.getStamina() > (stats.getPass() * 2)) {
            return Position.Winger;
        }
        return Position.Midfielder;
    }

    public ResponseEntity<List> getRestApi(String api) {
        try {
            return this.restTemplate
                    .getForEntity(new URI(api), List.class);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public String getNationality() throws NullPointerException{
        List<JSONObject> countries = getRestApi(countriesApi).getBody();
        try {
            Map<String, Object> country = (Map<String, Object>) countries.get(getRandomNumber(0, countries.size()));
            return country.get("demonym").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "American";
    }
}
