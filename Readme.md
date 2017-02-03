# Functional Programming Kata : Paths

## Context

We will build some simple classes to handle paths. 
We imagine that some Google Maps like API provides possible paths from home to work 
and we want to select the best one based on duration and intermediate stops to pickup colleagues on the way.

- Point(x,y)
- Segment(origin, destination)
- Path(segments)
- PathList(paths)

We want to find the shortest path in a PathList, then to find the shortest path which stops at specific points.

## Syntax examples

```scala
  def sqr(i: Int): Int = i * i                    
  
  val ints = List(1, 2, 3)                        //> ints  : List[Int] = List(1, 2, 3)
  
  ints.map(i => i * 2)                            //> res0: List[Int] = List(2, 4, 6)
  ints.map(sqr)                                   //> res1: List[Int] = List(1, 4, 9)
  
  ints.sum                                        //> res2: Int = 6
  ints.map(sqr).sum                               //> res3: Int = 14

  ints.min                                        //> res4: Int = 1

  ints.minBy(i => -i)                             //> res5: Int = 3

  ints.map(i => List(i, 2 * i))                   //> res6: List[List[Int]] = List(List(1, 2), List(2, 4), List(3, 6))
  
  ints.flatMap(i => List(i, 2 * i))               //> res7: List[Int] = List(1, 2, 2, 4, 3, 6)
  ints.flatMap(i => List(i, 2 * i)).toSet         //> res8: Set[Int] = Set(1, 6, 2, 3, 4)

  ints.contains(2)                                //> res9: Boolean = true

  ints.filter(i => i % 2 == 0)                    //> res10: List[Int] = List(2)

  val maybeInt: Option[Int] = Some(1)             //> maybeInt  : Option[Int] = Some(1)
  maybeInt.isEmpty                                //> res11: Boolean = false
  
  val noInt: Option[Int] = None                   //> noInt  : Option[Int] = None
  maybeInt.isEmpty                                //> res12: Boolean = false
```