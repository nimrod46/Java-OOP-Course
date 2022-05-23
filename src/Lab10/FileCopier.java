package Lab10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileCopier implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                int i = 0;
                FileReader fileReader = new FileReader("many_words.txt");
                while (true) {
                    if ((i = fileReader.read()) == -1) break;
                    System.out.print((char) i);
                }
                fileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
}
