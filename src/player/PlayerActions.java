package player;

import gameStory.GameStory;
import enemies.Enemy;
import gameObjects.GameObject;
import rooms.Room;

public interface PlayerActions {
    void usarObjeto(Player player, GameObject gameObject);
    void verInventario(Player player);
    void verInfoPlayer(Player player);
    void atacarEnemigo(Player player, Enemy enemie, GameStory gameStory);
    void ingresarASala(Room room, GameStory gameStory);
    String claseJugador(Player player, GameStory gameStory);
}
