package player;

import GameStory.GameStory;
import enemies.Enemie;

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
    public void atacarEnemigo(Player player, Enemie enemie, GameStory gameStory) {
        gameStory.playerAtaca(player, enemie, gameStory);
        enemie.setVidas(enemie.getVidas() - 1);
    }
}
