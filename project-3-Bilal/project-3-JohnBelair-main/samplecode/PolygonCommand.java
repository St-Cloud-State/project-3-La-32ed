
import java.awt.*;
import java.util.ArrayList;

public class PolygonCommand extends Command {
    private java.util.List<Point> points;
    private Polygon currentPolygon;
 

    public PolygonCommand() {
        points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public java.util.List<Point> getPoints() {
        return points;
    }

    public void execute() {
        currentPolygon = new Polygon(points);
        model.addItem(currentPolygon);
    }

     public void closePolygon() {
        if (points.size() > 2) {
            points.add(points.get(0));
        }
     }

    public boolean undo() {
        if (currentPolygon != null) {
            model.removeItem(currentPolygon);
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (currentPolygon != null) {
            execute();
            return true;
        }
        return false;
    }

    public boolean end() {
        return points.size() > 2;
    }
}
