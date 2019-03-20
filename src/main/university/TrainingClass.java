package main.university;

import main.stream.Parcelable;

public class TrainingClass extends Audience implements Parcelable {

    private int numberOfDesks;
    private boolean isComputer;

    public TrainingClass(int number, int floor, int area, int numberOfDesks, boolean isComputer) {
        super(number, floor, area);
        this.numberOfDesks = numberOfDesks;
        this.isComputer = isComputer;
    }

    public TrainingClass(Object[] data) {
        super(data);
        numberOfDesks = Integer.parseInt(data[3].toString());
        isComputer = Boolean.parseBoolean(data[4].toString());
    }

    @Override
    public int calculationOfCapacity() {
        return numberOfDesks * 2;
    }

    public int getNumberOfDesks() {
        return numberOfDesks;
    }

    public boolean isComputer() {
        return isComputer;
    }

    @Override
    public String get() {
        return super.get() + " " + numberOfDesks + " " + isComputer;
    }
}
