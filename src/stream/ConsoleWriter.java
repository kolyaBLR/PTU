package stream;

import university.Laboratory;
import university.LectureRoom;
import university.TrainingClass;

import java.util.List;

public class ConsoleWriter {

    private static void println(String message) {
        System.out.println(message);
    }

    public static void print(List<Parcelable> data) {
        for (Parcelable item : data) {
            println("");
            if (item instanceof Laboratory) {
                Laboratory laboratory = (Laboratory)item;
                println("Лаборатория");
                println("номер:" + laboratory.getNumber());
                println("этаж:" + laboratory.getFloor());
                println("площадь:" + laboratory.getArea());
                println("кол-во компьютеров:" + laboratory.getNumberOfComputers());
                println("вместимость:" + laboratory.calculationOfCapacity());
            } else if (item instanceof LectureRoom) {
                LectureRoom lectureRoom = (LectureRoom)item;
                println("Учебный класс");
                println("номер:" + lectureRoom.getNumber());
                println("этаж:" + lectureRoom.getFloor());
                println("площадь:" + lectureRoom.getArea());
                println("кол-во рядов:" + lectureRoom.getNumberOfRows());
                println("кол-во мест в ряду:" + lectureRoom.getNumberOfSeatsInARow());
                println("есть ли проектор:" + lectureRoom.isProjector());
                println("вместимость:" + lectureRoom.calculationOfCapacity());
            } else if (item instanceof TrainingClass) {
                TrainingClass trainingClass = (TrainingClass)item;
                println("Лекционная аудитория");
                println("номер:" + trainingClass.getNumber());
                println("этаж:" + trainingClass.getFloor());
                println("площадь:" + trainingClass.getArea());
                println("кол-во парт:" + trainingClass.getNumberOfDesks());
                println("есть ли компьютер:" + trainingClass.isComputer());
                println("вместимость:" + trainingClass.calculationOfCapacity());
            }
        }
    }
}
