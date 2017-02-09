import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class PathsTest {
    final Point a = new Point(0, 10);
    final Point b = new Point(0, 20);
    final Point c = new Point(10, 20);
    final Segment ab = new Segment(a, b);
    final Segment ac = new Segment(a, c);
    final Segment bc = new Segment(b, c);

    @Test
    public void testSegmentDistance0() {
        Segment segment = new Segment(a, a);
        Assert.assertEquals(0, segment.getDistance(), 0.01);
    }

    @Test
    public void testSegmentDistanceNonZero() {
        Assert.assertEquals(10, ab.getDistance(), 0.01);
    }
}
