
import java.awt.*;
import java.util.List;

public class Polygon extends Item {

    private List<Point> points;

    public Polygon(List<Point> points) {
        this.points = points;
    }

    public boolean includes(Point point) {
        for (Point p : points) {
            if (distance(point, p) < 10.0) {
                return true;
            }
        }
        return false;
    }

    public void render(UIContext uiContext) {
        for (int i = 0; i < points.size() - 1; i++) {
            uiContext.drawLine(points.get(i), points.get(i + 1));
        }
    }

    public String toString() {
        return "Polygon with " + points.size() + " points";
    }
    public void translate(int dx, int dy) {
        for (Point point : points) {
            point.translate(dx, dy);
        }
    }
    
    
    
}
