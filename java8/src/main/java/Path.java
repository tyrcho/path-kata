import static java.util.Arrays.stream;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Path {
    final Segment[] segments;

    public Path(Segment... segments) {
        this.segments = segments;
    }

    public double getDistance() {
        return stream(segments).collect(Collectors.summarizingDouble(Segment::getDistance)).getSum();
    }

    public Set<Point> getStops() {
        return stream(segments).flatMap((seg) -> Stream.of(seg.origin, seg.dest)).collect(Collectors.toSet());

    }
}
