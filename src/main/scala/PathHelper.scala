
class PathHelper {
  def findPath(segments: Seq[Segment], from: String, to: String): Option[Seq[Segment]] = {
    if (from == to) Some(Seq())
    else (for {
      s <- segments
      if s.start == from
      path <- findPath(segments, s.end, to)
    } yield s +: path).headOption
  }

}