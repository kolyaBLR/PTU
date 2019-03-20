package main.university;

import main.stream.Parcelable;

public class Laboratory extends Audience implements Parcelable {

    private int numberOfComputers;

    public Laboratory(int number, int floor, int area, int numberOfComputers) {
        super(number, floor, area);
        this.numberOfComputers = numberOfComputers;
    }

    public Laboratory(Object[] data) {
        super(data);
        numberOfComputers = Integer.parseInt(data[3].toString());
    }

    @Override
    public int calculationOfCapacity() {
        return numberOfComputers;
    }

    public int getNumberOfComputers() {
        return numberOfComputers;
    }

    @Override
    public String get() {
        return super.get() + " " + numberOfComputers;
    }
}
