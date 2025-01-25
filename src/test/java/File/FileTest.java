package File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileTest {
    @Test
    void chercher_un_fichier() {
        File file = new File("C:/Projets/certification-java-17/src/test/java/File/file.txt");
        Assertions.assertFalse(file.exists());
    }

    @Test
    void peut_mettre_un_dossier_en_path_au_lieu_d_un_fichier() {
        File parent = new File("C:/Projets/certification-java-17/src/test/java/File");
        File file = new File(parent, "file.txt");
        Assertions.assertFalse(file.exists());
    }

    @Test
    void peut_creer_un_path() {
        Path path = Path.of("C:/Projets/certification-java-17/src/test/java/File/file.txt");
        Assertions.assertFalse(Files.exists(path));
    }

    @Test
    void peut_avoir_beaucoup_d_information_sur_le_fichier() {
        File file = new File("C:/Projets/certification-java-17/src/test/java/File/FileTest.java");
        Assertions.assertTrue(file.exists());
        System.out.println("Absolute path : " + file.getAbsolutePath());
        System.out.println("Est un répertoire : " + file.isDirectory());
        System.out.println("Son parent : " + file.getParent());
        if (file.isFile()) {
            System.out.println("Size : " + file.length());
            System.out.println("Dernière modif : " + file.lastModified());
        } else {
            List<File> subFiles = Arrays.stream(Objects.requireNonNull(file.listFiles())).toList();
            subFiles.forEach(subFile -> {
                System.out.println(subFile.getName());
            });
        }
    }

    @Test
    void peut_concatener_un_dossier_ou_fichier_a_un_path() {
        Path path = Path.of("C:/Projets/certification-java-17/src/test");
        Path pathToFileTest = path.resolve(Path.of("FileTest.java"));
        System.out.println("FILE : " + pathToFileTest);
    }
}
