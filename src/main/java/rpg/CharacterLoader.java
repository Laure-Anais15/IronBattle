package rpg;

import java.io.*;
import java.util.*;
import java.net.URL;

public class CharacterLoader {

    public static List<Character> loadCharactersFromCSV(String filename) {
        List<Character> characters = new ArrayList<>();
        try {
            URL resource = Main.class.getClassLoader().getResource("characters.csv");
            if (resource == null) {
                System.err.println("❌ Error: Archivo no encontrado: " + filename);
                return characters;
            }

            File file = new File(resource.getFile());
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue; // omitir encabezado2
                }

                String[] parts = line.split(",");
                if (parts.length != 2) continue;

                String name = parts[0].trim();
                String type = parts[1].trim().toLowerCase();

                Character c = switch (type) {
                    case "warrior" -> new Warrior(name);
                    case "wizard"  -> new Wizard(name);
                    default -> null;
                };

                if (c != null) characters.add(c);
            }

            br.close();
        } catch (Exception e) {
            System.err.println("❌ Error leyendo CSV: " + e.getMessage());
        }

        return characters;
    }
}
