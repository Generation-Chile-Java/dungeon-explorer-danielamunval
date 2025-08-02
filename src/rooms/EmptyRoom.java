package rooms;

import GameStory.GameStory;
import enemies.Enemie;
import player.Player;

import java.util.Scanner;

public class EmptyRoom extends Room {
    public EmptyRoom() {
        super("vacio");
    }
    @Override
    public void interaccionEnSala(Player player, Room room, GameStory gameStory) {
        super.interaccionEnSala(player, room, gameStory);
        player.ingresarASala(room, gameStory);

        Scanner teclado = new Scanner(System.in);

        boolean avanzar = false;
        while (avanzar == false) {
            gameStory.accionesJugadorEnSalaVacia();
            Integer accion = accionJugador(teclado, gameStory);
            if (accion.equals(1)) {
                accionInventario(player, gameStory, teclado);
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

    private void accionInventario(Player player, GameStory gameStory, Scanner teclado) {
        gameStory.eleccionDeObjeto(player, gameStory, teclado);
        gameStory.enterContinuar();
    }
}
