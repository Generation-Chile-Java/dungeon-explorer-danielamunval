package player;

import enemies.Enemy;
import gameObjects.GameObject;
import rooms.Room;
import gameStory.GameStory;

import java.util.List;

public class Player implements PlayerActions {

    private String nombreJugador;
    private String nivelDificultad;
    private List<Enemy> enemigosEnfrentados;
    private Integer vidasJugador;
    private List<GameObject> inventory;
    private Room salaActual;

    public Player() {
    }

    public List<Enemy> getEnemigosEnfrentados() {
        return enemigosEnfrentados;
    }

    public void setEnemigosEnfrentados(List<Enemy> enemigosEnfrentados) {
        this.enemigosEnfrentados = enemigosEnfrentados;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public Integer getVidasJugador() {
        return vidasJugador;
    }

    public void setVidasJugador(Integer vidasJugador) {
        this.vidasJugador = vidasJugador;
    }

    public Room getSalaActual() {
        return salaActual;
    }

    public void setSalaActual(Room salaActual) {
        this.salaActual = salaActual;
    }

    public List<GameObject> getInventory() {
        return inventory;
    }

    public void setInventory(List<GameObject> inventory) {
        this.inventory = inventory;
    }



    @Override
    public void usarObjeto(Player player, GameObject gameObject) {
    }

    @Override
    public void verInventario(Player player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            int n = i + 1;
            System.out.println(n +". "+ player.getInventory().get(i).getNombre());
        }
    }

    @Override
    public void verInfoPlayer(Player player) {

    }

    @Override
    public void atacarEnemigo(Player player, Enemy enemie, GameStory gameStory) {
        gameStory.playerAtaca(player, enemie, gameStory);
        enemie.setVidas(enemie.getVidas() - 1);
    }

    @Override
    public void ingresarASala(Room room, GameStory gameStory) {
        String sala = room.getTipoDeSala();
        gameStory.ingresarASala(room);
        setSalaActual(room);
    }

    @Override
    public String claseJugador(Player player, GameStory gameStory) {
        return "";
    }

    public String vidasEmojis(int vidas) {
        String corazones = "";
        for (int i = 0; i < vidas; i++) {
            corazones = corazones + "❤️";
        }
        return corazones;
    }
}
