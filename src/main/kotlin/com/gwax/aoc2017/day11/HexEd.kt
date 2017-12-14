package com.gwax.aoc2017.day11

import kotlin.math.max
import kotlin.math.min


/*

-+      +--+      +--
  \    /    \    /
   +--+ 0,1  +--+
  /    \    /    \
-+ -1,0 +--+ 1,1  +--
  \    /    \    /
   +--+ 0,0  +--+
  /    \    /    \
-+ -1,-1+--+ 1,0  +--
  \    /    \    /
   +--+ 0,-1 +--+
  /    \    /    \
-+      +--+      +--

*/

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point = Point(x + other.x,y + other.y)
    operator fun minus(other: Point): Point = Point(x - other.x,y - other.y)
    operator fun times(other: Int): Point = Point (x * other,y * other)

    fun toSteps(): List<Step> = when {
        x == 0 && y == 0 -> listOf()
        x > 0 && y > 0 -> List(min(x,y),{Step.NE}) + (this - Point(1,1) * min(x,y)).toSteps()
        x < 0 && y < 0 -> List(-max(x,y),{Step.SW}) + (this - Point(1,1) * max(x,y)).toSteps()
        else -> List(max(0,x),{Step.SE}) +
                List(max(0,-x),{Step.NW}) +
                List(max(0,y),{Step.N}) +
                List(max(0,-y),{Step.S})
    }
}
fun Iterable<out Point>.sum() = this.reduce { a, b -> a + b}

enum class Step(val dPoint: Point) {
     N(Point(0, 1)),
    NE(Point(1,1)),
    SE(Point(1,0)),
     S(Point(0,-1)),
    SW(Point(-1,-1)),
    NW(Point(-1,0));

    companion object ListFactory {
        fun fromString(input: String) =
                input.split(",").map { valueOf(it.toUpperCase()) }
    }
}

fun main(args: Array<String>) {
    val steps = Step.fromString(input)
    val location = steps.map {it.dPoint}.sum()
    val optimalSteps = location.toSteps()

    println(optimalSteps.size)

    var maxDist = 0
    var currentLocation = Point(0,0)
    steps.forEach {
        currentLocation += it.dPoint
        maxDist = max(maxDist, currentLocation.toSteps().size)
    }
    println(maxDist)
}

val input = "s,ne,ne,sw,n,n,nw,s,se,se,nw,nw,nw,sw,sw,sw,ne,n,se,sw,sw,s,se,sw,sw,sw,s,s,se,s,s,s,s,s,s,sw,ne,s,s,s,ne,s,s,s,se,se,se,n,se,sw,se,se,se,s,sw,se,n,se,nw,ne,se,s,se,nw,se,se,se,ne,se,se,ne,ne,nw,ne,ne,nw,ne,sw,se,se,ne,se,se,se,se,ne,se,sw,se,ne,se,ne,nw,ne,ne,ne,ne,nw,se,ne,ne,ne,ne,ne,nw,n,s,n,se,ne,n,se,ne,n,ne,n,ne,ne,n,ne,n,n,n,n,n,n,n,n,n,n,ne,n,n,n,ne,n,n,n,ne,n,n,n,n,n,n,n,ne,n,n,n,se,n,n,n,n,n,se,n,n,nw,n,s,nw,n,nw,nw,nw,n,n,n,nw,n,n,nw,n,n,n,nw,n,nw,nw,nw,nw,nw,n,n,n,nw,n,nw,sw,ne,s,nw,nw,nw,nw,n,nw,nw,nw,nw,nw,nw,nw,n,sw,nw,nw,n,n,nw,sw,nw,nw,nw,nw,nw,nw,nw,se,ne,nw,nw,nw,nw,nw,n,sw,nw,nw,nw,ne,s,nw,nw,sw,nw,n,sw,nw,n,nw,sw,sw,se,nw,sw,sw,sw,nw,se,se,nw,nw,nw,sw,nw,nw,nw,sw,nw,sw,sw,s,sw,ne,ne,nw,nw,sw,sw,nw,nw,s,nw,sw,nw,sw,sw,nw,sw,nw,ne,sw,ne,nw,se,sw,nw,nw,nw,sw,nw,nw,sw,s,nw,se,sw,nw,s,sw,sw,sw,sw,sw,se,sw,sw,sw,sw,sw,sw,sw,s,se,sw,s,sw,sw,sw,sw,sw,ne,sw,sw,sw,s,sw,nw,sw,sw,sw,sw,sw,sw,sw,se,sw,sw,sw,sw,s,sw,sw,sw,s,sw,s,sw,sw,sw,sw,s,sw,s,s,sw,n,s,sw,sw,n,sw,sw,sw,sw,s,sw,s,sw,sw,s,s,sw,sw,nw,s,sw,sw,sw,s,s,sw,s,sw,s,s,sw,sw,sw,se,s,s,sw,sw,sw,sw,sw,se,sw,s,s,s,s,sw,nw,s,nw,sw,ne,sw,sw,s,sw,ne,ne,ne,sw,s,s,s,nw,s,s,s,s,sw,s,s,s,s,nw,s,ne,se,sw,sw,s,se,s,s,s,s,sw,s,s,n,s,s,s,s,s,s,sw,s,ne,sw,s,nw,s,s,s,s,s,n,s,se,s,s,s,s,nw,s,s,s,s,s,s,s,s,n,sw,s,s,s,s,se,s,s,s,s,s,s,s,s,se,s,se,n,s,s,s,s,s,s,se,s,se,s,nw,s,s,nw,s,se,s,se,s,nw,s,s,s,ne,s,se,s,se,ne,s,s,ne,n,se,se,se,s,s,s,sw,n,se,se,s,s,n,s,n,s,s,s,s,se,se,s,s,se,s,se,se,se,s,s,se,s,se,se,ne,ne,s,sw,se,s,s,se,s,s,s,sw,ne,s,s,n,s,se,s,s,se,s,s,se,se,sw,s,se,s,nw,n,ne,se,n,ne,se,se,s,ne,s,se,se,s,s,se,n,s,se,se,se,s,s,s,se,s,se,se,s,se,n,se,se,se,nw,ne,se,s,se,se,s,se,se,se,se,se,se,se,nw,se,se,s,se,se,se,se,se,sw,se,s,se,se,s,se,se,se,se,se,se,se,ne,se,se,se,se,se,se,se,ne,se,se,se,n,sw,se,se,se,se,se,se,se,sw,nw,se,se,sw,se,se,se,ne,se,se,se,se,se,se,se,se,se,se,se,se,se,se,se,se,nw,se,ne,se,s,se,se,n,se,se,nw,se,se,se,se,se,nw,n,se,se,se,s,se,se,s,ne,ne,se,se,nw,se,se,nw,ne,ne,s,se,ne,sw,se,se,nw,sw,se,n,se,ne,ne,se,se,nw,ne,se,nw,se,ne,ne,ne,n,ne,se,ne,ne,ne,se,nw,se,se,nw,s,ne,se,nw,se,se,ne,se,ne,se,ne,se,ne,se,ne,se,ne,se,se,se,ne,ne,ne,se,se,se,ne,ne,ne,se,se,ne,n,se,se,ne,ne,s,ne,nw,se,se,se,se,n,se,ne,se,n,ne,se,se,ne,ne,ne,ne,ne,se,ne,ne,ne,ne,nw,se,ne,ne,ne,n,ne,se,ne,s,ne,ne,ne,s,se,ne,se,se,se,ne,ne,ne,ne,se,ne,se,ne,ne,ne,ne,ne,ne,ne,se,ne,ne,ne,ne,n,ne,ne,n,se,se,s,ne,ne,ne,ne,ne,ne,ne,se,ne,se,se,n,ne,ne,n,s,ne,s,ne,se,s,ne,ne,se,ne,ne,se,ne,nw,ne,ne,ne,ne,ne,ne,ne,nw,ne,ne,ne,ne,ne,ne,ne,ne,ne,n,ne,ne,ne,ne,ne,se,ne,ne,ne,ne,ne,ne,ne,ne,se,se,s,ne,ne,ne,n,n,ne,nw,sw,ne,ne,nw,ne,ne,ne,ne,ne,ne,s,nw,ne,nw,nw,ne,ne,n,ne,n,ne,n,ne,nw,nw,ne,ne,se,n,ne,ne,ne,ne,sw,ne,se,ne,n,ne,se,nw,ne,ne,ne,s,ne,ne,ne,s,ne,nw,se,n,ne,nw,ne,sw,ne,ne,ne,s,ne,ne,ne,ne,ne,ne,n,se,n,ne,ne,n,se,n,ne,n,ne,s,sw,ne,s,ne,ne,ne,ne,n,ne,ne,sw,ne,n,n,ne,nw,ne,ne,n,s,n,ne,sw,ne,n,s,n,n,se,ne,n,ne,ne,nw,ne,ne,ne,ne,ne,s,se,ne,n,se,ne,ne,ne,ne,ne,ne,ne,ne,nw,ne,n,n,ne,ne,se,sw,ne,n,ne,n,ne,ne,ne,ne,ne,nw,ne,s,ne,ne,n,ne,s,ne,ne,nw,ne,n,ne,n,n,n,ne,sw,se,n,n,n,n,ne,n,n,n,ne,se,se,ne,ne,ne,ne,n,n,nw,n,ne,n,s,ne,n,nw,n,ne,n,n,n,n,ne,nw,n,n,ne,sw,n,n,ne,ne,se,n,n,n,ne,ne,n,ne,n,n,ne,ne,sw,sw,n,ne,n,n,ne,ne,s,n,nw,ne,ne,n,s,n,ne,ne,ne,n,se,n,nw,ne,n,ne,n,ne,nw,ne,ne,nw,ne,sw,se,ne,n,n,ne,n,ne,n,n,n,n,n,n,n,ne,n,se,sw,n,ne,se,n,n,ne,ne,n,n,ne,n,n,n,n,n,n,ne,n,n,n,n,n,n,n,n,ne,n,n,n,n,n,n,n,n,n,nw,ne,n,ne,ne,s,ne,n,n,sw,sw,n,ne,n,n,n,s,ne,n,n,ne,n,n,n,ne,se,n,ne,n,nw,n,se,n,ne,ne,n,ne,ne,n,n,n,ne,n,ne,n,n,ne,se,se,sw,n,s,n,n,ne,n,ne,ne,ne,n,se,ne,n,sw,n,n,ne,sw,n,s,n,n,s,n,n,n,n,n,n,n,n,n,ne,n,n,n,n,n,ne,n,n,n,n,nw,n,n,n,n,n,n,se,sw,n,n,se,n,n,n,n,se,n,nw,nw,nw,n,n,n,n,n,n,n,n,n,s,n,n,n,n,sw,n,n,n,s,n,n,sw,n,n,n,n,n,s,s,n,nw,n,n,n,n,se,n,se,n,n,n,se,n,nw,nw,n,n,n,s,ne,sw,n,n,se,n,n,n,nw,sw,sw,n,n,nw,n,nw,s,n,nw,n,n,n,n,n,n,n,n,n,ne,sw,n,n,n,ne,n,ne,n,sw,n,n,n,n,n,n,se,n,nw,n,n,s,se,nw,n,n,sw,se,s,n,nw,ne,nw,n,n,n,n,n,nw,se,n,s,n,n,n,n,n,n,nw,nw,nw,sw,n,s,se,n,n,nw,s,n,nw,nw,n,n,ne,n,n,n,n,nw,n,n,n,n,n,s,n,n,n,n,se,n,nw,n,nw,n,nw,n,n,se,n,n,nw,n,nw,nw,n,n,nw,se,n,n,nw,sw,nw,nw,n,nw,n,s,s,nw,ne,n,n,n,n,n,n,nw,nw,s,n,nw,se,n,nw,sw,nw,n,n,n,n,nw,n,sw,n,nw,ne,nw,n,n,n,n,nw,nw,nw,n,se,n,nw,n,n,n,n,nw,nw,nw,nw,nw,n,n,nw,n,n,nw,n,n,n,ne,sw,n,ne,n,sw,n,nw,nw,s,n,n,nw,nw,n,ne,nw,n,nw,nw,nw,nw,n,n,se,sw,n,n,n,nw,ne,s,n,n,n,nw,n,nw,nw,sw,nw,nw,ne,n,nw,s,n,n,n,nw,n,nw,nw,n,n,n,ne,se,nw,n,nw,nw,nw,n,n,nw,sw,nw,nw,n,s,n,n,nw,s,n,nw,se,nw,nw,n,nw,n,nw,nw,n,nw,nw,n,nw,s,n,nw,nw,nw,n,n,nw,nw,nw,n,nw,sw,n,nw,sw,nw,nw,ne,sw,nw,n,ne,n,nw,n,nw,nw,n,nw,nw,n,nw,ne,n,nw,nw,nw,nw,nw,nw,n,s,n,n,nw,s,nw,n,n,se,ne,sw,n,nw,n,nw,n,nw,se,nw,n,n,n,s,nw,ne,nw,nw,n,n,ne,nw,nw,nw,s,nw,sw,nw,sw,nw,nw,nw,n,nw,ne,n,se,nw,nw,nw,nw,n,n,nw,se,nw,nw,nw,se,se,nw,s,nw,nw,nw,nw,nw,nw,n,nw,se,nw,nw,nw,n,n,nw,n,n,se,n,nw,nw,nw,nw,nw,n,ne,nw,nw,nw,nw,nw,se,nw,nw,nw,s,nw,s,nw,nw,n,nw,nw,nw,nw,nw,nw,nw,nw,nw,nw,nw,nw,nw,nw,nw,nw,ne,nw,sw,nw,nw,nw,nw,nw,s,n,nw,nw,nw,nw,nw,ne,nw,n,nw,sw,nw,nw,nw,ne,nw,nw,nw,n,nw,nw,s,nw,nw,nw,nw,nw,nw,nw,nw,se,nw,nw,nw,se,nw,nw,n,nw,nw,nw,nw,nw,nw,n,se,nw,nw,nw,n,s,ne,nw,nw,nw,nw,nw,nw,nw,nw,se,nw,nw,nw,nw,nw,nw,sw,nw,sw,s,nw,n,nw,nw,nw,sw,s,nw,n,nw,nw,nw,nw,ne,nw,nw,nw,nw,nw,nw,nw,se,nw,nw,ne,se,nw,nw,nw,nw,nw,nw,nw,nw,sw,nw,nw,nw,nw,se,s,nw,n,ne,n,nw,nw,nw,se,nw,ne,ne,nw,n,se,ne,se,nw,s,nw,nw,ne,nw,sw,nw,sw,nw,s,n,s,nw,nw,nw,nw,nw,nw,nw,nw,nw,sw,nw,nw,nw,nw,nw,se,nw,nw,se,s,nw,nw,nw,nw,nw,nw,nw,nw,nw,nw,nw,n,sw,se,nw,nw,sw,nw,nw,nw,nw,se,nw,nw,ne,sw,sw,nw,n,n,s,sw,nw,nw,nw,nw,nw,s,ne,nw,sw,nw,sw,nw,nw,nw,nw,nw,nw,nw,sw,sw,nw,sw,nw,sw,nw,nw,nw,sw,nw,sw,sw,nw,sw,s,s,nw,s,sw,n,nw,nw,sw,nw,nw,nw,se,n,nw,n,nw,n,sw,nw,nw,nw,nw,ne,sw,s,ne,nw,sw,sw,ne,nw,nw,nw,nw,nw,se,nw,sw,sw,se,sw,nw,se,nw,nw,sw,nw,nw,nw,se,nw,sw,sw,nw,sw,nw,s,nw,nw,nw,nw,sw,nw,nw,nw,se,nw,nw,sw,nw,nw,sw,nw,nw,nw,nw,sw,nw,nw,n,n,nw,nw,n,s,nw,nw,nw,ne,sw,nw,nw,nw,n,sw,se,n,sw,sw,nw,sw,n,nw,nw,nw,nw,nw,nw,se,nw,s,sw,nw,nw,se,s,n,nw,ne,nw,ne,s,nw,sw,nw,nw,nw,nw,sw,sw,nw,nw,sw,nw,nw,nw,nw,n,nw,nw,nw,nw,nw,s,nw,sw,nw,s,sw,nw,sw,ne,nw,nw,nw,nw,sw,sw,nw,sw,sw,nw,nw,sw,sw,nw,nw,sw,sw,nw,sw,n,nw,sw,sw,sw,nw,sw,nw,n,nw,sw,sw,sw,nw,nw,sw,nw,se,nw,sw,sw,sw,sw,nw,sw,sw,nw,nw,nw,nw,nw,nw,n,sw,nw,sw,nw,sw,se,sw,sw,nw,nw,s,nw,sw,nw,nw,nw,sw,sw,sw,nw,se,sw,nw,nw,nw,sw,n,sw,nw,sw,sw,ne,nw,nw,nw,sw,sw,nw,nw,nw,n,nw,sw,nw,sw,nw,sw,sw,nw,nw,sw,nw,sw,sw,nw,sw,sw,nw,sw,sw,sw,nw,n,ne,n,sw,sw,sw,nw,sw,ne,n,nw,nw,sw,s,nw,nw,nw,sw,se,nw,n,sw,ne,sw,sw,nw,sw,nw,nw,se,sw,nw,sw,se,sw,nw,n,sw,sw,s,nw,nw,sw,sw,sw,nw,sw,s,nw,nw,s,sw,ne,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,nw,sw,nw,nw,sw,s,nw,sw,sw,nw,nw,n,sw,nw,sw,sw,ne,sw,nw,sw,sw,sw,se,sw,nw,s,nw,sw,nw,sw,ne,sw,sw,sw,sw,nw,nw,sw,sw,sw,sw,sw,nw,sw,ne,sw,n,sw,nw,sw,sw,nw,n,nw,sw,s,sw,sw,ne,nw,nw,sw,se,sw,nw,nw,sw,nw,sw,nw,n,nw,sw,nw,sw,n,sw,nw,sw,nw,nw,nw,sw,sw,sw,sw,sw,se,n,sw,sw,nw,sw,sw,ne,nw,sw,sw,sw,sw,sw,sw,sw,sw,sw,nw,sw,nw,ne,se,sw,sw,sw,sw,sw,sw,s,nw,sw,sw,nw,sw,sw,sw,nw,sw,nw,sw,nw,sw,sw,nw,nw,sw,s,sw,n,sw,nw,se,sw,sw,sw,n,nw,nw,nw,sw,s,sw,sw,sw,sw,s,sw,n,s,sw,sw,s,se,sw,nw,nw,sw,sw,sw,sw,ne,nw,sw,sw,nw,sw,sw,nw,sw,sw,se,n,n,sw,sw,sw,nw,sw,sw,sw,sw,s,se,sw,nw,sw,nw,sw,sw,se,sw,n,nw,sw,sw,nw,sw,sw,sw,sw,ne,sw,sw,sw,se,sw,sw,sw,sw,sw,sw,sw,s,se,sw,s,nw,sw,sw,nw,sw,se,sw,sw,sw,nw,sw,sw,nw,sw,sw,n,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,nw,sw,sw,sw,sw,sw,sw,sw,se,n,sw,sw,sw,sw,sw,sw,sw,n,sw,sw,sw,sw,sw,sw,n,sw,sw,nw,nw,sw,sw,sw,sw,sw,sw,sw,sw,ne,sw,sw,nw,nw,sw,sw,sw,nw,sw,sw,sw,sw,n,n,sw,nw,sw,sw,n,sw,sw,sw,sw,sw,sw,sw,sw,sw,s,sw,sw,n,sw,sw,sw,n,s,ne,s,sw,sw,nw,s,sw,sw,sw,sw,nw,sw,sw,sw,sw,sw,sw,sw,sw,sw,se,sw,sw,sw,sw,sw,n,sw,sw,sw,sw,sw,sw,sw,sw,sw,se,sw,se,sw,sw,sw,se,sw,sw,s,sw,sw,sw,sw,sw,sw,sw,sw,s,n,sw,sw,s,sw,sw,sw,sw,ne,ne,sw,sw,sw,sw,s,sw,sw,sw,n,se,sw,sw,sw,sw,sw,sw,se,s,sw,sw,sw,se,s,sw,sw,s,sw,sw,sw,s,sw,sw,n,n,s,sw,sw,sw,sw,sw,sw,sw,ne,sw,sw,sw,ne,sw,sw,s,sw,n,s,sw,sw,sw,sw,sw,nw,sw,sw,sw,sw,sw,s,sw,ne,ne,sw,sw,sw,ne,sw,sw,n,sw,sw,sw,sw,s,se,sw,s,sw,nw,s,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,se,n,sw,se,ne,se,sw,sw,sw,ne,n,n,nw,sw,sw,sw,sw,sw,sw,sw,nw,sw,ne,sw,s,sw,s,ne,n,s,sw,s,sw,nw,s,nw,sw,s,sw,sw,s,sw,sw,sw,n,sw,sw,s,sw,se,s,se,sw,s,sw,sw,sw,s,s,ne,sw,sw,sw,sw,s,sw,sw,s,sw,sw,s,sw,n,sw,sw,sw,sw,s,sw,se,sw,s,sw,sw,sw,sw,sw,s,sw,s,sw,sw,sw,sw,sw,sw,se,sw,s,sw,sw,n,sw,sw,se,s,sw,sw,sw,s,s,s,nw,sw,sw,sw,nw,sw,sw,sw,sw,ne,s,sw,se,sw,sw,s,se,sw,sw,s,sw,ne,sw,sw,sw,sw,s,sw,s,n,sw,nw,sw,sw,sw,s,sw,sw,sw,s,sw,sw,nw,s,sw,ne,sw,s,s,s,sw,s,sw,ne,sw,ne,sw,nw,sw,s,ne,sw,s,sw,sw,sw,sw,s,s,sw,s,sw,sw,ne,se,sw,ne,s,sw,s,sw,nw,nw,sw,sw,s,sw,sw,s,se,sw,sw,s,s,s,s,sw,sw,s,sw,s,s,s,s,s,sw,s,sw,sw,se,sw,sw,sw,sw,n,s,sw,se,s,nw,sw,s,sw,nw,s,sw,s,n,s,sw,sw,s,sw,n,sw,ne,n,sw,sw,se,se,s,sw,s,sw,se,sw,sw,ne,sw,s,s,sw,s,s,s,s,s,s,sw,sw,s,s,se,s,sw,nw,sw,sw,sw,s,sw,sw,sw,nw,sw,s,se,s,sw,sw,n,sw,ne,sw,s,sw,sw,se,s,s,sw,sw,sw,sw,s,sw,s,s,sw,s,s,s,sw,s,sw,s,s,sw,sw,sw,sw,nw,nw,sw,ne,sw,sw,s,sw,s,sw,sw,nw,sw,sw,sw,sw,sw,s,s,sw,sw,sw,sw,n,nw,s,se,n,s,s,s,s,sw,sw,n,s,sw,sw,ne,s,sw,nw,nw,s,s,sw,s,s,sw,sw,sw,sw,sw,se,nw,s,s,sw,ne,s,ne,n,sw,s,s,s,n,s,s,s,sw,ne,sw,sw,ne,sw,s,s,sw,sw,sw,sw,sw,s,sw,s,s,sw,sw,n,sw,s,s,sw,s,s,s,sw,s,s,ne,s,s,sw,sw,s,s,sw,sw,s,sw,sw,s,sw,nw,n,s,ne,s,sw,s,s,sw,sw,s,s,sw,sw,sw,sw,s,sw,s,s,s,s,sw,s,sw,s,sw,sw,ne,sw,s,s,sw,sw,sw,s,s,sw,nw,s,s,s,s,sw,s,s,sw,sw,sw,s,s,s,nw,s,s,s,s,sw,s,s,s,s,sw,s,s,sw,s,s,sw,s,se,nw,s,s,s,sw,s,sw,sw,n,s,sw,s,se,sw,s,s,s,s,nw,sw,s,nw,s,nw,nw,se,s,s,s,s,se,sw,s,ne,n,nw,sw,sw,s,sw,s,s,sw,sw,se,s,sw,se,s,s,ne,s,s,s,sw,sw,sw,s,sw,se,s,s,s,s,s,n,s,se,s,s,s,s,s,s,se,sw,sw,sw,s,s,s,s,s,sw,s,s,n,sw,se,n,s,sw,s,nw,sw,sw,s,nw,sw,s,s,s,s,s,s,s,nw,sw,sw,sw,nw,n,s,s,s,s,s,s,nw,s,s,s,s,s,s,s,sw,s,s,sw,sw,se,sw,s,se,s,s,s,s,sw,sw,s,se,sw,s,s,s,nw,s,s,s,sw,s,sw,sw,s,sw,s,sw,se,s,sw,sw,s,s,nw,s,sw,sw,sw,s,s,s,s,s,s,sw,nw,s,n,s,ne,sw,s,s,s,s,ne,s,s,s,s,s,s,se,s,n,s,sw,ne,s,nw,sw,s,s,s,nw,s,ne,n,s,s,ne,nw,s,s,s,ne,s,s,se,sw,ne,s,s,s,s,sw,s,s,s,s,s,sw,sw,sw,nw,se,s,n,s,s,s,s,s,nw,s,s,s,sw,nw,s,s,s,s,s,s,s,sw,sw,ne,s,se,s,n,ne,s,s,s,s,s,s,s,se,s,s,s,n,s,s,s,sw,s,nw,s,s,s,s,nw,ne,s,se,n,s,s,s,s,s,nw,sw,s,s,s,s,ne,s,sw,s,s,sw,s,s,s,s,sw,s,s,s,s,s,n,s,s,s,s,n,s,sw,s,s,s,s,s,s,s,ne,s,sw,se,s,sw,sw,s,s,s,s,n,s,sw,s,sw,s,n,s,s,s,se,s,s,s,s,s,s,ne,sw,s,s,s,s,nw,n,nw,s,s,s,s,s,s,s,s,s,s,s,ne,s,s,s,s,s,nw,s,s,se,s,s,s,s,s,s,s,s,n,s,n,nw,s,ne,s,nw,s,s,s,n,s,s,s,s,nw,s,s,s,sw,s,s,s,sw,ne,sw,nw,nw,se,s,s,s,s,se,s,s,s,sw,s,nw,s,s,s,s,s,n,ne,s,s,s,s,s,s,s,s,nw,s,sw,s,ne,s,s,s,s,s,s,s,s,nw,s,n,nw,s,s,s,s,s,s,s,s,s,n,ne,nw,s,s,s,s,n,s,s,s,s,s,s,s,s,s,s,s,s,s,s,s,s,s,nw,s,s,sw,ne,ne,s,s,se,s,s,s,nw,s,n,s,s,s,s,s,s,s,n,s,s,s,s,s,sw,s,nw,s,s,s,s,s,se,n,s,ne,s,s,se,n,s,s,s,s,s,s,s,s,s,ne,s,sw,s,s,se,nw,n,s,s,s,s,s,s,s,se,s,s,s,sw,s,sw,s,s,s,s,s,sw,s,s,se,sw,s,nw,s,sw,s,s,s,s,s,s,s,s,s,s,s,se,s,sw,s,n,s,ne,s,n,s,sw,sw,s,s,s,s,sw,n,s,s,s,se,s,s,s,s,s,s,s,s,s,s,s,s,s,s,ne,sw,ne,s,ne,s,s,nw,s,ne,s,s,s,s,s,s,s,se,sw,se,s,se,nw,s,nw,se,s,s,s,s,n,s,s,s,se,s,s,s,s,s,s,s,s,se,s,s,s,s,s,s,s,se,s,sw,s,s,s,s,s,nw,s,s,s,s,sw,s,s,s,s,s,s,n,s,se,s,se,ne,se,se,s,nw,se,s,s,s,n,s,s,s,nw,sw,s,s,se,ne,s,s,s,s,s,s,se,sw,s,s,s,s,n,sw,s,s,s,se,s,s,se,s,s,se,s,s,se,s,s,s,s,s,s,nw,s,se,s,s,ne,se,sw,s,se,s,sw,s,sw,s,s,sw,se,s,s,s,s,se,s,s,s,se,s,se,s,se,s,s,n,n,s,sw,n,s,se,s,s,s,s,s,s,s,s,s,s,s,se,s,se,s,s,nw,se,s,s,se,se,se,se,s,nw,sw,se,s,se,s,ne,se,s,sw,s,s,s,s,s,s,ne,s,s,se,s,n,s,s,se,s,s,ne,se,s,s,se,nw,s,se,s,s,s,n,nw,sw,se,s,s,s,s,s,s,s,n,s,s,s,s,s,nw,se,se,s,s,s,s,s,n,s,se,se,s,sw,s,s,s,s,se,se,s,s,s,s,s,nw,s,s,s,ne,s,sw,n,s,s,s,s,s,n,s,se,se,ne,s,s,s,s,se,se,sw,n,s,s,se,s,s,n,se,s,s,s,se,s,s,n,se,se,nw,nw,s,s,s,s,s,s,n,ne,se,s,se,s,se,s,s,se,s,se,s,s,s,se,s,sw,s,s,sw,s,s,s,s,s,s,nw,se,s,se,s,s,s,s,n,ne,s,ne,nw,ne,s,s,s,nw,s,nw,se,nw,se,se,s,s,se,se,s,sw,se,se,se,s,sw,se,s,s,n,sw,s,s,se,s,s,s,s,se,s,n,se,se,s,se,se,s,s,s,se,s,se,s,s,sw,s,s,nw,s,s,s,s,s,se,se,se,se,s,s,sw,sw,s,s,s,se,se,s,se,se,s,s,s,se,s,s,se,s,se,se,s,se,nw,sw,s,s,sw,s,se,ne,n,s,s,ne,s,nw,nw,se,s,se,s,s,s,s,se,s,s,s,se,se,n,se,nw,s,s,se,s,se,se,ne,s,s,s,s,s,se,s,s,s,ne,se,ne,se,se,se,ne,sw,ne,s,s,se,s,s,s,s,se,s,se,s,s,nw,sw,se,s,s,s,se,s,se,s,s,s,n,se,sw,se,se,s,se,s,se,s,se,se,se,se,s,s,n,s,nw,se,se,se,s,se,s,nw,s,sw,s,sw,sw,se,s,se,s,s,s,se,s,s,s,n,se,se,s,se,n,se,s,se,se,se,se,s,s,s,se,se,se,nw,se,s,se,s,s,se,nw,n,s,se,ne,ne,se,se,se,se,s,se,se,ne,s,s,se,ne,se,s,se,se,se,s,se,se,s,n,se,se,se,s,se,n,se,se,se,s,s,se,s,s,se,s,se,nw,s,s,n,nw,se,se,se,se,s,se,se,se,se,se,se,se,se,se,s,s,n,se,se,se,sw,nw,s,s,s,se,se,s,se,s,s,se,ne,ne,s,se,nw,s,s,ne,sw,n,s,nw,s,se,s,s,sw,s,s,se,s,s,se,ne,se,s,sw,se,se,se,se,se,nw,se,s,nw,n,se,ne,se,se,s,se,s,se,s,se,s,s,s,se,se,n,ne,se,s,ne,n,n,se,s,s,s,s,se,s,sw,se,se,s,sw,s,nw,se,s,s,s,se,se,se,se,nw,s,s,se,se,se,se,s,s,se,se,s,se,s,sw,s,s,se,s,s,s,sw,s,n,s,s,se,n,se,s,se,se,se,se,se,s,nw,se,s,s,se,nw,s,s,s,ne,s,s,se,se,ne,se,nw,se,se,n,se,s,se,n,s,s,se,s,s,s,se,s,se,s,se,se,se,se,se,se,se,s,se,se,n,sw,s,s,se,n,se,se,se,s,se,se,se,se,se,se,se,s,s,s,n,nw,se,se,sw,s,ne,nw,se,se,se,se,se,ne,se,sw,s,s,se,se,se,s,s,s,se,se,ne,s,s,s,se,n,se,sw,se,ne,se,se,se,s,se,se,nw,s,se,se,se,s,s,s,se,se,se,se,ne,se,s,se,n,s,se,sw,s,nw,sw,n,s,se,se,se,se,se,se,s,se,se,nw,se,nw,se,se,n,se,se,se,se,se,se,se,se,s,se,se,sw,se,s,se,n,sw,se,s,se,se,ne,se,se,nw,s,n,n,se,s,se,se,s,s,se,se,se,ne,se,se,se,se,s,ne,s,se,se,s,se,s,s,se,se,se,nw,se,nw,se,n,se,s,se,sw,se,se,se,se,s,se,se,se,se,se,se,se,se,s,se,nw,se,se,sw,s,sw,s,se,s,se,se,se,se,se,ne,se,s,se,se,se,ne,s,sw,n,n,s,se,se,se,se,se,se,s,s,se,ne,se,s,se,se,s,n,se,se,se,se,s,se,se,ne,se,se,se,se,se,se,s,s,se,se,se,s,ne,se,se,s,se,se,se,se,se,s,se,se,se,se,s,nw,se,se,se,s,s,se,s,se,se,se,se,nw,se,se,se,sw,n,se,n,se,nw,se,se,se,se,n,s,se,sw,se,s,se,ne,se,s,se,se,se,sw,se,se,nw,sw,s,se,se,s,se,se,se,s,se,se,se,nw,se,se,se,s,se,se,se,se,nw,ne,sw,se,se,se,se,se,se,s,se,se,s,se,s,se,se,se,se,se,n,se,se,se,se,se,se,nw,s,se,se,sw,nw,se,se,s,se,se,se,se,se,se,se,s,se,s,se,se,ne,se,se,se,se,nw,s,se,se,se,ne,sw,se,s,nw,se,s,se,se,se,se,ne,se,se,se,se,s,se,se,se,se,se,se,se,se,sw,s,nw,se,se,se,se,se,se,sw,n,se,se,se,ne,se,se,sw,se,se,ne,s,se,se,se,se,se,sw,se,se,se,se,se,n,se,se,se,se,se,se,se,se,se,se,se,sw,se,se,n,se,se,se,se,se,se,se,s,se,se,se,se,sw,s,n,se,ne,se,se,se,se,nw,se,se,se,n,nw,se,se,se,se,se,se,se,se,se,n,se,s,se,se,s,se,se,se,n,se,s,se,se,sw,se,se,se,nw,n,se,se,sw,se,se,se,se,nw,se,se,se,se,se,se,sw,ne,s,se,se,sw,sw,se,se,se,s,ne,se,se,se,se,se,n,ne,sw,sw,nw,nw,nw,nw,n,s,n,n,n,n,nw,sw,n,n,n,n,ne,ne,ne,ne,ne,ne,ne,se,se,ne,se,ne,ne,se,ne,se,sw,se,se,s,nw,se,se,se,s,s,ne,n,se,nw,se,se,se,s,s,s,s,s,sw,sw,s,s,s,n,se,s,s,sw,s,ne,s,s,sw,sw,s,se,sw,s,s,sw,sw,s,sw,se,sw,nw,n,ne,s,sw,s,sw,sw,s,se,sw,sw,n,sw,sw,nw,sw,s,sw,n,s,s,se,sw,sw,ne,nw,nw,n,sw,se,sw,nw,sw,nw,nw,se,sw,nw,nw,nw,sw,sw,nw,nw,nw,nw,sw,nw,nw,s,nw,se,sw,n,nw,s,nw,sw,se,nw,se,nw,nw,nw,nw,se,nw,nw,nw,nw,nw,nw,nw,nw,nw,n,s,n,ne,ne,nw,nw,nw,nw,nw,n,nw,nw,ne,n,nw,s,nw,n,nw,n,n,sw,n,nw,n,nw,se,n,nw,n,n,nw,nw,nw,n,n,n,ne,n,ne,n,n,nw,n,nw,ne,n,n,se,ne,sw,n,s,sw,n,n,n,n,se,n,ne,nw,ne,n,sw,n,n,n,ne,ne,n,n,n,n,n,n,ne,sw,sw,nw,n,nw,n,ne,n,sw,nw,sw,n,ne,ne,ne,ne,s,s,ne,n,n,sw,n,n,n,n,n,n,ne,ne,nw,ne,ne,sw,ne,n,se,n,nw,ne,n,ne,ne,s,ne,ne,ne,sw,ne,ne,ne,n,ne,n,n,ne,ne,ne,ne,ne,n,ne,ne,n,ne,ne,ne,n,ne,ne,ne,ne,n,ne,ne,ne,ne,ne,ne,se,ne,ne,ne,ne,ne,nw,se,ne,ne,ne,ne,ne,ne,ne,ne,se,ne,ne,ne,ne,se,ne,nw,ne,nw,ne,s,ne,ne,ne,n,ne,ne,ne,ne,ne,ne,ne,se,n,ne,ne,se,s,ne,ne,ne,se,se,ne,ne,sw,ne,ne,ne,ne,nw,ne,ne,ne,ne,ne,ne,se,se,ne,se,se,sw,se,s,ne,se,se,se,ne,se,ne,sw,se,ne,ne,ne,se,ne,se,ne,se,ne,ne,ne,nw,s,se,se,se,se,ne,ne,se,se,ne,ne,ne,se,ne,se,ne,sw,se,se,ne,se,se,se,ne,se,se,se,se,ne,nw,se,se,se,se,se,se,se,s,se,nw,se,se,ne,sw,n,sw,se,se,s,se,se,ne,se,se,se,se,se,ne,n,se,se,se,sw,se,se,se,se,se,se,ne,se,se,s,se,se,se,ne,se,se,nw,ne,se,se,se,se,se,se,ne,s,se,se,se,se,s,nw,se,n,s,se,ne,se,se,se,se,se,s,se,s,se,sw,se,ne,se,s,se,s,sw,sw,ne,se,ne,nw,se,s,s,s,se,se,s,se,se,n,se,n,se,s,s,s,ne,ne,se,s,ne,ne,s,se,s,n,s,se,se,se,se,s,s,se,ne,nw,se,s,se,s,s,se,s,s,se,se,s,s,n,se,se,ne,se,n,n,s,s,s,nw,se,s,se,se,s,s,ne,se,sw,s,s,n,sw,s,s,se,s,s,se,s,se,sw,se,sw,s,s,n,se,s,s,sw,s,s,s,s,s,nw,s,n,s,s,se,se,se,s,s,s,s,nw,s,s,se,s,se,se,se,ne,n,s,s,s,nw,s,sw,sw,s,se,s,se,s,s,s,s,s,nw,nw,s,se,s,s,se,s,s,s,s,ne,s,s,s,s,s,s,s,s,s,s,s,ne,s,nw,s,s,s,s,s,s,s,ne,sw,s,s,s,s,s,s,s,s,s,s,s,s,s,s,se,s,s,s,s,s,s,nw,nw,s,ne,sw,sw,s,sw,sw,sw,s,n,s,s,s,s,s,nw,s,s,sw,s,sw,s,s,sw,s,s,sw,s,sw,s,s,s,s,s,sw,ne,s,sw,s,sw,s,s,s,s,se,s,sw,s,sw,s,se,sw,s,sw,s,sw,sw,n,s,s,sw,s,sw,se,s,sw,sw,sw,sw,s,sw,s,sw,s,sw,sw,sw,sw,sw,s,ne,s,sw,sw,sw,s,sw,s,s,sw,sw,sw,s,s,se,s,sw,sw,nw,s,s,sw,s,s,s,s,s,sw,n,sw,s,s,sw,nw,ne,sw,sw,sw,ne,s,sw,s,sw,n,sw,sw,s,sw,n,s,sw,s,n,sw,sw,se,sw,sw,se,n,s,sw,sw,sw,s,sw,sw,sw,se,sw,sw,ne,sw,s,sw,s,sw,sw,sw,sw,s,s,sw,sw,s,n,sw,ne,sw,sw,se,n,sw,sw,s,sw,sw,sw,se,sw,s,sw,s,s,sw,sw,s,sw,sw,s,sw,sw,sw,sw,sw,sw,sw,sw,sw,nw,s,sw,sw,ne,se,se,sw,sw,sw,sw,sw,nw,sw,sw,sw,s,sw,sw,s,sw,n,sw,sw,ne,sw,sw,sw,sw,ne,sw,sw,sw,s,sw,s,nw,sw,sw,sw,nw,sw,sw,sw,n,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,sw,s,sw,ne,sw,sw,ne,sw,sw,n,sw,sw,sw,sw,sw,se,sw,s,sw,se,sw,sw,sw,sw,sw,sw,sw,sw,sw,ne,nw,sw,sw,sw,sw,sw,sw,sw,sw,se,sw,se,sw,sw,sw,sw,se,n,se,sw,s,sw,sw,s,n,n,sw,sw,sw,ne,sw,nw,sw,nw,sw,nw,sw,sw,nw,sw,sw,sw,sw,sw,sw,sw,sw,sw,nw,sw,sw,sw,sw,sw,s,nw,sw,nw,sw,sw,sw,se,sw,sw,sw,sw,sw,sw,sw,s,sw,nw,nw,sw,sw,nw,s,s,s,sw,sw,nw,nw,ne,sw,nw,n,nw,sw,nw,se,nw,nw,sw,sw,n,sw,sw,se,sw,sw,nw,sw,sw,ne,sw,se,sw,ne,nw,ne,n,nw,sw,sw,sw,sw,nw,sw,sw,sw,nw,sw,sw,sw,sw,sw,sw,nw,sw,nw,ne,n,n,sw,sw,sw,sw,nw,se,nw,sw,nw,sw,sw,nw,nw,sw,nw,sw,ne,nw,sw,nw,nw,nw,nw,se,nw,sw,sw,nw,sw,nw,n,nw,nw,nw,nw,sw,ne,ne,nw,sw,nw,ne,nw,nw,s,sw,nw,nw,sw,sw,nw,sw,sw,nw,ne,sw,sw,se,sw,nw,nw,nw,sw,se,sw,ne,nw,sw,nw,sw,se,nw,nw,sw,ne,nw,ne,nw,nw,ne,sw,sw,se,nw,sw,nw,nw,nw,ne,sw,nw,nw,nw,sw,nw,s,s,nw,nw,s,n,sw,nw,s,se,sw,sw,se,nw,sw,nw,nw,sw,ne,n,nw,nw,sw,nw,nw,nw,nw,sw,sw,s,n,nw,sw,sw,n,nw,nw,nw,nw,s,nw,nw,nw,n,nw,sw,nw,nw,n,sw,nw,sw,sw,sw,n,nw,se,sw,sw,nw,nw,nw,ne,nw,se,ne,nw,se,nw,nw,sw,nw,nw,nw,se,nw,nw,nw,nw,nw,nw,nw,nw,nw,n,nw,nw,sw,nw,nw,sw,nw,nw,sw,nw,s,n,nw,nw,nw,nw,nw,nw,nw,nw,ne,sw,n,nw,sw,nw,nw,nw,nw,nw,ne,nw,nw,n,nw,nw,nw,nw,nw,nw,n,nw,nw,nw,s,nw,sw,ne,s,sw,nw,se,nw,nw,se,sw,nw,n,sw,ne,nw,nw,nw,nw,sw,nw,nw,nw,s,n,nw,nw,nw,nw,sw,nw,nw,nw,nw,nw,nw,nw,se,se,nw,nw,s,se,n,nw,nw,nw,nw,nw,nw,sw,nw,se,nw,nw,ne,nw,nw,nw,nw,n,nw,nw,nw,nw,n,nw,ne,nw,nw,s,n,nw,nw,nw,n,nw,n,s,nw,nw,s,nw,nw,nw,nw,nw,n,nw,nw,nw,nw,ne,nw,nw,nw,nw,nw,sw,nw,n,n,sw,n,nw,s,nw,nw,nw,nw,ne,se,nw,s,n,nw,ne,nw,nw,nw,nw,nw,ne,n,sw,se,nw,nw,nw,nw,s,n,n,nw,nw,se,nw,nw,se,nw,n,n,nw,nw,nw,nw,nw,nw,sw,nw,nw,nw,nw,ne,ne,n,sw,nw,s,nw,nw,n,nw,nw,n,nw,sw,n,nw,ne,se,nw,nw,nw,nw,nw,n,se,n,ne,nw,n,sw,nw,nw,n,nw,n,ne,nw,sw,n,nw,nw,nw,ne,nw,nw,nw,nw,n,nw,n,nw,nw,n,nw,nw,nw,nw,nw,nw,nw,n,nw,nw,nw,n,nw,nw,nw,nw,nw,nw,nw,nw,nw,s,nw,n,n,n,s,nw,nw,nw,s,n,n,sw,nw,ne,n,n,nw,s,nw,nw,n,nw,ne,nw,s,nw,nw,n,n,sw,nw,nw,n,nw,nw,nw,sw,nw,n,nw,nw,nw,nw,nw,nw,nw,ne,n,nw,n,n,n,n,n,nw,nw,nw,sw,nw,n,nw,s,n,ne,nw,n,n,n,n,se,nw,n,sw,n,n,n,nw,n,nw,s,nw,n,nw,nw,n,s,nw,nw,sw,ne,n,n,n,n,n,n,n,nw,nw,n,n,nw,s,n,nw,nw,n,n,n,nw,ne,n,nw,n,se,n,se,se,n,nw,n,n,n,se,n,se,nw,n,nw,n,n,nw,n,ne,sw,ne,n,n,n,n,n,n,n,sw,ne,n,nw,n,ne,sw,n,n,nw,n,n,n,nw,n,n,n,nw,sw,n,n,nw,s,n,n,sw,n,nw,n,nw,nw,n,n,n,n,n,n,s,n,n,nw,nw,n,n,n,n,nw,s,n,s,sw,n,ne,nw,sw,sw,n,n,nw,n,nw,n,n,n,s,s,nw,n,sw,n,sw,s,nw,n,n,n,n,sw,n,nw,n,ne,sw,n,se,nw,n,n,ne,s,n,nw,n,n,nw,n,n,n,n,nw,n,n,n,s,ne,nw,n,n,n,se,n,n,n,sw,n,sw,nw,n,n,n,sw,n,n,n,n,n,sw,n,n,n,ne,ne,ne,n,n,n,n,n,nw,n,nw,n,s,n,sw,n,n,n,n,n,n,n,se,s,n,n,nw,nw,n,nw,nw,n,n,n,n,s,n,sw,n,n,n,n,ne,sw,n,n,n,n,n,n,n,se,ne,n,n,se,nw,n,n,n,n,n,sw,se,ne,n,n,s,n,n,n,n,n,n,n,n,nw,s,n,n,n,nw,n,n,n,n,n,n,n,n,n,nw,nw,nw,ne,n,n,se,n,n,nw,n,n,n,n,n,n,se,n,n,n,n,n,n,n,n,n,n,nw,n,n,n,sw,ne,n,n,n,s,n,n,s,n,sw,n,n,n,n,n,n,nw,n,n,ne,n,sw,n,n,n,n,s,n,n,n,n,n,n,nw,n,s,n,n,n,ne,ne,n,n,n,se,n,s,n,nw,n,nw,se,n,ne,ne,n,sw,nw,se,n,n,n,se,s,n,n,n,nw,n,n,ne,n,n,n,n,n,n,se,n,n,s,n,se,ne,n,n,ne,n,ne,n,sw,n,n,n,n,ne,n,n,n,ne,n,nw,n,n,n,n,n,ne,n,n,ne,ne,ne,ne,n,n,n,n,ne,n,n,n,n,ne,n,ne,n,n,sw,sw,n,se,ne,n,se,ne,n,ne,se,ne,n,n,ne,se,nw,ne,n,n,sw,n,n,n,nw,n,n,s,s,n,se,n,n,n,n,n,ne,ne,n,n,n,ne,n,n,n,ne,ne,nw,n,n,ne,n,ne,ne,n,n,n,ne,n,sw,sw,ne,n,n,n,n,n,ne,n,sw,n,n,nw,n,ne,s,n,n,n,n,n,n,ne,n,n,sw,ne,n,n,n,se,n,ne,ne,n,se,ne,n,n,n,ne,se,sw,n,ne,n,ne,n,se,n,n,se,n,ne,n,ne,sw,ne,s,ne,n,s,ne,se,ne,se,ne,sw,n,ne,n,n,nw,ne,n,nw,n,nw,n,ne,n,n,ne,n,n,n,ne,ne,nw,n,ne,s,n,n,n,n,n,n,ne,ne,n,ne,nw,ne,n,n,ne,ne,sw,ne,ne,n,n,ne,ne,n,ne,n,ne,ne,n,ne,ne,n,n,ne,n,se,ne,n,se,n,s,s,n,ne,n,n,ne,ne,ne,ne,ne,n,nw,nw,ne,n,sw,n,n,ne,n,ne,ne,n,ne,se,s,s,nw,sw,ne,ne,sw,se,ne,ne,ne,ne,ne,sw,n,ne,ne,n,ne,ne,n,sw,n,sw,ne,ne,n,s,ne,ne,nw,n,ne,ne,ne,n,ne,ne,s,s,ne,n,ne,ne,n,ne,ne,n,nw,ne,se,n,nw,n,n,n,s,n,ne,ne,ne,n,n,n,n,n,ne,s,ne,n,n,ne,ne,se,ne,n,ne,n,ne,ne,n,nw,nw,n,n,ne,ne,ne,n,se,ne,n,ne,s,n,n,n,ne,ne,ne,ne,n,ne,ne,ne,ne,se,nw,ne,se,ne,n,ne,ne,ne,se,nw,ne,n,n,ne,sw,n,ne,ne,ne,ne,s,ne,ne,ne,s,ne,nw,ne,n,ne,n,ne,ne,ne,ne,ne,n,ne,ne,nw,ne,nw,n,se,n,n,n,n,ne,n,n,ne,sw,n,ne,n,n,n,ne,nw,ne,sw,n,n,sw,ne,ne,n,ne,sw,ne,s,ne,ne,n,nw,s,s,ne,ne,ne,sw,ne,ne,ne,ne,ne,ne,ne,sw,ne,n,ne,ne,ne,ne,ne,ne,se,ne,ne,nw,nw,ne,n,sw,n,s,ne,ne,n,n,n,ne,ne,s,ne,nw,ne,ne,ne,n,ne,ne,s,ne,n,ne,sw,s,ne,ne,n,n,n,sw,ne,n,nw,ne,ne,ne,ne,ne,s,ne,ne,ne,sw,se,ne,ne,ne,se,ne,ne,ne,ne,ne,ne,s,ne,ne,ne,n,ne,ne,ne,ne,n,n,ne,sw,ne,n,ne,sw,ne,ne,ne,se,ne,n,ne,ne,n,ne,n,ne,ne,n,n,ne,n,ne,sw,s,ne,ne,ne,s,ne,ne,ne,s,ne,ne,ne,nw,nw,se,ne,n,ne,ne,ne,ne,n,ne,ne,ne,ne,ne,ne,se,s,sw,ne,ne,ne,ne,ne,nw,n,ne,ne,ne,ne,n,ne,ne,n,ne,se,ne,n,ne,ne,ne,nw,nw,ne,ne,ne,sw,ne,ne,sw,n,ne,ne,n,n,ne,ne,ne,ne,n,ne,ne,ne,ne,n,sw,ne,ne,ne,ne,ne,ne,sw,ne,ne,ne,ne,ne,ne,nw,nw,ne,n,ne,s,ne,ne,ne,sw,ne,ne,ne,ne,n,ne,ne,ne,ne,ne,ne,ne,ne,ne"