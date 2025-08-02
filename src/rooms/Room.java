package rooms;

import gameStory.GameStory;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room implements RoomActions {
    private String tipoDeSala;

    public Room(String tipoDeSala) { //constructor
        this.tipoDeSala = tipoDeSala;
    }

    public Room() {
    }

    //getter y setter
    public String getTipoDeSala() {
        return tipoDeSala;
    }

    public void setTipoDeSala(String tipoDeSala) {
        this.tipoDeSala = tipoDeSala;
    }

    public String generarSala() {
        Random rand = new Random();
        int numero = rand.nextInt(3) + 1;
        String tipo = "";

        switch (numero) {
            case 1 -> tipo = "vacio";
            case 2 -> tipo = "tesoro";
            case 3 -> tipo = "enemigo";
        }
        return tipo;
    }

    public Room obtenerSala() {
        String tipo = generarSala();
        switch (tipo) {
            case "vacio":
                return new EmptyRoom();
            case "enemigo":
                return new EnemyRoom();
            case "tesoro":
                return new TreasureRoom();
        }
        return null;
    }

    public List<Room> generarSalas(String nivelDificultadJugador){
        Integer numeroDeSalas = 0;
        List<Room> salas = new ArrayList<>();

        if (nivelDificultadJugador.equals("facil")) {
            numeroDeSalas = 3;
        }
        if (nivelDificultadJugador.equals("normal")) {
            numeroDeSalas = 4;
        }
        if (nivelDificultadJugador.equals("dificil")) {
            numeroDeSalas = 5;
        }
        for (int i = 1; i <= numeroDeSalas; i++) {
            salas.add(obtenerSala());
        }
       // salas.add(obtenerSalaBoss());
        return salas;
    }

    private Room obtenerSalaBoss() {
        return null;
    }

    @Override
    public void interaccionEnSala(Player player, Room room, GameStory gameStory) {

    }
}
