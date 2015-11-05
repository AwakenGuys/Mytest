package test.mine.mytest.model;

import org.springframework.data.geo.Point;

/**
 * Created by Xync on 05-Nov-15.
 */
public class Train_Station extends Station {
    public Train_Station() {
    }

    public Train_Station(String name, Point coordinates) {
        super(name, coordinates);
    }
}
