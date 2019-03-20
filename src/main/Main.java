package main;

import main.stream.ConsoleReader;
import main.stream.ConsoleWriter;
import main.stream.File;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("data.txt");
        file.write(ConsoleReader.readData());
        ConsoleWriter.print(file.read());
    }
}
