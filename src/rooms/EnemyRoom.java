package rooms;

import gameStory.GameStory;
import enemies.Enemy;
import player.Player;
import trivia.Trivia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EnemyRoom extends Room {
    public EnemyRoom() {
        super("enemigo");
    }

    @Override
    public void interaccionEnSala(Player player, Room room, GameStory gameStory) {
        super.interaccionEnSala(player, room, gameStory);
        player.ingresarASala(room, gameStory);

        Enemy enemie = Enemy.generarEnemigo(gameStory.getIdioma(), player.getNivelDificultad());
        gameStory.apareceEnemigo(enemie.getTipo());
        List<Enemy> enemigos = player.getEnemigosEnfrentados();
        if (enemigos == null || enemigos.isEmpty()) {
            enemigos = new ArrayList<>();
        }
        enemigos.add(enemie);
        player.setEnemigosEnfrentados(enemigos);

        Scanner teclado = new Scanner(System.in);
        gameStory.comienzaCombate(player, enemie);

        Integer rondasPerdidas = 0;


        for (int i = 1; i <= 3; i++) {
            gameStory.rondas(player, enemie, gameStory, i);

            boolean terminarRonda = false;
            while (terminarRonda == false) {
                gameStory.accionesJugadorEnSala();
                Integer accion = accionJugador(teclado, gameStory);
                if (accion.equals(1)) {
                    boolean resultadoRonda = accionAtacar(player, enemie, gameStory, teclado);
                    if (!resultadoRonda) {
                        rondasPerdidas = rondasPerdidas + 1;
                    }
                    terminarRonda = true;
                }

                if (accion.equals(2)) {
                    accionInventario(player, enemie, gameStory, teclado);
                }

                if (accion.equals(3)) {
                    accionSaltarTurno(player, enemie, gameStory, teclado);
                    rondasPerdidas = rondasPerdidas + 1;
                    terminarRonda = true;
                }

                if (rondasPerdidas.equals(3)) {
                    gameStory.player3RondasPerdidas(player, enemie);
                    player.setVidasJugador(0);
                    break;
                }

                if (rondasPerdidas == 3) {
                    gameStory.player3RondasPerdidas(player, enemie);
                    player.setVidasJugador(0);
                    return;
                }

                if (player.getVidasJugador() <= 0) {
                    break;
                }
            }

            if (player.getVidasJugador() <= 0) {
                break;
            }

            if (enemie.getVidas() <= 0) {
                gameStory.playerWin(player, gameStory);
            }

            gameStory.enterContinuar();
        }
        if (player.getVidasJugador() > 0) {
            gameStory.termina3RondasSinMorir(player, enemie, gameStory);
        }
        gameStory.enterContinuar();
    }

    private void accionSaltarTurno(Player player, Enemy enemie, GameStory gameStory, Scanner teclado) {
        gameStory.playerSaltaTurno(player, enemie, gameStory, teclado);
        player.setVidasJugador(player.getVidasJugador() - 1);
    }

    public static int lanzarDado() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    private static Integer accionJugador(Scanner teclado, GameStory gameStory) {
        String accion = teclado.next();
        while (!accion.equals("1") || !accion.equals("2") || !accion.equals("3")) {
            if (accion.equals("1")) {
                accion = "1";
                break;
            }
            if (accion.equals("2")) {
                accion = "2";
                break;
            }
            if (accion.equals("3")) {
                accion = "3";
                break;
            }
            gameStory.opcionIncorrecta();
            accion = teclado.next();
        }
        return Integer.valueOf(accion);
    }

    private boolean accionAtacar(Player player, Enemy enemie, GameStory gameStory, Scanner teclado) {

        Trivia trivia = Trivia.generarPregunta(gameStory.getIdioma());
        boolean resultadoRonda;
        
        gameStory.mostrarPregunata(trivia, gameStory);
        int respuesta = 0;

        while (true) {
            try {
                respuesta = teclado.nextInt();
                teclado.nextLine();

                if (respuesta == 0) {
                    return false;
                } else if (respuesta == 1 || respuesta == 2) {
                    break;
                } else {
                    gameStory.opcionIncorrecta();
                    gameStory.mostrarPregunata(trivia, gameStory);
                }

            } catch (Exception e) {
                teclado.nextLine();
                gameStory.opcionIncorrecta();
                gameStory.mostrarPregunata(trivia, gameStory);
            }
        }

        if (trivia.esCorrecta(respuesta)) {
            player.atacarEnemigo(player, enemie, gameStory);
            resultadoRonda = true;
        } else {
            gameStory.enemieAtaca(enemie, player);
            player.setVidasJugador(player.getVidasJugador() - 1);
            resultadoRonda = false;
        }

        return resultadoRonda;
    }

    private void accionInventario(Player player, Enemy enemie, GameStory gameStory, Scanner teclado) {
        gameStory.eleccionDeObjeto(player, gameStory, teclado);
        gameStory.enterContinuar();
    }

}
