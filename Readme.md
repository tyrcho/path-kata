# Functional Programming Kata : Paths

## Context

We will build some simple classes to handle paths. 
We imagine that some Google Maps like API provides possible paths from home to work 
and we want to select the best one based on duration and intermediate stops to pickup colleagues on the way.

- Point(x,y)
- Segment(origin, destination)
- Path(segments) *We consider that a path is collection of segments, rather than a collection of points*
- PathList(paths)

We want to find the shortest path in a PathList, then to find the shortest path which stops at specific points.

## TDD Steps

Suggestion of implementation steps, which should match with your tests :

### Goal : Find the shortest path in a list of paths

* Compute the distance of a segment
* Compute the distance of a path
* Find the shortest path in a list of paths

### Goal : Filter paths keeping only those which include a given list of stops

* Enumerate all stops in a path
* Filter paths keeping only those which include a stop
* Filter paths keeping only those which include a given list of stops

### Goal : Find the shortest path in a list of paths, which includes a given list of stops
  
## Syntax examples

see [java8/syntax.md](java8/syntax.md) or [scala/syntax.md](scala/syntax.md) for examples in Java 8 or in Scala.
