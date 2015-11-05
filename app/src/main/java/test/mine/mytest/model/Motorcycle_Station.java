package test.mine.mytest.model;

import org.springframework.data.geo.Point;

/**
 * Created by Xync on 05-Nov-15.
 */
public class Motorcycle_Station extends Station {
    public Motorcycle_Station() {
    }

    public Motorcycle_Station(String name, Point coordinates) {
        super(name, coordinates);
    }
}
