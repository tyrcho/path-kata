import Path._
import org.scalatest.{FlatSpec, Matchers}

class PathSpec extends FlatSpec with Matchers {

  val pa = Point(x = 0, y = 0)
  val pb = Point(x = 10, y = 10)
  val pc = Point(x = 20, y = 0)
  val pd = Point(x = 30, y = 0)
  val pe = Point(x = 40, y = 0)
  val pf = Point(x = 40, y = 20)

  val ac = Segment(from = pa, to = pc)
  val bc = Segment(from = pb, to = pc)
  val ab = Segment(from = pa, to = pb)
  val cd = Segment(from = pc, to = pd)
  val de = Segment(from = pd, to = pe)
  // a---c--d--e
  //  \ /
  //   b

  "a segment" should "compute its distance" in {
    val distance = ac.distance
    distance shouldBe 20.0 +- 0.0001
  }

  val acde = Path(List(ac, cd, de))
  "a path" should "compute its distance" in {
    acde.distance shouldBe 40.0 +- 0.0001
  }

  it should "list where it stops" in {
    acde.stops shouldBe Set(pa, pc, pd, pe)
  }

  val abcde = Path(List(ab, bc, cd, de))

  "paths" should "find the shortest path" in {
    shortest(List(acde, abcde)) shouldBe Some(acde)
  }

  it should "filter on a given stop" in {
    stopAt(pb, List(acde, abcde)) shouldBe List(abcde)
    stopAt(pa, List(acde, abcde)) shouldBe List(acde, abcde)
    stopAt(pf, List(acde, abcde)) shouldBe Nil
  }

  it should "filter on several stops" in {
    stopAt(List(pa, pb), List(acde, abcde)) shouldBe List(abcde)
    stopAt(List(pf), List(acde, abcde)) shouldBe Nil
  }

  it should "find the best path" in {
    best(List(pa, pb), List(acde, abcde)) shouldBe Some(abcde)
  }

  it should "list possible paths" in {
    possiblePaths(pa, pb, Set()) shouldBe Set()
    possiblePaths(pa, pb, Set(ab)) shouldBe Set(Path(List(ab)))
    possiblePaths(pa, pe, Set(ac, cd, de, ab, bc)) shouldBe Set(Path(List(ac, cd, de)), Path(List(ab, bc, cd, de)))
  }

}
