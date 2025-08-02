package gameObjects;

import GameStory.GameStory;
import player.Player;

public class GameObject implements ObjectActions{

    private String nombre;
    private boolean usable;

    public GameObject(String nombre, boolean usable) {
        this.nombre = nombre;
        this.usable = usable;
    }

    public GameObject() {
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void consumirObjeto(Player player, GameStory gameStory) {

    }
}
