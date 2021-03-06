package test.mine.mytest.model;


public class Bus_Line {
    private String id;
    private String line;
    private String route;

    public Bus_Line() {
    }

    public Bus_Line(String line, String route) {
        this.line = line;
        this.route = route;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Bus_Line{" +
                "id='" + id + '\'' +
                ", line='" + line + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
