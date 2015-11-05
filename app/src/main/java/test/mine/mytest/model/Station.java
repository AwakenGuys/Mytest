package test.mine.mytest.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;


public abstract class Station {
    @Id private String id;
    private String name;
    private Point coordinates;

    public Station() {
    }

    public Station(String name, Point coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Station{" +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}
