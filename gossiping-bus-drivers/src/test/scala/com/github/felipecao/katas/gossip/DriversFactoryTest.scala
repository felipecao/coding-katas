package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

class DriversFactoryTest extends FlatSpec with Matchers {

  "DriversFactory" should "build a collection of one driver with one route" in {
    def routesCollection = Seq(Seq(1))
    def drivers = DriverFactory.buildFromRoutesCollection(routesCollection)

    drivers.count should be (1)
    drivers.allDrivers should be (Seq(Driver(Route(Seq(1)))))
  }
}
