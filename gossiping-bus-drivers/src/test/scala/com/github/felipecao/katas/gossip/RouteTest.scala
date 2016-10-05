package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

class RouteTest extends FlatSpec with Matchers {

  "Route#totalStops" should "return the number of stops contained in the route" in {
    val route = Route(Seq(1, 2, 3))

    route.totalStops should be (3)
  }

  "Route#lastStop" should "return the last stop contained in the route" in {
    val route = Route(Seq(1, 2, 3))

    route.lastStop should be (3)
  }

  "Route#firstStop" should "return the first stop contained in the route" in {
    val route = Route(Seq(1, 2, 3))

    route.firstStop should be (1)
  }
}
