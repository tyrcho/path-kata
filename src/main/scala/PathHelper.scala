
class PathHelper {
  def findPath(segments: Seq[Segment], from: String, to: String): Option[Seq[Segment]] = {
    if (from == to) Some(Seq())
    else if (segments.isEmpty) None
    else Some(segments)
  }

  //      for {
  //      s <- segments
  //      if s.start == from
  //      path <-
  //    }

}