package test.mine.mytest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.hateoas.ResourceSupport;


import java.io.UnsupportedEncodingException;

public class Place {
    @Id private String id;


    private String name;
    private String category;

    private Point coordinates;

    public Place() {
    }

    public Place( String name, String category, Point coordinates) throws UnsupportedEncodingException {
        this.name = name;
        this.category = category;
        this.coordinates = coordinates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String cat){
        category=cat;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}