import static java.util.Arrays.stream;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class PathList {

    public final Path[] paths;

    public PathList(Path... paths) {
        this.paths = paths;
    }

    public Optional<Path> shortest() {
        return stream(paths).min(comparingDouble(Path::getDistance));
    }

    public PathList filterWithStops(Point... points) {
        Set<Point> stopsSet = stream(points).collect(toSet());
        return new PathList(stream(paths).filter(path -> path.getStops().containsAll(stopsSet)).toArray(Path[]::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PathList pathList = (PathList) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(paths, pathList.paths);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(paths);
    }
}
