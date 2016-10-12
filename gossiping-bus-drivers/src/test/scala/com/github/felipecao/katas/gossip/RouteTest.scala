package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

class RouteTest extends FlatSpec with Matchers {

  "Route#totalStops" should "return the number of stops contained in the route" in {
    val route = new Route(Seq(Stop(1), Stop(2), Stop(3)))

    route.totalStops should be (3)
  }

  "Route#lastStop" should "return the last stop contained in the route" in {
    val route = new Route(Seq(Stop(1), Stop(2), Stop(3)))

    route.lastStop should be (Stop(3))
  }

  "Route#firstStop" should "return the first stop contained in the route" in {
    val route = new Route(Seq(Stop(1), Stop(2), Stop(3)))

    route.firstStop should be (Stop(1))
  }

  "Route#nextStop" should "keep returning the next stop in the route" in {
    val route = new Route(Seq(Stop(1), Stop(2), Stop(3)))

    route.firstStop should be (Stop(1))
    route.nextStop should be (Stop(2))
    route.nextStop should be (Stop(3))
    route.nextStop should be (Stop(1))
    route.nextStop should be (Stop(2))
    route.nextStop should be (Stop(3))
    route.nextStop should be (Stop(1))
  }
}
