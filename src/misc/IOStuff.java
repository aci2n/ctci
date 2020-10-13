package misc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class IOStuff {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
        }

        try (Scanner scanner = new Scanner(new FileInputStream("test_stdin"))) {
            while (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("test_stdin"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        try (FileInputStream inputStream = new FileInputStream("test_stdin")) {
            byte[] bytes = inputStream.readAllBytes();
            System.out.println(new String(bytes, StandardCharsets.UTF_8));
        }

        try (FileReader reader = new FileReader("test_stdin")) {
            StringBuilder builder = new StringBuilder();
            char[] buff = new char[8];
            while (reader.read(buff) > 0) builder.append(buff);
            System.out.println(builder);
        }

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("test_stdin"))) {
            StringBuilder builder = new StringBuilder();
            char[] buff = new char[8];
            while (reader.read(buff) > 0) builder.append(buff);
            System.out.println(builder);
        }

        /*
            BufferedReader wraps a reader (for example FileReader), offers utilities like readline(), also buffers for performance
            FileReader extends InputStreamReader and pretty much only encapsulates a new FileInputStream(filename)
            FileInputStream extends InputStream, it's an input stream backed by a file
            Scanner accepts an InputStream, like stdin or a FileInputStream, has utilities like scanNextInt()
         */

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            writer.write("hola");
        }
    }
}
