package gameObjects;

import GameStory.GameStory;
import player.Player;

public class GoldenKey extends GameObject {

    public GoldenKey(String nombre) {
        super(nombre, false);
    }

    @Override
    public void consumirObjeto(Player player, GameStory gameStory) {

    }

}
