import org.junit.Assert;
import org.junit.Test;

public class PathsTest {
    final Point a = new Point(0, 10);
    final Point b = new Point(0, 20);
    final Segment ab = new Segment(a, b);

    @Test
    public void testSegmentDistance0() {
        Segment segment = new Segment(a, a);
        double distance = 0; // TODO
        Assert.assertEquals(0, distance, 0.01);
    }

}
