package player;

import gameStory.GameStory;
import enemies.Enemy;

public class Hunter extends Player {

    @Override
    public String claseJugador(Player player, GameStory gameStory) {
        String clase = "";
        if (gameStory.getIdioma().equals("ES")) {
            clase = "Cazador 🏹";
        }
        if (gameStory.getIdioma().equals("EN")) {
            clase = "Hunter 🏹";
        }
        return clase;
    }

    @Override
    public void atacarEnemigo(Player player, Enemy enemie, GameStory gameStory) {
        gameStory.playerAtaca(player, enemie, gameStory);
        enemie.setVidas(enemie.getVidas() - 1);
    }
}
