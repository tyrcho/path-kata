
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks

@RunWith(classOf[JUnitRunner])
class PathSpec extends FlatSpec with Matchers {
  val helper = new PathHelper
  //  val pa = Point("a", 0, 0)
  //  val pb = Point("b", 10, 10)
  //  val pc = Point("c", 20, 0)
  val pd = Point("D", 30, 0)
  //  val pe = Point("E", 40, 0)
  val pa = Point("A", 0, 0)
  val pb = Point("B", 10, 0)
  val pc = Point("C", 5, 5)

  // a---c--d--e
  //  \ /
  //   b

  "a path helper" should "find trivial path" in {
    //When
    val path = helper.findPath(List(Segment(pa, pb)), pa, pb)
    //Then
    path shouldBe Some(List(Segment(pa, pb)))
  }

  it should "find no path if no segments are used" in {
    //When
    val path = helper.findPath(List(), pa, pb)
    //Then
    path shouldBe None
  }

  it should "find an empty path if origin = destination" in {
    //When
    val path = helper.findPath(List(Segment(pa, pb)), pa, pa)
    //Then
    path shouldBe Some(Nil)
  }

  it should "find a path in a simple case with only one possibility" in {
    //When
    val path = helper.findPath(List(Segment(pa, pb), Segment(pa, pc)), pa, pb)
    //Then
    path shouldBe Some(List(Segment(pa, pb)))
  }

  it should "list available destinations with the distance of one segment" in {
    //Given
    //When
    val destinations = helper.findDestinations(List(Segment(pa, pb), Segment(pa, pc)), pa)
    //Then
    destinations shouldBe List(pb, pc)

  }

  it should "find the shortest path" in {
    //When
    val path = helper.findPath(List(Segment(pa, pc), Segment(pc, pb), Segment(pb, pd), Segment(pa, pb)), pa, pd)
    //Then
    path shouldBe Some(List(Segment(pa, pb), Segment(pb, pd)))
  }

  "a segment" should "know its distance" in {
    //Given
    val segment = Segment(pa, pb)
    //When
    val distance = segment.distance
    //Then
    distance shouldBe 10.0 +- 0.0001
  }

  "a path" should "know its distance" in {
    //Given
    val path = List(Segment(pa, pb), Segment(pb, pd))
    //When
    val distance = helper.getDistance(path)
    //Then
    distance shouldBe 30.0 +- 0.0001
  }
}