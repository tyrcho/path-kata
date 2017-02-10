import org.junit.Assert
import org.junit.Test

class PathsTest {
    val a = Point(0, 10)
    val b = Point(0, 20)
    val c = Point(10, 20)
    val ab = Segment(a, b)
    val ac = Segment(a, c)
    val bc = Segment(b, c)

    @Test
    fun testSegmentDistance0() {
        val segment = Segment(a, a)
        Assert.assertEquals(0.0, segment.distance, 0.01)
    }

    @Test
    fun testSegmentDistanceNonZero() {
        Assert.assertEquals(10.0, ab.distance, 0.01)
    }
}
