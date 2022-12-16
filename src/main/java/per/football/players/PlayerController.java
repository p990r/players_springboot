package per.football.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.football.players.Entity.Player;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(PlayerController.url)
public class PlayerController {
    public static final String url = "/api/players";

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public Iterable<Player> list() {
        return this.playerService.findAll();
    }

    @PostMapping
    public Player create(@Valid @RequestBody Player player) {
        return this.playerService.create(player);
    }

    @GetMapping("{id}")
    public Optional<Player> findById(@PathVariable Long id) {
        return this.playerService.findById(id);
    }

    @PutMapping("{id}")
    public Player updateById(@PathVariable Long id, @RequestBody Player source) {
        return this.playerService.updateById(id, source);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        this.playerService.deleteById(id);
    }

    @GetMapping("passers/{pass}")
    public List<Player> getPassers(@PathVariable int pass){
        return this.playerService.getPassers(pass);
    }
}

