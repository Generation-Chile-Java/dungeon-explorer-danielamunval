package trivia;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Trivia {
    private String pregunta;
    private String opcion1;
    private String opcion2;
    private int respuestaCorrecta; // 1 o 2

    public Trivia(String pregunta, String opcion1, String opcion2, int respuestaCorrecta) {
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Trivia() {
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    private static List<Trivia> preguntasES = Arrays.asList(
            new Trivia("¿Un perro puede volar? 🐶🪽", "Sí ✅", "No ❌", 2),
            new Trivia("¿El sol es una estrella? ☀️⭐", "Sí ✨", "No 🌑", 1),
            new Trivia("¿Los peces duermen? 🐟💤", "Sí 🛌", "No 🚫", 1),
            new Trivia("¿Un humano puede respirar bajo el agua sin equipo? 🧍‍♂️🌊", "Sí 🫧", "No 🫁", 2),
            new Trivia("¿2 + 2 es igual a 4? ➕🧮", "Sí 🧠", "No ❓", 1),
            new Trivia("¿Las plantas hacen fotosíntesis? 🌿☀️", "Sí 🌱", "No 🌚", 1),
            new Trivia("¿La luna es más grande que la Tierra? 🌕🌍", "Sí 🪐", "No 🌀", 2),
            new Trivia("¿Puedes ver en la oscuridad total sin luz? 🌑👀", "Sí 🦉", "No 🚫", 2),
            new Trivia("¿Los gatos maúllan? 🐱🎶", "Sí 🐾", "No 🙀", 1),
            new Trivia("¿Puedes comerte una sopa con tenedor? 🍲🍴", "Sí 🤷", "No 🥄", 2)
    );


    private static List<Trivia> preguntasEN = Arrays.asList(
            new Trivia("Can a dog fly? 🐶🪽", "Yes ✅", "No ❌", 2),
            new Trivia("Is the sun a star? ☀️⭐", "Yes ✨", "No 🌑", 1),
            new Trivia("Do fish sleep? 🐟💤", "Yes 🛌", "No 🚫", 1),
            new Trivia("Can a human breathe underwater without equipment? 🧍‍♂️🌊", "Yes 🫧", "No 🫁", 2),
            new Trivia("Is 2 + 2 equal to 4? ➕🧮", "Yes 🧠", "No ❓", 1),
            new Trivia("Do plants perform photosynthesis? 🌿☀️", "Yes 🌱", "No 🌚", 1),
            new Trivia("Is the moon bigger than Earth? 🌕🌍", "Yes 🪐", "No 🌀", 2),
            new Trivia("Can you see in total darkness without light? 🌑👀", "Yes 🦉", "No 🚫", 2),
            new Trivia("Do cats meow? 🐱🎶", "Yes 🐾", "No 🙀", 1),
            new Trivia("Can you eat soup with a fork? 🍲🍴", "Yes 🤷", "No 🥄", 2)
    );


    public static Trivia generarPregunta(String idioma) {
        Trivia trivia = new Trivia();
        Random random = new Random();
        if (idioma.equals("ES")) {
            trivia = preguntasES.get(random.nextInt(preguntasES.size()));
        }
        if (idioma.equals("EN")) {
            trivia = preguntasEN.get(random.nextInt(preguntasEN.size()));
        }
        return trivia;
    }

    public boolean esCorrecta(int respuestaJugador) {
        return respuestaJugador == respuestaCorrecta;
    }
}
