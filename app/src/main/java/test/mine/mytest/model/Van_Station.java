package test.mine.mytest.model;

import org.springframework.data.geo.Point;

/**
 * Created by Xync on 05-Nov-15.
 */
public class Van_Station extends Station {
    public Van_Station() {
    }

    public Van_Station(String name, Point coordinates) {
        super(name, coordinates);
    }
}
