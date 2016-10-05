package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

class DriversTest extends FlatSpec with Matchers {

  "Drivers#get" should "return the proper driver from the collection" in {
    val collection = Seq(
      new Driver(Route(Seq(1))),
      new Driver(Route(Seq(1, 2))),
      new Driver(Route(Seq(1, 3)))
    )

    val drivers = new Drivers(collection)

    collection(0) shouldBe (drivers.get(0))
  }

}
