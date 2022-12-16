package per.football.players.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player player = getPlayer();
        assertEquals("testName", player.getName());
    }

    Player getPlayer(){
        Player player = new Player();
        player.setName("testName");
        return player;
    }
}