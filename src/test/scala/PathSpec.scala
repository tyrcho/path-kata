import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks

@RunWith(classOf[JUnitRunner])
class PathSpec extends FlatSpec with Matchers {

  val pa = Point("a", 0, 0)
  val pb = Point("b", 10, 10)
  val pc = Point("c", 20, 0)
  val pd = Point("d", 30, 0)
  val pe = Point("e", 40, 0)

  val ac = Segment(pa, pc)
  val bc = Segment(pb, pc)
  val ab = Segment(pa, pb)
  val cd = Segment(pc, pd)
  val de = Segment(pd, pe)
  val acde = Path(List(ac, cd, de))
  val abcde = Path(List(ab, bc, ac, cd, de))
  // a---c--d--e
  //  \ /
  //   b

  // steps
  // Segment.distance
  // Path.distance
  // Path.allStops
  // filter paths with 1 stop
  // filter paths with stops
  // shortest path (nonempty, empty paths)

  "a segment" should "compute its distance" in {
    val distance = ac.distance
    distance shouldBe 20.0 +- 0.0001
  }

  "a path" should "compute its distance" in {
    val distance = acde.distance
    distance shouldBe 40.0 +- 0.0001
  }

  it should "list all its stops" in {
    val stops = acde.stops
    stops shouldBe Set(pa, pc, pd, pe)
  }

  "a path helper" should "find the shortest path" in {
    val helper = new PathHelper
    helper.shortestPath(List(acde, abcde)) shouldBe Some(acde)
  }

  it should "find no shortest path" in {
    val helper = new PathHelper
    helper.shortestPath(Nil) shouldBe None
  }

  it should "filter paths with a stop" in {
    val helper = new PathHelper
    helper.filter(List(acde, abcde), pb) shouldBe List(abcde)
  }

  it should "filter paths with stops" in {
    val helper = new PathHelper
    helper.filter(List(acde, abcde), List(pb, pc)) shouldBe List(abcde)
  }

  it should "find the shortest path with a stop" in {
    val helper = new PathHelper
    helper.shortestPath(List(acde, abcde), List(pa, pb)) shouldBe Some(abcde)
  }

}