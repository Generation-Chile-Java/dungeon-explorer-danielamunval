package gameObjects;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Treasures extends GameObject{

    public Treasures(String nombre) {
        super(nombre, false);
    }

    public Treasures(String nombre, boolean usable) {
        super(nombre, usable);
    }

    public Treasures() {
    }

    private static final List<String> tesorosES = Arrays.asList(
            "Espada Llameante 🔥",
            "Amuleto de Sabiduría Ancestral 📿",
            "Corona del Rey Perdido 👑",
            "Anillo de Invisibilidad 💍",
            "Bolsa de Monedas de Oro 💰",
            "Pergamino de Magia Antigua 📜",
            "Botas del Viento Silencioso 👢",
            "Elixir de Vida Eterna 🧪",
            "Escudo de Luz Divina 🛡️",
            "Gema del Dragón 🪨",
            "Capa de Sombras 🧥",
            "Daga de la Noche 🌑",
            "Cetro del Archimago 🪄",
            "Llave de la Cripta Olvidada 🗝️",
            "Grimorio de Hechizos Prohibidos 📘"
    );

    private static final List<String> tesorosEN = Arrays.asList(
            "Flaming Sword 🔥",
            "Amulet of Ancient Wisdom 📿",
            "Crown of the Lost King 👑",
            "Ring of Invisibility 💍",
            "Bag of Gold Coins 💰",
            "Scroll of Ancient Magic 📜",
            "Boots of Silent Wind 👢",
            "Elixir of Eternal Life 🧪",
            "Shield of Divine Light 🛡️",
            "Dragon Gem 🪨",
            "Cloak of Shadows 🧥",
            "Dagger of the Night 🌑",
            "Archmage's Scepter 🪄",
            "Key of the Forgotten Crypt 🗝️",
            "Grimoire of Forbidden Spells 📘"
    );

    public static Treasures generarTesoro(String idioma) {
        Treasures tesoro = new Treasures();
        Random random = new Random();
        String nombre = "";
        if (idioma.equals("ES")) {
            nombre = tesorosES.get(random.nextInt(tesorosES.size()));
        }
        if (idioma.equals("EN")) {
            nombre = tesorosEN.get(random.nextInt(tesorosEN.size()));
        }
        tesoro.setNombre(nombre);
        tesoro.setUsable(false);
        return tesoro;
    }


}
