package stream;

import university.Laboratory;
import university.LectureRoom;
import university.TrainingClass;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class File {

    private static String FILE_NAME = "data.txt";

    public void write(Parcelable object) throws Exception {
        Parcelable[] objects = new Parcelable[1];
        objects[0] = object;
        write(objects);
    }

    public void write(List<Parcelable> objects) throws Exception {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            ArrayList<Parcelable> array = new ArrayList<>(objects);
            for (Parcelable item : array) {
                String text = item.getClass().getName() + " " + item.get() + "\n";
                writer.write(text);
            }
            writer.flush();
        }
    }

    public void write(Parcelable... objects) throws Exception {
        ArrayList<Parcelable> array = new ArrayList<>(Arrays.asList(objects));
        write(array);
    }

    public List<Parcelable> read() throws Exception {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            ArrayList<Parcelable> result = new ArrayList<>();
            char symbol;
            StringBuilder line = new StringBuilder();
            while ((symbol = (char) reader.read()) != '\uFFFF') {
                if (symbol == '\n') {
                    String[] str = line.toString().split(" ");
                    result.add(createObject(getClassName(str), getData(str)));
                    line.delete(0, line.length());
                } else {
                    line.append(symbol);
                }
            }
            return result;
        }
    }

    private String getClassName(String[] line) {
        return line[0];
    }

    private Object[] getData(String[] line) {
        Object[] data = new Object[line.length - 1];
        for (int i = 1; i < line.length; i++) {
            try {
                data[i - 1] = Integer.parseInt(line[i]);
            }catch (NumberFormatException ex) {
                data[i - 1] = Boolean.parseBoolean(line[i]);
            }
        }
        return data;
    }

    private Parcelable createObject(String className, Object[] data) throws Exception {
        if (className.equals(Laboratory.class.getName())) {
            return new Laboratory(data);
        } else if (className.equals(LectureRoom.class.getName())) {
            return new LectureRoom(data);
        } else if (className.equals(TrainingClass.class.getName())) {
            return new TrainingClass(data);
        } else {
            throw new Exception("Не найдено нужное хранилище для данных.");
        }
    }
}
