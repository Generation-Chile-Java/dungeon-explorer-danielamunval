package player;

import gameStory.GameStory;
import enemies.Enemy;

public class Warrior extends Player {

    @Override
    public String claseJugador(Player player, GameStory gameStory) {
        String clase = "";
        if (gameStory.getIdioma().equals("ES")) {
            clase = "Guerrero 🛡️⚔️";
        }
        if (gameStory.getIdioma().equals("EN")) {
            clase = "Warrior 🛡️⚔️";
        }
        return clase;
    }

    @Override
    public void atacarEnemigo(Player player, Enemy enemie, GameStory gameStory) {
        gameStory.playerAtaca(player, enemie, gameStory);
        enemie.setVidas(enemie.getVidas() - 1);
    }
}
