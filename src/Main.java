import GameStory.GameStory;
import player.Player;
import rooms.EmptyRoom;
import rooms.EnemyRoom;
import rooms.Room;
import rooms.TreasureRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameStory gameStory = new GameStory();
        Scanner teclado = new Scanner(System.in);
        Player player = null;

        System.out.println("\n══════════════════════════════════════");
        System.out.println(("🏰⚜️        DUNGEON GAME         ⚜️🏰"));
        System.out.println("══════════════════════════════════════\n");
        System.out.println("Elige tu idioma => ES(español) / EN(inglés)");
        System.out.println("Choose your language => ES(spanish) / EN(english)");
        System.out.print("=> ");
        String idioma = teclado.next().toLowerCase();

        while (idioma != "es" || !idioma.equals("en")) {
            if (idioma.equals("es")) {
                gameStory.setIdioma("ES");
                break;
            }
            if (idioma.equals("en")) {
                gameStory.setIdioma("EN");
                break;
            }
            System.out.println("Idioma incorrecto, intenta nuevamente");
            System.out.println("Incorrect language, try again");
            System.out.print("=> ");
            idioma = teclado.next().toLowerCase();
        }

        gameStory.instrucciones();
        player = gameStory.crearJugador();
        gameStory.solicitaNombre();
        player.setNombreJugador(teclado.next());

        gameStory.saludo(player.getNombreJugador());
        player.setInventory(gameStory.elegirObjetoInicial());
        gameStory.enterContinuar();

        List<Room> salas = new Room().generarSalas(player.getNivelDificultad());
        for (int i = 0; i < salas.size(); i++){
            salas.get(i).interaccionEnSala(player, salas.get(i), gameStory);
            if (player.getVidasJugador() <= 0) {
                gameStory.gameOver();
                break;
            }
            System.out.println("***********************************************************************************************************");
        }

        if (player.getVidasJugador() <= 0) {
            gameStory.gameOver();
        } else {
            gameStory.resumenFinDelJuego(player, gameStory);
        }
    }
}