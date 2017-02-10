import static java.util.Comparator.comparingDouble;

import javaslang.collection.HashSet;
import javaslang.collection.List;
import javaslang.collection.Set;
import javaslang.control.Option;

public class PathList {

    public final List<Path> paths;

    public PathList(Path... paths) {
        this(List.of(paths));
    }

    public PathList(List<Path> paths) {
        this.paths = paths;
    }

    public Option<Path> shortest() {
        return paths.minBy(comparingDouble(Path::getDistance));
    }

    public PathList filterWithStops(Point... points) {
        Set<Point> stopsSet = HashSet.of(points);
        return new PathList(paths.filter(path -> path.getStops().containsAll(stopsSet)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PathList pathList = (PathList) o;

        return paths.equals(pathList.paths);
    }

    @Override
    public int hashCode() {
        return paths.hashCode();
    }
}
