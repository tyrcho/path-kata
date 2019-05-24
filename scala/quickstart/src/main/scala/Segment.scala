case class Point(name: String, x: Long, y: Long)

case class Segment(f: Point, t: Point) {
  def distance: Double =
    math.sqrt((f.x - t.x) * (f.x - t.x) + (f.y - t.y) * (f.y - t.y))
}
