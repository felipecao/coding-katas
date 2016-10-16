package com.github.felipecao.katas.gossip

import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{Matchers, FlatSpec}

class DriversTest extends FlatSpec with Matchers with MockitoSugar {

  "Drivers#allDriversHaveAllGossips" should "return true if the number of gossips of each driver matches the number of drivers" in {
    val driver1 = mock[Driver]
    val driver2 = mock[Driver]
    val driver3 = mock[Driver]

    when(driver1.totalGossips()).thenReturn(3)
    when(driver2.totalGossips()).thenReturn(3)
    when(driver3.totalGossips()).thenReturn(3)

    val drivers = new Drivers(Seq(driver1, driver2, driver3))

    drivers.everyoneHasAllGossips() shouldBe (true)
  }

  "Drivers#allDriversHaveAllGossips" should "return false if the number of gossips of each driver does not match the number of drivers" in {
    val driver1 = mock[Driver]
    val driver2 = mock[Driver]
    val driver3 = mock[Driver]

    when(driver1.totalGossips()).thenReturn(3)
    when(driver2.totalGossips()).thenReturn(2)
    when(driver3.totalGossips()).thenReturn(3)

    val drivers = new Drivers(Seq(driver1, driver2, driver3))

    drivers.everyoneHasAllGossips() shouldBe (false)
  }

}
