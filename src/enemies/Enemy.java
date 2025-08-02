package enemies;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Enemy {

    private String tipo;
    private int vidas;

    private static final List<String> enemigosES = Arrays.asList(
            "Goblin Rata de Caverna",
            "Murciélago Sombrío",
            "Esqueleto Polvoriento",
            "Slime Verde Chorreante",
            "Rata Mutante de Mazmorra",
            "Orco Rompehuesos",
            "Ladrón de la Cripta",
            "Zombi de Sangre Negra",
            "Espíritu de un Guerrero Caído",
            "Víbora de Túnel",
            "Señor de las Llamas",
            "Caballero de la Armadura Rota",
            "Dragón Escarlata Dormido",
            "Nigromante de las Sombras Eternas",
            "Golem de Piedra Rúnica"
    );

    private static final List<String> enemigosEN = Arrays.asList(
            "Cave Rat Goblin",
            "Shadow Bat",
            "Dusty Skeleton",
            "Oozing Green Slime",
            "Mutant Dungeon Rat",
            "Bonecrusher Orc",
            "Crypt Thief",
            "Blackblood Zombie",
            "Fallen Warrior Spirit",
            "Tunnel Viper",
            "Lord of Flames",
            "Broken Armor Knight",
            "Sleeping Scarlet Dragon",
            "Necromancer of Eternal Shadows",
            "Runestone Golem"
    );

    public Enemy(String tipo) {
        this.tipo = tipo;
    }

    public Enemy() {

    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public static Enemy generarEnemigo(String idioma, String dificultad) {
        Enemy enemie = new Enemy();
        Random random = new Random();
        String tipoSeleccionado = "";
        if (idioma.equals("ES")) {
            tipoSeleccionado = enemigosES.get(random.nextInt(enemigosES.size()));
        }
        if (idioma.equals("EN")) {
            tipoSeleccionado = enemigosEN.get(random.nextInt(enemigosEN.size()));
        }
        enemie.setTipo(tipoSeleccionado);
        enemie.setVidas(enemie.asignarVidas(dificultad));
        return enemie;
    }

    public Integer asignarVidas(String nivelDificultadJugador) {
        Integer vidas = 0;
        if (nivelDificultadJugador.equals("facil")) {
            vidas = 5;
        }
        if (nivelDificultadJugador.equals("normal")) {
            vidas = 7;
        }
        if (nivelDificultadJugador.equals("dificil")) {
            vidas = 10;
        }
        return vidas;
    }

    public String getTipo() {
        return tipo;
    }

    public String toString() {
        return "Enemigo: " + tipo;
    }

    public String vidasEmojis(int vidas) {
        String corazones = "";
        for (int i = 0; i < vidas; i++) {
            corazones = corazones + "❤️";
        }
        return corazones;
    }

}
