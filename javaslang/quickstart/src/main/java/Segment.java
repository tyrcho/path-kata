public class Segment {
    public final Point origin;
    public final Point dest;

    public Segment(Point origin, Point dest) {
        this.origin = origin;
        this.dest = dest;
    }

    public double getDistance() {
        double deltaX = origin.x - dest.x;
        double deltaY = origin.y - dest.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
