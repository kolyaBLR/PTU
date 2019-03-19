package stream;

import university.Laboratory;
import university.LectureRoom;
import university.TrainingClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleReader {

    private enum AudienceType {
        LABA("LABA"), ROOM("ROOM"), CLASS("CLASS");

        private String type;

        AudienceType(String type) {
            this.type = type;
        }
    }

    public static List<Parcelable> readData() {
        ArrayList<Parcelable> result = new ArrayList<>();
        try (InputStreamReader stream = new InputStreamReader(System.in)) {
            BufferedReader buffer = new BufferedReader(stream);
            int size = readNumber(buffer, "Введите кол-во аудиторий");
            for (int i = 0; i < size; i++) {
                AudienceType audience = readAudience(buffer);
                switch (audience) {
                    case LABA:
                        result.add(i, new Laboratory(
                                readNumber(buffer, "номер"), readNumber(buffer, "этаж"),
                                readNumber(buffer, "площадь"), readNumber(buffer, "кол-во компьютеров")));
                        break;
                    case ROOM:
                        result.add(i, new LectureRoom(
                                readNumber(buffer, "номер"), readNumber(buffer, "этаж"),
                                readNumber(buffer, "площадь"), readNumber(buffer, "кол-во рядов"),
                                readNumber(buffer, "кол-во мест в ряду"), readBoolean(buffer, "есть ли проектор")));
                        break;
                    case CLASS:
                        result.add(i, new TrainingClass(
                                readNumber(buffer, "номер"), readNumber(buffer, "этаж"),
                                readNumber(buffer, "площадь"), readNumber(buffer, "кол-во парт"),
                                readBoolean(buffer, "есть ли компьютер")));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("С потоком что то не так. " + e.getMessage());
        }
        return result;
    }

    private static AudienceType readAudience(BufferedReader buffer) throws IOException {
        AudienceType audience = null;
        do {
            try {
                System.out.print("Введите аудиториюю (LABA, ROOM, CLASS)");
                String type = buffer.readLine();
                audience = AudienceType.valueOf(type);
            } catch (IllegalArgumentException ex) {
                printError();
            }
        } while (audience == null);
        return audience;
    }

    private static int readNumber(BufferedReader buffer, String message) throws IOException {
        int number = 0;
        do {
            System.out.print(message + ":");
            try {
                number = Integer.parseInt(buffer.readLine());
            } catch (NumberFormatException ex) {
                printError();
            }
        } while (number <= 0);
        return number;
    }

    private static void printError() {
        System.out.println("Не верный ввод. Повторите попытку.");
    }

    private static boolean readBoolean(BufferedReader buffer, String message) throws IOException {
        Boolean result = null;
        do {
            System.out.print(message + ("(yes/no)" + ":"));
            try {
                String text = buffer.readLine();
                if (text.toLowerCase().equals("yes")) {
                    result = true;
                } else if (text.toLowerCase().equals("no")) {
                    result = false;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                printError();
            }
        } while (result == null);
        return result;
    }
}
