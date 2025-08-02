package rooms;

import GameStory.GameStory;
import gameObjects.GameObject;
import gameObjects.Treasures;
import player.Player;

import java.util.Scanner;

public class TreasureRoom extends Room {
    public TreasureRoom() {
        super("tesoro");
    }

    private boolean tesoroRequiereLlave;
    private GameObject tesoro;

    @Override
    public void interaccionEnSala(Player player, Room room, GameStory gameStory) {
        super.interaccionEnSala(player, room, gameStory);
        player.ingresarASala(room, gameStory);

        Scanner teclado = new Scanner(System.in);
        boolean avanzar = false;
        while (avanzar == false) {
            gameStory.accionesJugadorEnSalaDelTosoro();
            Integer accion = accionJugador(teclado, gameStory);
            if (accion.equals(1)) {
                accionAbrirCofre(player, gameStory, teclado);
                avanzar = true;
            }
            if (accion.equals(2)) {
                gameStory.playerSaleDeSalaVacia(player, gameStory);
                avanzar = true;
            }
        }
        gameStory.enterContinuar();
    }

    private static Integer accionJugador(Scanner teclado, GameStory gameStory) {
        String accion = teclado.next();
        while (!accion.equals("1") || !accion.equals("2")) {
            if (accion.equals("1")) {
                accion = "1";
                break;
            }
            if (accion.equals("2")) {
                accion = "2";
                break;
            }
            gameStory.opcionIncorrecta();
            accion = teclado.next();
        }
        return Integer.valueOf(accion);
    }

    private void accionAbrirCofre(Player player, GameStory gameStory, Scanner teclado) {
        GameObject tesoro = Treasures.generarTesoro(gameStory.getIdioma());
        gameStory.jugadorEncuentraTesoro(player, gameStory, tesoro);
        player.getInventory().add(tesoro);
    }

}
