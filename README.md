
**Objetivo del Ejercicio**

Desarrollar un juego de exploración de mazmorras en Java que utilice los cuatro pilares de la programación orientada a objetos: encapsulación, herencia, polimorfismo y abstracción. El juego debe incluir clases, interfaces y la interacción entre diferentes tipos de objetos en la mazmorra.


**Descripción del Juego**

El jugador debe explorar una mazmorra compuesta de diferentes tipos de salas. Cada sala puede estar vacía, contener un tesoro o albergar un enemigo. El jugador debe navegar por estas salas, recoger objetos y enfrentarse a enemigos, todo mientras intenta mantenerse con vida.


**Reglas del Juego**

1- El jugador comienza con un nombre y una cantidad inicial de puntos de vida.

2- El jugador puede moverse a través de varias salas en la mazmorra.

3- Las salas pueden ser de tres tipos: vacía, con tesoro o con enemigo.

4- El jugador puede recoger tesoros que se añaden a su inventario.

5- El jugador puede recibir daño de los enemigos y perder puntos de vida.

6- El juego termina cuando el jugador ha explorado todas las salas o ha perdido todos sus puntos de vida.



**Requisitos Técnicos**

1- Interfaces y Abstracción: Define interfaces para las salas y los objetos interactuables en el juego.

2- Encapsulación: Utiliza atributos privados y métodos públicos para manejar el estado del jugador y de las salas.

3- Herencia: Crea clases concretas que implementen las interfaces definidas para representar diferentes tipos de salas.

4- Polimorfismo: Usa referencias de las interfaces para manejar los diferentes tipos de salas y objetos en el juego.



**Especificaciones Detalladas**

Paso 1: Crear las interfaces básicas
  - Define una interfaz Room para representar una sala en la mazmorra.
  - Define una interfaz gameObjects.gameObjects para representar objetos interactuables en la mazmorra.

Paso 2: Crear la clase Player
  - Define una clase Player que encapsule los datos y comportamientos del jugador.
  - La clase debe incluir atributos como name, health, e inventory.
  - Proporciona métodos para que el jugador pueda recibir daño, recoger objetos y mostrar su estado actual.

Paso 3: Crear clases concretas de Room
  - Crea una clase EmptyRoom que represente una sala vacía.
  - Crea una clase TreasureRoom que represente una sala con un tesoro.
  - Crea una clase EnemyRoom que represente una sala con un enemigo.

Paso 4: Crear la clase principal del juego
  - Define una clase principal que inicialice el jugador y una serie de salas.
  - Implementa un bucle que permita al jugador moverse por las salas.
  - Maneja las interacciones del jugador con las salas y los objetos.

**Instrucciones Adicionales**
  - Asegúrate de manejar adecuadamente las interacciones entre el jugador y los diferentes tipos de salas.
  - Considera agregar más salas y enemigos para hacer el juego más interesante.
  - Puedes implementar características adicionales como la posibilidad de que el jugador use objetos del inventario.


---

# 🏰 Dungeon Game ⚜️

¡Bienvenid@ a *Dungeon Game*!  
Un juego por consola en Java donde te adentras en una mazmorra llena de misterios, criaturas y decisiones cruciales.

## 🎮 Descripción

En este juego recorrerás una serie de salas dentro de una antigua mazmorra.  
Tu misión: llegar al final y obtener el gran tesoro escondido.

Antes de comenzar, deberás elegir a tu personaje. Cada clase tiene habilidades únicas que influirán en cómo enfrentas los desafíos que se presenten: batallas contra enemigos, acertijos que ponen a prueba tu ingenio, y la posibilidad de encontrar tesoros que podrás guardar en tu inventario.

## ⚙️ Características principales

- Sistema de selección de personaje (con clases y atributos únicos).
- Exploración de salas con eventos aleatorios.
- Combates contra enemigos con arte de emojis.
- Preguntas y acertijos cortos que permiten continuar o desvían tu camino.
- Sistema de inventario con objetos y tesoros recolectados.
- Final con recompensa si completas el recorrido.

## 🛠️ Tecnologías usadas

- **Lenguaje:** Java 21
- **Tipo de aplicación:** Consola
- **Paradigma:** Programación Orientada a Objetos (POO)
- **IDE recomendado:** IntelliJ IDEA (o cualquier IDE que soporte proyectos Java)

## 🚀 Cómo ejecutar el juego

1. Clona este repositorio o descarga el proyecto.
2. Abre el proyecto en tu IDE de preferencia.
3. Asegúrate de tener configurado Java 21.
4. Ejecuta el archivo `Main.java` ubicado en el paquete principal.
5. Todo el juego se maneja desde la consola. Sigue las instrucciones que aparecen en pantalla.

## 📁 Estructura del proyecto
````
DungeonGame/
│
├── Main.java
├── enemies/
│   ├── Enemy
├── gameObjects
│   ├── GameObject
│   ├── GoldenKey
│   ├── ObjectActions 
│   ├── Potion
│   └── Treasures  
├── gameStory/
│   └── GameStory
├── player/
│   ├── Hunter
│   ├── Player
│   ├── PlayerActions 
│   └── Warrior  
├── rooms/
│   ├── EmptyRoom
│   ├── EnemyRoom
│   ├── Room
│   ├── RoomActions 
│   └── TreasureRoom  
├── Trivia/
│   └── Trivia

````

## ✨ Autoría

Este proyecto fue desarrollado de forma individual como parte de mi proceso de aprendizaje en Java y programación orientada a objetos. 
Mi inspiración fue basada en el juego Dungeons&Dragons, pero con mecánicas más simples.
Fue pensado como una forma creativa y práctica de aplicar conceptos fundamentales, mientras experimentaba con narrativas interactivas y mecánicas simples de juego.

---

*¡Gracias por jugar!*  
¿Podrás llegar al final y reclamar el tesoro? 👑