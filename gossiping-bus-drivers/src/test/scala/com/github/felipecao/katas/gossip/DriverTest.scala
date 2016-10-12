package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

class DriverTest extends FlatSpec with Matchers {

  "Driver#totalStops" should "return the number of stops contained in a driver's route" in {
    val driver = new Driver(new Route(Seq(1, 2, 3)))

    driver.totalStops should be (3)
  }

  "Driver#lastStop" should "return the last stop driver's route" in {
    val driver = new Driver(new Route(Seq(1, 2, 3)))

    driver.lastStop should be (3)
  }

  "Driver#firstStop" should "return the first stop driver's route" in {
    val driver = new Driver(new Route(Seq(1, 2, 3)))

    driver.firstStop should be (1)
  }

  "Driver#currentStop" should "begin with the first stop on driver's route" in {
    val driver = new Driver(new Route(Seq(1, 2, 3)))

    driver.currentStop should be (1)
  }

  "Driver#clockHasTicked" should "move the driver to the next stop" in {
    val driver = new Driver(new Route(Seq(1, 2, 3)))

    driver.currentStop should be (1)

    driver.clockHasTicked()
    driver.currentStop should be (2)

    driver.clockHasTicked()
    driver.currentStop should be (3)

    driver.clockHasTicked()
    driver.currentStop should be (1)

    driver.clockHasTicked()
    driver.currentStop should be (2)
  }

  "Driver#allObserversHaveBeenNotified" should "ask the Stop who else is there and exchange gossips" in {
    val driver = new Driver(new Route(Seq(1, 2, 3)))

    driver.currentStop should be (1)

    driver.clockHasTicked()
    driver.currentStop should be (2)

    driver.clockHasTicked()
    driver.currentStop should be (3)

    driver.clockHasTicked()
    driver.currentStop should be (1)

    driver.clockHasTicked()
    driver.currentStop should be (2)
  }

}
