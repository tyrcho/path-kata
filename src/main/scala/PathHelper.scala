
class PathHelper {
  type Path = Seq[Segment]

  implicit class PathOps(path: Path) {
    def distance = path.map(_.distance).sum
  }

  def findPath(segments: Path, from: Point, to: Point, stops: Seq[Point] = Nil): Option[Path] = {
    if (from == to) Some(Seq())
    else (for {
      s <- segments
      if s.start== from
      path <- findPath(segments, s.end, to)
    } yield s +: path) match {
      case Nil => None
      case l =>
        val withStops = l.filter(path => stops.forall(stop => path.exists(seg => seg.start == stop)))
        Some(withStops.minBy(_.distance))
    }
  }

}