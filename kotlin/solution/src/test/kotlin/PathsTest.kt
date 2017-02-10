
import org.junit.Assert
import org.junit.Test
import java.util.*

class PathsTest {
    val a = Point(0, 10)
    val b = Point(0, 20)
    val c = Point(10, 20)
    val ab = Segment(a, b)
    val ac = Segment(a, c)
    val bc = Segment(b, c)
    val abcPath = Path(ab, bc)
    val acPath = Path(ac)
    private val emptyPath = Path()
    val paths = listOf(abcPath, acPath)

    @Test
    fun testSegmentDistance0() {
        val segment = Segment(a, a)
        Assert.assertEquals(0.0, segment.distance, 0.01)
    }

    @Test
    fun testSegmentDistanceNonZero() {
        Assert.assertEquals(10.0, ab.distance, 0.01)
    }

    @Test
    fun testPathDistance0() {
        val path = emptyPath
        Assert.assertEquals(0.0, path.distance, 0.01)
    }

    @Test
    fun testPathDistanceABC() {
        Assert.assertEquals(20.0, abcPath.distance, 0.01)
    }

    @Test
    fun testShortestPathNone() {
        val paths = listOf<Path>()
        val best = paths.shortest()
        Assert.assertEquals(Optional.empty<Any>(), best)
    }

    @Test
    fun testShortestPath() {
        val best = paths.shortest()
        Assert.assertEquals(Optional.of(acPath), best)
    }

    @Test
    fun testStopsNone() {
        val stops = emptyPath.stops
        Assert.assertEquals(0, stops.size.toLong())
    }

    @Test
    fun testStopsABC() {
        val stops = abcPath.stops
        Assert.assertEquals(HashSet(Arrays.asList(a, b, c)), stops)
    }

    @Test
    fun filterEmptyPathWithStops() {
        val empty = listOf<Path>()
        val result = empty.filterWithStops(a)
        Assert.assertEquals(listOf<Path>(), result)
    }

    @Test
    fun filterPathWithNoStops() {
        val result = paths.filterWithStops()
        Assert.assertEquals(paths, result)
    }

    @Test
    fun filterPathWithStops() {
        val result = paths.filterWithStops(a, b)
        val expected = listOf(abcPath)
        Assert.assertEquals(expected, result)
    }
}
