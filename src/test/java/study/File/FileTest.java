package study.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Test
    void peut_utiliser_normalize_pour_eliminer_les_chemins_inutiles_dans_le_path() {
        Path path = Path.of("C:/Projets/certification-java-17/../../Java.txt");
        // TODO normalise sur sur C:/Java.txt car on fait deux dossiers puis deux retours arrières, ça ne sert à rien
        System.out.println(path.normalize());

        path = Path.of("../../Java.txt");
        // TODO ici les deux retours arrières ne peuvent pas être enlevé ce n'est pas inutile, on garde ../../Java.txt comme chemin relatif
        System.out.println(path.normalize());
    }

    @Test
    void peut_utiliser_toRealPath_pour_verifier_si_c_est_bien_un_chemin_reel() throws IOException {
        Path path = Path.of("C:/Projets/certification-java-17/src/test");
        System.out.println(path.toRealPath());

        // TODO renvoie le chemin absolu quand c'est trouvé. toRealPath ne renvoie pas de chemin relatif
        path = Path.of("src/test/java/File/FileTest.java");
        System.out.println(path.toRealPath());
    }

    @Test
    void peut_creer_des_repertoires() throws IOException {
        Files.createDirectory(Path.of("src/test/java/File/toto"));
    }

    @Test
    void peut_copier_un_fichier() throws IOException {
        Files.copy(Path.of("src/test/java/File/FileTest.java"), Path.of("src/test/java/File/FileTest-save.java"));
    }

    @Test
    void peut_utiliser_les_classes_de_haut_niveau_IOStream_avec_des_classes_de_bas_niveau() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/File/FileTest.java"))) {
            System.out.println(reader.readLine());
        }

        // TODO peut aussi utiliser la classe Files
        Files.readAllLines(Paths.get("src/test/java/File/FileTest.java")).forEach(System.out::println);
    }
}
