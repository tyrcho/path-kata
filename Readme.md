# Functional Programming Kata : Paths

The objective of this Kata is to be a gentle introduction to Functional Programming in 1h30 - 2h. 
Take 15 min to introduce the context, setup the groups and prepare the IDEs and 15 min a the end to share the code and retrospect.

## Functional Programming

In FP, we split our code between pure functional code and code with side effects (IO, modifying variables ...).

This Kata can be done with pure functional style (no modification of variables => all can be declared final).

FP means that we make heavy use of functions : they can be passed as arguments to other functions. See the syntax examples for suggestions.
Note : FP also means that a function can return a function but this is not needed here.

## TDD 

### 3 rules

1. You are not allowed to write any production code unless it is to make a failing unit test pass.
2. You are not allowed to write any more of a unit test than is sufficient to fail; and compilation failures are failures.
3. You are not allowed to write any more production code than is sufficient to pass the one failing unit test.

Source : [Uncle Bob](http://butunclebob.com/ArticleS.UncleBob.TheThreeRulesOfTdd)

### Suggestion for the process

Always start by testing the limit condition(s) : empty list, value of zero ... This allows you to focus on the usage of the method and its signature.
Then add a more relevant test to check the implementation.


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
  
### Bonus Goal : compute all possible paths between 2 points, given a list of Segments

This step is more tricky because it involves recursion so it is usually only reachable for the fastest groups who already have experience with Functional Programming.

## Syntax examples

see [Demo.java](java8/quickstart/src/main/java/Demo.java) or [Demo.sc](scala/quickstart/src/main/scala/Demo.sc) for examples in Java 8 or in Scala.
