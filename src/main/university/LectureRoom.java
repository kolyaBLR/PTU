package main.university;

import main.stream.Parcelable;

public class LectureRoom extends Audience implements Parcelable {

    private int numberOfRows;
    private int numberOfSeatsInARow;
    private boolean isProjector;

    public LectureRoom(int number, int floor, int area, int numberOfRows, int numberOfSeatsInARow, boolean isProjector) {
        super(number, floor, area);
        this.numberOfRows = numberOfRows;
        this.numberOfSeatsInARow = numberOfSeatsInARow;
        this.isProjector = isProjector;
    }

    public LectureRoom(Object[] data) {
        super(data);
        numberOfRows = Integer.parseInt(data[3].toString());
        numberOfSeatsInARow = Integer.parseInt(data[4].toString());
        isProjector = Boolean.parseBoolean(data[5].toString());
    }

    @Override
    public int calculationOfCapacity() {
        return numberOfRows * numberOfSeatsInARow;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfSeatsInARow() {
        return numberOfSeatsInARow;
    }

    public boolean isProjector() {
        return isProjector;
    }

    @Override
    public String get() {
        return super.get() + " " + numberOfRows + " " + numberOfSeatsInARow + " " + isProjector;
    }
}
