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

    verify(d1).clockHasTicked()
    verify(d2).clockHasTicked()
    verify(d3).clockHasTicked()

  }
}
