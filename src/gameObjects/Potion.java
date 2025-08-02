package gameObjects;

import GameStory.GameStory;
import player.Player;

public class Potion extends GameObject {

    public Potion(String nombre) {
        super(nombre, true);
    }

    @Override
    public void consumirObjeto(Player player, GameStory gameStory) {
        gameStory.playerUsaPocion(player, gameStory);
        player.setVidasJugador(player.getVidasJugador() + 1);



    }
}
