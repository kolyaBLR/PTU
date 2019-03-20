package test.stream;

import main.stream.File;
import main.stream.Parcelable;
import main.university.Audience;
import main.university.Laboratory;
import main.university.LectureRoom;
import main.university.TrainingClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    private String path = "test.txt";
    private File file = new File(path);

    @AfterEach
    void after() {
        boolean isCompleted = new java.io.File(path).delete();
    }

    @BeforeEach
    void before() {
        boolean isCompleted = new java.io.File(path).delete();
    }

    private void assertEqualsAudience(Audience expected, Audience actual) {
        assertEquals(expected.getArea(), actual.getArea());
        assertEquals(expected.getFloor(), actual.getFloor());
        assertEquals(expected.get(), actual.get());
        assertEquals(expected.calculationOfCapacity(), actual.calculationOfCapacity());
    }

    @Test
    void write_and_read_single_laboratory() throws Exception {
        Laboratory expected = new Laboratory(3, 1, 3, 1);

        file.write(expected);
        List<Parcelable> objects = file.read();

        boolean isSingleLaboratory = objects.size() == 1 && objects.get(0) instanceof Laboratory;
        assertTrue(isSingleLaboratory);
        Laboratory actual = (Laboratory) objects.get(0);
        assertEqualsAudience(expected, actual);
        assertEquals(expected.getNumberOfComputers(), actual.getNumberOfComputers());
    }

    @Test
    void write_and_read_single_lecture_room() throws Exception {
        LectureRoom expected = new LectureRoom(4124, 123, 213, 123, 213, false);

        file.write(expected);
        List<Parcelable> objects = file.read();

        boolean isSingleLaboratory = objects.size() == 1 && objects.get(0) instanceof LectureRoom;
        assertTrue(isSingleLaboratory);
        LectureRoom actual = (LectureRoom) objects.get(0);
        assertEqualsAudience(expected, actual);
        assertEquals(expected.getNumberOfRows(), actual.getNumberOfRows());
        assertEquals(expected.getNumberOfSeatsInARow(), actual.getNumberOfSeatsInARow());
        assertEquals(expected.isProjector(), actual.isProjector());
    }

    @Test
    void write_and_read_single_training_class() throws Exception {
        TrainingClass expected = new TrainingClass(4124, 123, 213, 123, false);

        file.write(expected);
        List<Parcelable> objects = file.read();

        boolean isSingleLaboratory = objects.size() == 1 && objects.get(0) instanceof TrainingClass;
        assertTrue(isSingleLaboratory);
        TrainingClass actual = (TrainingClass) objects.get(0);
        assertEqualsAudience(expected, actual);
        assertEquals(expected.getNumberOfDesks(), actual.getNumberOfDesks());
        assertEquals(expected.isComputer(), actual.isComputer());
    }

    @Test
    void write_and_read_multi_audiences() throws Exception {
        ArrayList<Parcelable> expected = new ArrayList<>();
        expected.add(new Laboratory(6, 2, 41, 4));
        expected.add(new TrainingClass(4124, 123, 213, 123, false));
        expected.add(new Laboratory(3, 1, 3, 1));
        expected.add(new Laboratory(3, 1, 3, 1));

        file.write(expected);
        List<Parcelable> actual = file.read();

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertTrue(actual.get(i) instanceof Audience);
            Audience actualItem = (Audience) actual.get(i);
            assertEqualsAudience((Audience) expected.get(i), actualItem);
        }
    }
}