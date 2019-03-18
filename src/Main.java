import stream.File;
import university.Laboratory;
import university.LectureRoom;

public class Main {

    public static void main(String[] args) throws Exception {

        File file = new File();
        file.write(new Laboratory(3, 1, 2, 31));
        file.write(new LectureRoom(1, 2, 3, 3, 1, true));

        System.out.println("Hello World!");
    }
}
