
class PathHelper {
  type Path = Seq[Segment]
  
  implicit class PathOps(path:Path) {
    def distance = path.map(_.distance).sum
  }

  def findPath(segments: Path, from: String, to: String): Option[Path] = {
    if (from == to) Some(Seq())
    else (for {
      s <- segments
      if s.start == from
      path <- findPath(segments, s.end, to)
    } yield s +: path) match {
      case Nil => None
      case l => Some(l.minBy(_.distance))
    }
  }

}