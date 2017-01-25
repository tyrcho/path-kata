
class PathHelper {
  type Path = Seq[Segment]

  implicit class PathOps(path: Path) {
    def distance = path.map(_.distance).sum
  }

  def findPath(segments: Path, from: String, to: String, stops: Seq[String] = Nil): Option[Path] = {
    if (from == to) Some(Seq())
    else (for {
      s <- segments
      if s.start.name == from
      path <- findPath(segments, s.end.name, to)
    } yield s +: path) match {
      case Nil => None
      case l =>
        val withStops = l.filter(path => stops.forall(stop => path.exists(seg => seg.start.name == stop)))
        Some(withStops.minBy(_.distance))
    }
  }

}