package per.football.players;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import per.football.players.Entity.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(value = "select * from player where pass > ?1", nativeQuery = true)
    List<Player> findPassers(int pass);
}
