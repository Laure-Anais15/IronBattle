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
- [Roadmap](#roadmap)
- [Licencia](#licencia)
- [Autor](#autor)

## Descripción
**IronBattle** es un simulador de combate **RPG por turnos** escrito en Java. El programa enfrenta a dos personajes –un **Guerrero** y un **Mago** por defecto– y muestra en consola el desarrollo del duelo hasta que uno resulte vencedor o se produzca un empate (en cuyo caso el combate se reinicia automáticamente).

Su objetivo pedagógico es servir como práctica de Programación Orientada a Objetos en Java: herencia, clases abstractas, interfaces, composición y manejo de aleatoriedad.

## Características
- Personajes con atributos aleatorios dentro de rangos configurables (HP, fuerza, maná, etc.).
- Sistema de turnos: cada personaje ataca una vez por ronda.
- Reinicio automático de la batalla en caso de empate.
- Extensible: basta con añadir una nueva clase que implemente `Attacker` para crear arquetipos propios (Pícaro, Clérigo…).
- 100 % CLI, sin dependencias externas.

## Tecnologías Utilizadas
- **Lenguaje:** Java 17 o superior (se recomienda Temurin 17)
- **Entorno de desarrollo:** IntelliJ IDEA o cualquier editor/IDE compatible con proyectos Java (VS Code, Eclipse…)
- **Conceptos de POO aplicados:**
    - Clases abstractas
    - Interfaces
    - Herencia y polimorfismo
    - Generación aleatoria (`ThreadLocalRandom`, `Random`)

## Requisitos
- JDK 17+ correctamente instalado (variable de entorno `JAVA_HOME` configurada).
- Sistema operativo capaz de ejecutar `javac` y `java` (Windows, macOS o Linux).

## Instalación
```bash
# Clona el repositorio
git clone https://github.com/tu-usuario/IronBattle.git
cd IronBattle

# Compila los fuentes en la carpeta out/
javac -d out src/rpg/*.java

# Ejecuta el simulador
java -cp out rpg.Main
```
> **Tip:** Si lo prefieres, importa el proyecto en tu IDE favorito como proyecto Java simple.

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

### Personalización
Si quieres cambiar nombres o añadir nuevos arquetipos, edita `Main.java` o crea nuevas clases en `src/rpg`.

## Contenido del Proyecto
| Archivo        | Descripción                                                                                                    |
|----------------|----------------------------------------------------------------------------------------------------------------|
| `Main.java`    | Punto de entrada del programa. Lanza el combate entre el Guerrero y el Mago.                                   |
| `Character.java` | Clase abstracta que representa cualquier personaje con nombre, vida y estado.                                 |
| `Warrior.java` | Clase que extiende `Character` y representa a un guerrero con fuerza y stamina.                                |
| `Wizard.java`  | Clase que extiende `Character` y representa a un mago con inteligencia y maná.                                 |
| `Battle.java`  | Clase que gestiona las reglas del combate entre dos personajes.                                               |
| `Attacker.java`| Interfaz que obliga a cada personaje a implementar la acción de ataque.                                        |

## ¿Qué ocurre durante el combate?
1. **Cada ronda, ambos personajes atacan.**
2. **El Guerrero** puede realizar **ataques fuertes o débiles** dependiendo de su stamina.
3. **El Mago** lanza **bolas de fuego** o **golpes de bastón**, según su maná.
4. **Empate:** si ambos mueren en la misma ronda, el combate se reinicia automáticamente con estadísticas nuevas.
5. **Fin del juego:** el programa termina cuando uno de los personajes gana definitivamente.

## Estructura del proyecto
```
└── src/
    └── rpg/
        ├── Attacker.java      # Interface con método attack()
        ├── Character.java     # Clase abstracta base
        ├── Warrior.java       # Subclase Character
        ├── Wizard.java        # Subclase Character
        ├── Battle.java        # Lógica del combate
        └── Main.java          # Punto de entrada
```

## Roadmap
- Emparejamiento de múltiples personajes (batallas 2 v 2 o *n* v *n*).
- Soporte de objetos/equipo que modifiquen estadísticas.
- Motor de log en JSON/CSV.
- Interfaz gráfica Swing/JavaFX.

## Licencia
Este proyecto está licenciado bajo los términos de la [licencia MIT](LICENSE).  
Si no existe el fichero `LICENSE`, se asume licencia MIT; puedes sustituirla por la que prefieras.

## Autor
Desarrollado por [Laure-Anais15](https://github.com/Laure-Anais15) & [LlucMH](https://github.com/Laure-Anais15)
como ejercicio de programación.  
