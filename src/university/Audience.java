package university;

import stream.Parcelable;

public abstract class Audience implements Parcelable {

    private int number;
    private int floor;
    private int area;

    public Audience(int number, int floor, int area) {
        this.number = number;
        this.floor = floor;
        this.area = area;
    }

    public Audience(Object[] data) {
        this.number = Integer.parseInt(data[0].toString());
        this.floor = Integer.parseInt(data[1].toString());
        this.area = Integer.parseInt(data[2].toString());
    }

    public abstract int calculationOfCapacity();

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String get() {
        return number + " " + floor + " " + area;
    }
}
