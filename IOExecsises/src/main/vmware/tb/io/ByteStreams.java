package main.vmware.tb.io;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

// type FileInputStream ByteArrayInputStream
// behavior BufferedInput, DataInputStream
// Gzip and Zip
public class ByteStreams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter status code: ");

        String statusCode = scanner.nextLine();
        downloadImage(statusCode);

        copyImage();
    }

    private static void copyImage() {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("sydney_image.jpg"));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("sydney_image-copy.jpg"))) {

            int data = inputStream.read();

            while (data != -1) {
                outputStream.write(data);
                data = inputStream.read();
            }

        } catch (IOException ex) {

        }
    }

    private static void downloadImage(String resource) {
        String url = "https://http.cat/" + resource;

        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream());
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("downloaded-file.jpg"));
        ) {
            int reader = inputStream.read();
            while (reader != -1) {
                outputStream.write(reader);
                reader = inputStream.read();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
