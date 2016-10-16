package com.github.felipecao.katas.gossip

import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{Matchers, FlatSpec}

class DriverTest extends FlatSpec with Matchers with MockitoSugar {

  "Driver#clockHasTicked" should "tell the current stop he's left and tell the next stop he's arrived" in {
    val stop1 = mock[Stop]
    val stop2 = mock[Stop]
    val stop3 = mock[Stop]
    val driver = new Driver(new Route(Seq(stop1, stop2, stop3)))

    driver.timeWindowChangeIsFinished()
    verify(stop1).depart(driver)
    verify(stop2).arrive(driver)

    driver.timeWindowChangeIsFinished()
    verify(stop2).depart(driver)
    verify(stop3).arrive(driver)

    driver.timeWindowChangeIsFinished()
    verify(stop2).depart(driver)
    verify(stop3).arrive(driver)

    driver.timeWindowChangeIsFinished()
    verify(stop3).depart(driver)
    verify(stop1, times(2)).arrive(driver)

    driver.timeWindowChangeIsFinished()
    verify(stop1, times(2)).depart(driver)
    verify(stop2, times(2)).arrive(driver)
  }

  "Driver#totalGossips" should "begin with 1" in {
    val driver = new Driver(new Route(Seq(Stop(1), Stop(2), Stop(3))))

    driver.totalGossips should be (1)
  }

  "Driver#totalGossips" should "be 2 after exchanging 1 gossip with someone" in {
    val driver1 = new Driver(new Route(Seq(Stop(1), Stop(2), Stop(3))))
    val driver2 = new Driver(new Route(Seq(Stop(1), Stop(2), Stop(3))))

    driver1.exchangeGossip(driver2)

    driver1.totalGossips should be (2)
    driver2.totalGossips should be (1)
  }

  "Driver#allObserversHaveBeenNotified" should "ask the Stop who else is there and exchange gossips" in {
    val stop1 = mock[Stop]
    val stop2 = mock[Stop]
    val stop3 = mock[Stop]

    val driver1 = new Driver(new Route(Seq(stop1, stop2)))
    val driver2 = new Driver(new Route(Seq(stop1, stop3)))

    when(stop1.drivers()).thenReturn(Seq(driver1, driver2))
    when(stop2.drivers()).thenReturn(Seq.empty[Driver])
    when(stop3.drivers()).thenReturn(Seq.empty[Driver])

    driver1.timeWindowChangeHasStarted()
    driver2.timeWindowChangeHasStarted()

    driver1.timeWindowChangeIsFinished()
    driver2.timeWindowChangeIsFinished()

    verify(stop1, times(2)).drivers()

    driver1.totalGossips should be (2)
    driver2.totalGossips should be (2)
  }

}
