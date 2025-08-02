package player;

import GameStory.GameStory;
import enemies.Enemie;
import gameObjects.GameObject;
import rooms.Room;

public interface PlayerActions {
    void usarObjeto(Player player, GameObject gameObject);
    void verInventario(Player player);
    void verInfoPlayer(Player player);
    void atacarEnemigo(Player player, Enemie enemie, GameStory gameStory);
    void ingresarASala(Room room, GameStory gameStory);
    String claseJugador(Player player, GameStory gameStory);
}
