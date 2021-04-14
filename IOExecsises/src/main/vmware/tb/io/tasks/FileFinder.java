package main.vmware.tb.io.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {

    /**
     * Lists the full paths of the files in a given directory (and subdirectories). If null or blank
     * dirPath is provided IllegalArgumentException is thrown.
     */
    public List<String> listFilesByDir(String dirPath) {
        if (dirPath == null) {
            throw new IllegalArgumentException();
        }
        if (dirPath.strip().equals("")) {
            throw new IllegalArgumentException();
        }

        List<String> result = new ArrayList<>();
        try {
            Files.walk(Paths.get(dirPath)).filter(Files::isRegularFile).forEach(file -> result.add(file.toString()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
