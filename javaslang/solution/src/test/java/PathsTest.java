import javaslang.collection.HashSet;
import javaslang.collection.Set;
import javaslang.control.Option;
import org.junit.Assert;
import org.junit.Test;

public class PathsTest {
    final Point a = new Point(0, 10);
    final Point b = new Point(0, 20);
    final Point c = new Point(10, 20);
    final Segment ab = new Segment(a, b);
    final Segment ac = new Segment(a, c);
    final Segment bc = new Segment(b, c);
    final Path abcPath = new Path(ab, bc);
    final Path acPath = new Path(ac);
    private final Path emptyPath = new Path();
    final PathList paths = new PathList(abcPath, acPath);

    @Test
    public void testSegmentDistance0() {
        Segment segment = new Segment(a, a);
        Assert.assertEquals(0, segment.getDistance(), 0.01);
    }

    @Test
    public void testSegmentDistanceNonZero() {
        Assert.assertEquals(10, ab.getDistance(), 0.01);
    }

    @Test
    public void testPathDistance0() {
        Path path = emptyPath;
        Assert.assertEquals(0, path.getDistance(), 0.01);
    }

    @Test
    public void testPathDistanceABC() {
        Assert.assertEquals(20, abcPath.getDistance(), 0.01);
    }

    @Test
    public void testShortestPathNone() {
        PathList paths = new PathList();
        Option<Path> best = paths.shortest();
        Assert.assertEquals(Option.none(), best);
    }

    @Test
    public void testShortestPath() {
        Option<Path> best = paths.shortest();
        Assert.assertEquals(Option.of(acPath), best);
    }

    @Test
    public void testStopsNone() {
        Set<Point> stops = emptyPath.getStops();
        Assert.assertEquals(0, stops.size());
    }

    @Test
    public void testStopsABC() {
        Set<Point> stops = abcPath.getStops();
        Assert.assertEquals(HashSet.of(a, b, c), stops);
    }

    @Test
    public void filterEmptyPathWithStops() {
        PathList empty = new PathList();
        PathList result = empty.filterWithStops(a);
        Assert.assertEquals(new PathList(), result);
    }

    @Test
    public void filterPathWithNoStops() {
        PathList result = paths.filterWithStops();
        Assert.assertEquals(paths, result);
    }

    @Test
    public void filterPathWithStops() {
        PathList result = paths.filterWithStops(a, b);
        PathList expected = new PathList(abcPath);
        Assert.assertEquals(expected, result);
    }
}
