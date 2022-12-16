package per.football.players;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.football.players.Entity.Player;
import per.football.players.Entity.Stats;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private Properties properties;

    public Iterable<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public Player create(Player player) {
        player.setNationality(properties.getNationality());
        player.setAge(properties.getRandomNumber(18, 45));
        Stats stats = new Stats();
        stats.setAttack(properties.getRandomNumber(0,100));
        stats.setDefence(properties.getRandomNumber(0,100));
        stats.setDribble(properties.getRandomNumber(0,100));
        stats.setPass(properties.getRandomNumber(0,100));
        stats.setSpeed(properties.getRandomNumber(0,100));
        stats.setStamina(properties.getRandomNumber(0,100));
        player.setStats(stats);
        player.setPosition(properties.findPosition(stats));
        return save(player);
    }

    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    public Player updateById(Long id, Player source) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if(optionalPlayer.isPresent()) {
            Player target = optionalPlayer.get();
            target.setName(source.getName());
            return this.save(target);
        }
        else {
            return null; // // oh oh, later we will learn to return Http status codes (404)
        }
    }

    public void deleteById(Long id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if(optionalPlayer.isPresent()) {
            playerRepository.deleteById(id);
        }
    }

    public List<Player> getPassers(int pass){
        return playerRepository.findPassers(pass);
    }
}

