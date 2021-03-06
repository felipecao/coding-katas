package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

class DriversFactoryTest extends FlatSpec with Matchers {

  "DriversFactory" should "build a collection of one driver with one route" in {
    def routesCollection = Seq(Seq(1))
    def drivers = DriverFactory.buildDriversFromRoutesCollection(routesCollection)

    drivers.count should be (1)
  }

  "DriversFactory" should "build a collection of two drivers with one route each" in {
    def routesCollection = Seq(Seq(1), Seq(2))
    def drivers = DriverFactory.buildDriversFromRoutesCollection(routesCollection)

    drivers.count should be (2)
  }

  "DriversFactory" should "build a collection of two drivers with two routes each" in {
    def routesCollection = Seq(Seq(1, 2), Seq(2, 1))
    def drivers = DriverFactory.buildDriversFromRoutesCollection(routesCollection)

    drivers.count should be (2)
  }

}
