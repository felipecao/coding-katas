package com.github.felipecao.katas.gossip

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{Matchers, FlatSpec}
import org.mockito.Mockito._

class ClockTest extends FlatSpec with Matchers with MockitoSugar {

  "ClockTest#tick" should "notifies all drivers" in {
    val d1 = mock[Driver]
    val d2 = mock[Driver]
    val d3 = mock[Driver]

    val clock = new Clock(new Drivers(Seq(d1, d2, d3)))

    clock.tick()

    verify(d1).timeWindowChangeIsFinished()
    verify(d1).timeWindowChangeHasStarted()
    verify(d2).timeWindowChangeIsFinished()
    verify(d2).timeWindowChangeHasStarted()
    verify(d3).timeWindowChangeIsFinished()
    verify(d3).timeWindowChangeHasStarted()
  }

  "ClockTest#isTimeUp" should "be false until clock has ticked 480 times" in {
    val clock = new Clock(new Drivers(Seq(mock[Driver])))

    clock.isTimeUp() should be (false)

    for( counter <- 0 to 480){
      clock.isTimeUp() should be (false)
      clock.tick()
    }

    clock.isTimeUp() should be (true)

  }
}
