package per.football.players;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import per.football.players.Entity.Player;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@TestMethodOrder(MethodOrderer.MethodName.class)
class PlayerControllerIntegrationTest {
    private static long currentId = -1;

    @Autowired
    private TestRestTemplate restTemplate; // sort of Postman

    @Test
    void test1CreateUsingPost() {
        Player player = new Player();

        ResponseEntity<Player> response  = this.restTemplate.postForEntity(PlayerController.url, player, Player.class);
        assertEquals(200, response.getStatusCodeValue());

        Player returnedPlayer = response.getBody();
        currentId = returnedPlayer.getId();
        assertNotEquals(0, currentId);
        assertNotNull(returnedPlayer);
    }

    @Test
    void test2Fetchit() {

        ResponseEntity<Player> response  = this.restTemplate.getForEntity(PlayerController.url+"/"+currentId, Player.class);
        assertNotNull(response.getBody());
        Player responsedPlayer = response.getBody();
        assertNotEquals(0, responsedPlayer.getAge());
    }


}
