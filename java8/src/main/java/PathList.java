import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PathList {

    public final Path[] paths;

    public PathList(Path... paths) {
        this.paths = paths;
    }

    public Optional<Path> shortest() {
        return stream(paths).min(Comparator.comparingDouble(Path::getDistance));
    }

    public PathList filterWithStops(Point... points) {
        Set<Point> stopsSet = stream(points).collect(Collectors.toSet());
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
