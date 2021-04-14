package main.vmware.tb.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// int char = reader.read != -1
// type of input - FileReader, StringReader
// behavior to the Reader - BufferedReader, LineNumberReader
// close
// finally and try-with-resources
// close behavior readers - just ones
// Files .newBufferedReader .lines Charset
public class ReadingChars {

    private static final String FILE_NAME = "3000-lines-text.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line = reader.readLine();

            while(line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
