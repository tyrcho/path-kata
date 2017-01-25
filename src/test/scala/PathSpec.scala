
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks

@RunWith(classOf[JUnitRunner])
class PathSpec extends FlatSpec with Matchers {
  val helper = new PathHelper
  val pa = Point("a", 0, 0)
  val pb = Point("b", 10, 10)
  val pc = Point("c", 20, 0)
  val pd = Point("d", 30, 0)
  val pe = Point("e", 40, 0)

  // a---c--d--e
  //  \ /
  //   b

  "a path helper" should "find trivial path" in {
    val path = helper.findPath(Seq(Segment(pa, pb)), pa, pb)
    path shouldBe Some(Path(Seq(Segment(pa, pb))))
  }

  it should "find no path if no segments are used" in {
    val path = helper.findPath(Seq(), pa, pb)
    path shouldBe None
  }

  it should "find an empty path if start == end " in {
    val path = helper.findPath(Seq(), pa, pa)
    path shouldBe Some(Path())
  }

  it should "find a path from several segments" in {
    val path = helper.findPath(Seq(Segment(pa, pb), Segment(pa, pe), Segment(pc, pd), Segment(pb, pc)), pa, pd)
    path shouldBe Some(Path(Seq(Segment(pa, pb), Segment(pb, pc), Segment(pc, pd))))
  }

  it should "find the shortest path" in {
    val path = helper.findPath(Seq(Segment(pa, pb), Segment(pa, pc), Segment(pc, pd), Segment(pb, pc)), pa, pd)
    path shouldBe Some(Path(Seq(Segment(pa, pc), Segment(pc, pd))))
  }

  it should "find a path with a stop constraint" in {
    val path = helper.findPath(Seq(Segment(pa, pb), Segment(pa, pc), Segment(pc, pd), Segment(pb, pc)), pa, pd, stops = Seq(pb))
    path shouldBe Some(Path(Seq(Segment(pa, pb), Segment(pb, pc), Segment(pc, pd))))
  }

  it should "not find a path when there is a stop constraint" in {
    val path = helper.findPath(Seq(Segment(pa, pc), Segment(pc, pd), Segment(pb, pc)), pa, pd, stops = Seq(pb))
    path shouldBe None
  }

}