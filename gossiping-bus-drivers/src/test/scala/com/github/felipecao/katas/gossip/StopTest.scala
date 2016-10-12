package com.github.felipecao.katas.gossip

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{Matchers, FlatSpec}

class StopTest extends FlatSpec with Matchers with MockitoSugar {

  "Driver#drivers" should "return empty at first" in {
    val stop = Stop(1)

    stop.drivers() should be (Seq.empty[Driver])
  }

  "Driver#drivers" should "return a driver that has arrived" in {
    val stop = Stop(1)
    val driver = mock[Driver]

    stop.arrive(driver)
    stop.drivers() should be (Seq(driver))
  }

  "Driver#drivers" should "return two drivers that have arrived" in {
    val stop = Stop(1)
    val driver1 = mock[Driver]
    val driver2 = mock[Driver]

    stop.arrive(driver1)
    stop.arrive(driver2)
    stop.drivers() should be (Seq(driver1, driver2))
  }

  "Driver#drivers" should "return one driver after one of them has departed" in {
    val stop = Stop(1)
    val driver1 = mock[Driver]
    val driver2 = mock[Driver]

    stop.arrive(driver1)
    stop.arrive(driver2)

    stop.depart(driver2)

    stop.drivers() should be (Seq(driver1))
  }

  "Driver#drivers" should "return one driver after one of them has departed in reverse order" in {
    val stop = Stop(1)
    val driver1 = mock[Driver]
    val driver2 = mock[Driver]

    stop.arrive(driver1)
    stop.arrive(driver2)

    stop.depart(driver1)

    stop.drivers() should be (Seq(driver2))
  }

  "Driver#drivers" should "return empty after all drivers have departed" in {
    val stop = Stop(1)
    val driver1 = mock[Driver]
    val driver2 = mock[Driver]

    stop.arrive(driver1)
    stop.arrive(driver2)

    stop.depart(driver1)
    stop.depart(driver2)

    stop.drivers() should be (Seq.empty[Driver])
  }

}
