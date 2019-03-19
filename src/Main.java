import stream.ConsoleReader;
import stream.ConsoleWriter;
import stream.File;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File();
        file.write(ConsoleReader.readData());
        ConsoleWriter.print(file.read());
    }
}
