
case class Segment(start: Point, end: Point) {
  def distance = {
    val dx = start.x - end.x
    val dy = start.y - end.y
    math.sqrt(dx * dx + dy * dy).toInt
  }
}

case class Point(name: String, x: Int, y: Int)