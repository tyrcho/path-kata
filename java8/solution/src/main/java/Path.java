
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.of;

import java.util.Set;

public class Path {
    final Segment[] segments;

    public Path(Segment... segments) {
        this.segments = segments;
    }

    public double getDistance() {
        return stream(segments).mapToDouble(Segment::getDistance).sum();
    }

    public Set<Point> getStops() {
        return stream(segments).flatMap((seg) -> of(seg.origin, seg.dest)).collect(toSet());

    }
}
