package gameStory;

import enemies.Enemy;
import gameObjects.GameObject;
import gameObjects.GoldenKey;
import gameObjects.Potion;
import player.Hunter;
import player.Player;
import player.Warrior;
import rooms.Room;
import trivia.Trivia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStory {
    private Scanner teclado = new Scanner(System.in);
    private String idioma = "";

    private String RED = "\u001B[31m";
    private String GREEN = "\u001B[32m";
    private String RESET = "\u001B[0m";

    public GameStory(String idioma) {
        this.idioma = idioma;
    }

    public GameStory() {
    }

    /**
     * Esta función asigna un valor a la variable idioma de la clase gameStory
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdioma() {
        return idioma;
    }

    /**
     * Esta función se encarga de imprimir un mensaje por consola en base al idioma seleccionado
     *
     * @param es se debe ingresar el texto a mostrar en español
     * @param en se debe ingresar el texto a mostrar en inglés
     */
    public void imprimirSegunIdioma(String es, String en) {
        if (this.idioma.equals("ES")) {
            System.out.println(es);
        }
        if (this.idioma.equals("EN")) {
            System.out.println(en);
        }
    }

    public void enterContinuar() {
        if (this.idioma.equals("ES")) {
            System.out.print("Presiona ENTER para continuar...");
        }
        if (this.idioma.equals("EN")) {
            System.out.print("Press ENTER to continue...");
        }

        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
    }

    public void opcionIncorrecta() {
        imprimirSegunIdioma("⚠️ Opción incorrecta. intenta nuevamente ⚠️",
                "⚠️ Incorrect option. Please try again ⚠️");
        System.out.print("=> ");
    }

    public void instrucciones() {
        imprimirSegunIdioma("\nBienvenido, aventurero. En este juego por consola vas a adentrarte en una mazmorra llena de misterios, criaturas y decisiones cruciales.", "\nWelcome, adventurer. This console game invites you to venture into a dungeon full of mysteries, creatures, and crucial decisions.");
        imprimirSegunIdioma("Deberás elegir un personaje, con habilidades únicas según su clase, y enfrentarte a los desafíos que pondrán a prueba tu ingenio y valentía.", "You must choose a character, with unique abilities according to their class, and face challenges that will test your wit and courage.");
    }

    public Player crearJugador() {
        imprimirSegunIdioma("\nElige tu clase: \n1. ⚔\uFE0F Guerrero – Fuerte y resistente. \n2. \uD83C\uDFF9 Cazador – Ágil y certero.",
                "\nChoose your class: \n1. ⚔\uFE0F Warrior – Strong and tough. \n2. \uD83C\uDFF9 Hunter – Agile and accurate.");
        System.out.print("=> ");
        String eleccion = teclado.next();
        Player player = asignarClase(eleccion);
        player.setNivelDificultad(asignarNivelDificultad());
        player.setVidasJugador(asignarVidas(player.getNivelDificultad()));
        return player;
    }

    public void solicitaNombre() {
        imprimirSegunIdioma("\nIngresa tu nombre, viajero: ", "\nInsert your name, traveler: ");
        System.out.print("=> ");
    }

    public void saludo(String nombreJugador) {
        imprimirSegunIdioma("\nSaludos, " + nombreJugador + ", el eco de tu nombre resuena por el pasillo principal de la mazmorra en la que has ingresado... \nObservas a un costado del pasillo una pequeña mesa con dos objetos, te acercas y consigues leer el mensaje en el pergamino: 'solo puedes elegir una, la otra desaparecerá, sé inteligente' ", "Greetings, " + nombreJugador + ", the echo of your name resonates through the main corridor of the dungeon you have entered... \nYou observe to one side of the corridor a small table with two objects, you approach and manage to read the message on the parchment: 'you can only choose one, the other will disappear, be smart'");
    }

    private Player asignarClase(String eleccion) {
        while (!eleccion.equals("1") || !eleccion.equals("2")) {
            if (eleccion.equals("1")) {
                imprimirSegunIdioma("Haz elegido la clase 'Guerrero ⚔️'. Que tu espada te guíe a la gloria.", "You have chosen the 'Warrior ⚔️' class. May your sword guide you to glory.");
                return new Warrior();
            }
            if (eleccion.equals("2")) {
                imprimirSegunIdioma("Has escogido la clase 'Cazador 🏹'. Que tu agilidad te acompañe en la travesía.", "You have chosen the 'Hunter \uD83C\uDFF9' class. May your agility accompany you on the journey.");
                return new Hunter();
            }
            imprimirSegunIdioma("Eleccion de clase incorrecta, intenta nuevamente: ",
                    "Incorrect class choice, please try again: ");
            System.out.print("=> ");
            eleccion = teclado.next();
        }
        return null; // return por defecto.
    }

    public Integer asignarVidas(String nivelDificultadJugador) {
        Integer vidas = 0;
        if (nivelDificultadJugador.equals("facil")) {
            vidas = 10;
        }
        if (nivelDificultadJugador.equals("normal")) {
            vidas = 7;
        }
        if (nivelDificultadJugador.equals("dificil")) {
            vidas = 5;
        }
        return vidas;
    }

    public String asignarNivelDificultad() {
        imprimirSegunIdioma("\nElige tu nivel de dificultad: \n1. Fácil 💚 / 2. Normal 💛 / 3. Difícil ❤️",
                "\nChoose your difficulty level: \n1. Easy 💚 / 2. Normal 💛 / 3. Hard ️❤️");
        System.out.print("=> ");
        String eleccionDeNivel = teclado.next();

        while (!eleccionDeNivel.equals("1") || !eleccionDeNivel.equals("2") || !eleccionDeNivel.equals("3")) {
            if (eleccionDeNivel.equals("1")) {
                imprimirSegunIdioma("\nHas escogido el nivel 'Fácil', inicias tu aventura con 10 puntos de vida ❤️.",
                        "\nYou have chosen 'Easy' level, you begin your adventure with 10 life points ️️❤️.");
                eleccionDeNivel = "facil";
                break;
            }
            if (eleccionDeNivel.equals("2")) {
                imprimirSegunIdioma("\nHas escogido el nivel 'Normal', inicias tu aventura con 7 puntos de vida ❤️.",
                        "\nYou have chosen 'Normal' level, you begin your adventure with 7 life points ️️❤️.");
                eleccionDeNivel = "normal";
                break;
            }
            if (eleccionDeNivel.equals("3")) {
                imprimirSegunIdioma("\nHas escogido el nivel 'Dificil', inicias tu aventura con 5 puntos de vida ❤️.", "\nYou have chosen 'Hard' level, you begin your adventure with 5 life points ❤️.");
                eleccionDeNivel = "dificil";
                break;
            }
            imprimirSegunIdioma("Eleccion de nivel incorrecta, intenta nuevamente: ",
                    "Incorrect level choice, please try again: ");
            System.out.print("=> ");
            eleccionDeNivel = teclado.next();
        }
        return eleccionDeNivel;
    }

    public List<GameObject> elegirObjetoInicial() {
        List<GameObject> objetos = new ArrayList<>();

        String nombrePocion = "";
        String nombreLlave = "";
        if (idioma.equals("ES")) {
            nombrePocion = "Poción 🧪";
            nombreLlave = "Llave dorada 🔑";
        }
        if (idioma.equals("EN")) {
            nombrePocion = "Potion 🧪";
            nombreLlave = "Golden key 🔑";
        }

        imprimirSegunIdioma("\n¿Qué opción escoges?", "Which option do you choose?");
        imprimirSegunIdioma("1. Llave dorada 🔑 \n2. Poción 🧪", "1. Golden key 🔑 \n2. Potion 🧪");
        System.out.print("=> ");
        String eleccionDeObjeto = teclado.next();

        while (!eleccionDeObjeto.equals("1") || !eleccionDeObjeto.equals("2")) {
            if (eleccionDeObjeto.equals("1")) {
                imprimirSegunIdioma(
                        "\nHas escogido la llave dorada 🗝️, observas como la poción 🧪 se desvanece. \nLa llave dorada ha sido agregada a tu inventario.",
                        "\nYou chose the golden key 🗝️, and you see the potion 🧪 go away. \nThe golden key has been added to your inventory.");
                objetos.add(new GoldenKey(nombreLlave));
                break;
            }
            if (eleccionDeObjeto.equals("2")) {
                imprimirSegunIdioma(
                        "\nHas escogido la poción 🧪, observas como la llave dorada 🗝️ se desvanece. \nLa poción ha sido agregada a tu inventario.",
                        "\nYou chose the potion 🧪, and you see the golden key 🗝️ go away. \nThe potion has been added to your inventory.");

                objetos.add(new Potion(nombrePocion));
                break;
            }
            imprimirSegunIdioma("Eleccion de objeto incorrecta, intenta nuevamente: ",
                    "Object election incorrect, try again please: ");
            System.out.print("=> ");
            eleccionDeObjeto = teclado.next();
        }

        return objetos;
    }

    public void ingresarASala(Room room) {
        if (room.getTipoDeSala().equals("vacio")) {
            imprimirSegunIdioma("\nEntras con sigilo a la sala, pero la sala está cubierta de polvo, silenciosa y vacía... \nParece que nadie ha estado aquí en siglos. ⛓️", "\nYou enter the room stealthily, but the room is covered in dust, silent and empty... \nIt seems that no one has been here for centuries. ⛓️");
        }
        if (room.getTipoDeSala().equals("enemigo")) {
            imprimirSegunIdioma("\nHas entrado en una sala oscura y húmeda... Una figura emerge desde un rincón...", "\nYou have entered a dark and damp room... A figure emerges from a corner...");
        }
        if (room.getTipoDeSala().equals("tesoro")) {
            imprimirSegunIdioma("\n \uD83C\uDF81 Has entrado en una sala decorada con runas antiguas. \nEn el centro, yace un cofre rodeado de una energía vibrante...\n", "\n \uD83C\uDF81 You have entered a room decorated with ancient runes. \nIn the center, there is a chest surrounded by vibrant energy...");
        }
    }

    public void apareceEnemigo(String enemigo) {
        imprimirSegunIdioma(
                "\n¡Un " + enemigo + " aparece!",
                "\nAn " + enemigo + " appears!");
    }

    public void accionesJugadorEnSala() {
        imprimirSegunIdioma("¿Qué deseas hacer?", "What do you want to do?");
        imprimirSegunIdioma("1. Atacar 🗡️ / 2. Usar inventario 🧳 / 3. Saltar turno, perderas una vida 💔",
                "1. Attack 🗡 / 2. Use inventory 🧳 / 3. Skip turn, you will lose a life 💔");
        System.out.print("=> ");
    }

    public void accionesJugadorEnSalaVacia() {
        imprimirSegunIdioma("\n¿Qué deseas hacer?", "\nWhat do you want to do?");
        imprimirSegunIdioma("1. Usar inventario 🧳 / 2. Avanzar 🚶🏻‍♂️",
                "1. Use inventory 🧳 / 2. Move forward 🚶🏻‍♂️");
        System.out.print("=> ");
    }

    public void comienzaCombate(Player player, Enemy enemie) {
        imprimirSegunIdioma("¡Comienza el combate entre " + player.getNombreJugador() + " y " + enemie.getTipo() + "!",
                "The fight between" + player.getNombreJugador() + " and " + enemie.getTipo() + " begins");
        enterContinuar();
    }

    public void rondas(Player player, Enemy enemie, GameStory gameStory, int ronda) {
        System.out.println("\n══════════════════════════════════════");
        imprimirSegunIdioma("      ⚔️  RONDA " + ronda + " / 3  ⚔️", "      ⚔️  ROUND " + ronda + " / 3  ⚔️");
        System.out.println("══════════════════════════════════════\n");
        System.out.println("👤 " + player.getNombreJugador() + " " + player.claseJugador(player, gameStory) + " " + player.vidasEmojis(player.getVidasJugador()));
        System.out.println("💀 " + enemie.getTipo() + " " + enemie.vidasEmojis(enemie.getVidas()));
    }

    public void mostrarPregunata(Trivia trivia, GameStory gameStory) {

        System.out.println(trivia.getPregunta());
        System.out.println("1. " + trivia.getOpcion1());
        System.out.println("2. " + trivia.getOpcion2());
        if (gameStory.getIdioma().equals("ES")) {
            System.out.print("Ingresa tu respuesta => ");
        }

        if (gameStory.getIdioma().equals("EN")) {
            System.out.print("Enter your answer => ");
        }
    }

    public void gameOver() {
        imprimirSegunIdioma("GAME OVER 💔☠️", "GAME OVER 💔☠️");
    }

    public void playerWin(Player player, GameStory gameStory) {
        imprimirSegunIdioma(
                player.getNombreJugador() + " " + player.claseJugador(player, gameStory) + " gana el combate",
                player.getNombreJugador() + " " + player.claseJugador(player, gameStory) + "wins the battle");
    }

    public void player3RondasPerdidas(Player player, Enemy enemie) {
        String ES = "Sientes que después de esa última ronda la confusión es mayor 💭, y el cansancio se vuelve mayor... \nLa mazmorra consume toda tu energia y con ello todas tus vidas... 💔💀";
        String EN = "You feel that after that last round, the confusion is greater 💭, and the exhaustion grows stronger...\nThe dungeon drains all your energy, and with it, all your lives... 💔💀";
        imprimirSegunIdioma(ES, EN);
    }

    public void playerAtaca(Player player, Enemy enemie, GameStory gameStory) {
        String ES = "";
        String EN = "";

        if (player.claseJugador(player, gameStory).contains("Guerrero") ||
                player.claseJugador(player, gameStory).contains("Warrior")) {
            ES = GREEN + "✅ ¡Respuesta correcta!\n" + player.getNombreJugador() + " " + player.claseJugador(player, gameStory) + " " + player.claseJugador(player, gameStory)
                    + " usa su espada y ataca a "
                    + enemie.getTipo() + ", pierde una vida 💔" + RESET;
            EN = GREEN + "✅ ¡Correct answer!\n" + player.getNombreJugador() + " " + player.claseJugador(player, gameStory)
                    + " uses their sword and attacks "
                    + enemie.getTipo() + ", loses one life 💔" + RESET;
        }

        if (player.claseJugador(player, gameStory).contains("Cazador") ||
                player.claseJugador(player, gameStory).contains("Hunter")) {
            ES = GREEN + "✅ ¡Respuesta correcta!\n" + player.getNombreJugador() + " " + player.claseJugador(player, gameStory)
                    + " usa su arco y ataca a "
                    + enemie.getTipo() + ", pierde una vida 💔" + RESET;
            EN = GREEN + "✅ ¡Correct answer!\n" + player.getNombreJugador()
                    + " uses their arch and attacks "
                    + enemie.getTipo() + ", loses one life 💔" + RESET;
        }
        imprimirSegunIdioma(ES, EN);
    }

    public void enemieAtaca(Enemy enemie, Player player) {
        imprimirSegunIdioma(RED + "¡Has fallado! " + enemie.getTipo() + " ataca y pierdes una vida 💔" + RESET,
                RED + "You failed! " + enemie.getTipo() + " 💀 attacks and you lose a life 💔" + RESET);
    }

    public void playerSaltaTurno(Player player, Enemy enemie, GameStory gameStory, Scanner teclado) {
        String ES = RED + player.getNombreJugador() + " " + player.claseJugador(player, gameStory) + " parece confundido 😵‍💫 " +
                enemie.getTipo() + " 💀 aprovecha la distracción y ataca, pierdes una vida! 💔" + RESET;
        String EN = RED + player.getNombreJugador() + " " + player.claseJugador(player, gameStory) + " looks confused 😵‍💫 " +
                enemie.getTipo() + " 💀 takes advantage of the distraction and attacks, you lose a life! 💔" + RESET;
        imprimirSegunIdioma(ES, EN);
    }

    public void termina3RondasSinMorir(Player player, Enemy enemie, GameStory gameStory) {
        String nombrePlayer = player.getNombreJugador() + " " + player.claseJugador(player, gameStory);
        String ES = nombrePlayer + " logras distraer a " + enemie.getTipo() + ", abandonas la sala con sigilo y te adentras en la siguiente.";
        String EN = nombrePlayer + " manages to distract " + enemie.getTipo() + ", you quietly leave the room and head into the next one.";
        imprimirSegunIdioma(ES, EN);
    }

    //todo: terminar EN
    public void playerUsaPocion(Player player, GameStory gameStory) {
        String nombrePlayer = player.getNombreJugador() + " " + player.claseJugador(player, gameStory);
        String ES = nombrePlayer + " utilizas la poción de tu inventario, recuperas una vida ❤️";
        String EN = nombrePlayer + " uses the potion from your inventory, you recover one life ❤️";
        imprimirSegunIdioma(ES, EN);
    }

    public void eleccionDeObjeto(Player player, GameStory gameStory, Scanner teclado) {
        String ES = "0. Salir \n¿Qué objeto usarás?";
        String EN = "0. Exit \nWhich item will you use?";
        System.out.print("=> ");

        if (player.getInventory().isEmpty()) {
            imprimirSegunIdioma("Inventario vacio 😖","Empty inventory 😖");
        } else {
            boolean terminarEleccion = false;
            while (!terminarEleccion) {
                player.verInventario(player);
                imprimirSegunIdioma(ES, EN);

                try {
                    int opcion = teclado.nextInt();
                    teclado.nextLine();

                    if (opcion == 0) {
                        terminarEleccion = true;
                    } else if (opcion > 0 && opcion <= player.getInventory().size()) {
                        GameObject object = player.getInventory().get(opcion - 1);
                        if (object.isUsable() == true) {
                            object.consumirObjeto(player,gameStory);
                            player.getInventory().remove(player.getInventory().get(opcion - 1));
                        } else {
                            imprimirSegunIdioma("Usar este objeto no causará ningún efecto.","Using this item will have no effect.");
                        }
                        terminarEleccion = true;
                    } else {
                        opcionIncorrecta();
                    }

                } catch (Exception e) {
                    teclado.nextLine();
                    opcionIncorrecta();
                }
            }
        }
    }

    public void playerSaleDeSalaVacia(Player player, GameStory gameStory) {
        String nombrePlayer = player.getNombreJugador() + " " + player.claseJugador(player, gameStory);
        String ES = "\n" + nombrePlayer+ " buscas seguir con la aventura y continuas a la siguiente sala. 👣";
        String EN = "\n" + nombrePlayer + "you choose to continue the adventure and proceed to the next room. 👣";

        imprimirSegunIdioma(ES, EN);
    }

    public void accionesJugadorEnSalaDelTosoro() {
        imprimirSegunIdioma("\n¿Qué deseas hacer?", "\nWhat do you want to do?");
        imprimirSegunIdioma("1. Ver que hay dentro 👀 / 2. Pasar 🚶🏻‍♂️",
                "1. See what's inside 👀 / 2. Move on 🚶🏻‍♂️");
        System.out.print("=> ");
    }

    public void jugadorEncuentraTesoro(Player player, GameStory gameStory, GameObject tesoro) {
        String nombrePlayer = player.getNombreJugador() + " " + player.claseJugador(player, gameStory);

        String ES = "🪙 " + nombrePlayer + " abre un antiguo cofre cubierto de polvo... ¡Dentro encuentra *" + tesoro.getNombre() + "*! ✨\n"
                + "📦 El objeto ha sido guardado en tu inventario.";
        String EN = "🪙 " + nombrePlayer + " opens an ancient dust-covered chest... Inside lies *" + tesoro.getNombre() + "*! ✨\n"
                + "📦 The item has been added to your inventory.";
        imprimirSegunIdioma(ES, EN);
    }

    public void resumenFinDelJuego(Player player, GameStory gameStory) {
        String nombrePlayer = player.getNombreJugador() + " " + player.claseJugador(player, gameStory);
        String ES = "";
        String EN = "";

        List<GameObject> objetos = player.getInventory() != null ? player.getInventory() : new ArrayList<>();
        List<Enemy> enemigos = player.getEnemigosEnfrentados() != null ? player.getEnemigosEnfrentados() : new ArrayList<>();

        ES = "\n🎉 ¡" + nombrePlayer + " ha logrado sobrevivir a los horrores de la mazmorra y has salido con vida! 🗡️🏰";
        EN = "\n🎉 " + nombrePlayer + " has survived the horrors of the dungeon and escaped alive! 🗡️🏰";
        imprimirSegunIdioma(ES, EN);

        ES = "👾 Te has enfrentado a " + enemigos.size() + " enemigos durante tu travesía:";
        EN = "👾 You faced " + enemigos.size() + " enemies during your journey:";
        imprimirSegunIdioma(ES, EN);

        if (!enemigos.isEmpty()) {
            int x = 1;
            for (Enemy enemie : enemigos) {
                System.out.println("   " + x + ". " + enemie.getTipo());
                x++;
            }
        }

        ES = "🎒 Has recolectado " + objetos.size() + " objetos mágicos y tesoros:";
        EN = "🎒 You collected " + objetos.size() + " magical items and treasures:";
        imprimirSegunIdioma(ES, EN);

        if (!objetos.isEmpty()) {
            int z = 1;
            for (GameObject objeto : objetos) {
                System.out.println("   " + z + ". " + objeto.getNombre());
                z++;
            }
        }

        ES = "🏆 ¡Gloria y fortuna te esperan más allá de las sombras de la mazmorra!";
        EN = "🏆 Glory and fortune await you beyond the shadows of the Dungeon!";
        imprimirSegunIdioma(ES, EN);
    }
}

