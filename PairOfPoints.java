package midterm.exploration;

public class PairOfPoints {
    Point point1;
    Point point2;

    public PairOfPoints(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    
    
    public static double getDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }
    
    public double getDistance() {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

    @Override
    public String toString() {
        return point1.toString() + " and " + point2.toString();
    }
    
}
