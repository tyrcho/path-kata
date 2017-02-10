import static javaslang.collection.Stream.of;

import javaslang.collection.List;
import javaslang.collection.Set;

public class Path {
    final List<Segment> segments;

    public Path(Segment... segments) {
        this.segments = List.of(segments);
    }

    public double getDistance() {
        return segments.map(Segment::getDistance).sum().doubleValue();
    }

    public Set<Point> getStops() {
        return segments.flatMap((seg) -> of(seg.origin, seg.dest)).toSet();
    }
}
