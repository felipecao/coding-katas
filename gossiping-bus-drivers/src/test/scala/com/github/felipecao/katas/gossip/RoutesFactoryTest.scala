package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

class RoutesFactoryTest extends FlatSpec with Matchers {

  "RoutesFactory" should "build a collection of one route with one stop" in {
    def routesCollection = Seq(Seq(1))
    def routes = RoutesFactory.buildFromRoutesCollection(routesCollection)

    routes should be (Seq(new Route(Seq(Stop(1)))))
  }

  "RoutesFactory" should "build a collection of two routes with one stop each" in {
    def routesCollection = Seq(Seq(1), Seq(2))
    def routes = RoutesFactory.buildFromRoutesCollection(routesCollection)

    routes should be (Seq(
      new Route(Seq(Stop(1))),
      new Route(Seq(Stop(2)))
    ))
  }

  "RoutesFactory" should "build a collection of two routes with two stops each" in {
    def routesCollection = Seq(Seq(1, 2), Seq(2, 1))
    def routes = RoutesFactory.buildFromRoutesCollection(routesCollection)
    def stop1 = Stop(1)
    def stop2 = Stop(2)

    routes should be (Seq(
      new Route(Seq(stop1, stop2)),
      new Route(Seq(stop2, stop1))
    ))
  }
}
