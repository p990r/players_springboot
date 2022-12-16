package per.football.players;

import per.football.players.Entity.Player;
import per.football.players.Entity.Position;
import per.football.players.Entity.Stats;

import java.util.ArrayList;
import java.util.List;

public class TestModels {
    public static Player getPlayer(){
        Player player;
        player = new Player();
        player.setName("testName");
        player.setAge(100);
        player.setNationality("Nationality");
        player.setPosition(Position.Goalkeeper);
        Stats stats = new Stats();
        stats.setPass(11);
        stats.setStamina(11);
        stats.setDribble(11);
        stats.setSpeed(11);
        stats.setAttack(11);
        stats.setDefence(11);
        player.setStats(stats);
        return player;
    }

    public static List<Player> getPlayers(){
        List<Player> players;
        players = new ArrayList<>();
        players.add(getPlayer());
        return players;
    }
}
