import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Getter
public class Games {
    private Map<String, Game> games;

    public Games() {
        this.games = new HashMap<>();
    }

    public Game addGame(Game game){
        return this.games.put(game.getGameId(), game);
    }
}
