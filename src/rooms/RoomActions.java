package rooms;

import gameStory.GameStory;
import player.Player;

public interface RoomActions {
    void interaccionEnSala(Player player, Room room, GameStory gameStory);
}
