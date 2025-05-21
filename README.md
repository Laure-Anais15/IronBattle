
# IronBattle

## Índice
- [Descripción](#descripción)
- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Contenido del Proyecto](#contenido-del-proyecto)
- [¿Qué ocurre durante el combate?](#qué-ocurre-durante-el-combate)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Licencia](#licencia)
- [Autores](#autor)

## Descripción
**IronBattle** es un simulador de combate **RPG por turnos** escrito en Java. El programa enfrenta a dos personajes –un **Guerrero** y un **Mago** por defecto– y muestra en consola el desarrollo del duelo hasta que uno resulte vencedor o se produzca un empate (en cuyo caso el combate se reinicia automáticamente).

## Características
- Personajes con atributos aleatorios dentro de rangos configurables (HP, fuerza, maná, etc.).
- Sistema de turnos: cada personaje ataca una vez por ronda.
- Reinicio automático de la batalla en caso de empate.

## Tecnologías Utilizadas
- **Lenguaje:** Java
- **Entorno de desarrollo:** IntelliJ
- **Conceptos de POO aplicados:**
  - Clases abstractas
  - Interfaces
  - Herencia y polimorfismo
  - Generación aleatoria

## Requisitos
- JDK 17+ correctamente instalado (variable de entorno `JAVA_HOME` configurada).
- Sistema operativo capaz de ejecutar `javac` y `java` (Windows, macOS o Linux).

## Instalación
```bash
# Clona el repositorio
git clone https://github.com/Laure-Anais15/IronBattle.git
cd IronBattle

# Compila los fuentes en la carpeta out/
javac -d out src/rpg/*.java

# Ejecuta el simulador
java -cp out rpg.Main
```
## Uso
Al ejecutar el programa verás en consola algo similar a:

```
*** LET THE BATTLE BEGIN! ***

-- Round 1 --
Aragorn golpea a Gandalf por 17 de daño
Gandalf lanza Bola de Fuego sobre Aragorn por 21 de daño
Status: Aragorn (HP 150) | Gandalf (HP 79)

...

WINNER: Gandalf!
```

### Menú principal

Al iniciar el programa verás un menú como este:

```
💥🔥 IRON BATTLE 🔥💥

1) Quick battle (Warrior vs Wizard)
2) Fully random battle
3) Custom battle (You decide)
Choose an option (1-3):
```

## Contenido del Proyecto
| Archivo                | Descripción                                                                                                    |
|------------------------|----------------------------------------------------------------------------------------------------------------|
| `Main.java`            | Punto de entrada del programa. Muestra el menú, lee opciones y lanza batallas.                                |
| `Character.java`       | Clase abstracta base. Define nombre, stats, métodos comunes.                                                   |
| `Warrior.java`         | Subclase de `Character`. Implementa ataques físicos con fuerza y stamina.                                      |
| `Wizard.java`          | Subclase de `Character`. Usa maná para lanzar hechizos.                                                        |
| `Battle.java`          | Contiene la lógica de combate por turnos entre dos personajes.                                                 |
| `Attacker.java`        | Interfaz que asegura que cada personaje implemente el método `attack()`.                                       |
| `CharacterLoader.java` | Clase que carga personajes desde un archivo CSV (`characters.csv`) ubicado en `resources/`.                    |
| `characters.csv`       | Archivo de entrada con lista de personajes (nombre + clase).                                                   |

### Quick battle (Warrior vs Wizard)

Lanza una batalla instantánea entre dos personajes predefinidos:

- **Aragorn** como `Warrior` y **Gandalf** como `Wizard`.
- No requiere entrada por parte del usuario.
- Ambos personajes tienen nombres fijos y estadísticas generadas automáticamente.
- El combate se ejecuta y muestra directamente en consola.

### Fully random battle (desde CSV)

Selecciona dos personajes al azar desde un archivo externo (`characters.csv`):

- El archivo debe contener una lista de personajes con su `nombre` y `tipo` (`warrior` o `wizard`).
- Se eligen aleatoriamente dos personajes distintos del listado.
- Sus estadísticas se generan de forma dinámica al instanciarse.
- El combate se lanza directamente tras la carga.

### Simulated random battle (autogenerado)

Genera automáticamente dos personajes aleatorios sin depender del archivo CSV ni intervención del usuario.

- Nombres aleatorios predefinidos (ej. “Thorg”, “Lira”).
- Clases aleatorias (`Wizard` o `Warrior`).
- Estadísticas como ataque generadas aleatoriamente dentro de un rango.
- Se muestra el resultado del combate en consola directamente.

## ¿Qué ocurre durante el combate?
1. **Cada ronda, ambos personajes atacan.**
2. **El Guerrero** puede realizar **ataques fuertes o débiles** dependiendo de su stamina.
3. **El Mago** lanza **bolas de fuego** o **golpes de bastón**, según su maná.
4. **Empate:** si ambos mueren en la misma ronda, el combate se reinicia automáticamente con estadísticas nuevas.
5. **Fin del juego:** el programa termina cuando uno de los personajes gana definitivamente.

 ℹ️ En el modo aleatorio (opción 2), los enfrentamientos pueden darse entre **cualquier combinación de clases**:
 - `Warrior` vs `Wizard`
 - `Warrior` vs `Warrior`
 - `Wizard` vs `Wizard`


## Estructura del proyecto
```
└── src/
    ├── main/
    │   ├── java/
    │   │   └── rpg/
    │   │       ├── Main.java
    │   │       ├── Battle.java
    │   │       ├── Character.java
    │   │       ├── Warrior.java
    │   │       ├── Wizard.java
    │   │       ├── Attacker.java
    │   │       └── CharacterLoader.java
    │   └── resources/
    │       └── characters.csv
```

## Licencia
Este proyecto está licenciado bajo los términos de la [licencia MIT](LICENSE).  
Si no existe el fichero `LICENSE`, se asume licencia MIT; puedes sustituirla por la que prefieras.

## Autor
Desarrollado por [Laure-Anais15](https://github.com/Laure-Anais15) & [LlucMH](https://github.com/Laure-Anais15)
como ejercicio de programación.
