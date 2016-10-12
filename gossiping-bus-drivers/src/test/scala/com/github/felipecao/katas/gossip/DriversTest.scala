package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

class DriversTest extends FlatSpec with Matchers {

  "Drivers#get" should "return the proper driver from the collection" in {
    val collection = Seq(
      new Driver(new Route(Seq(Stop(1)))),
      new Driver(new Route(Seq(Stop(1), Stop(2)))),
      new Driver(new Route(Seq(Stop(1), Stop(3))))
    )

    val drivers = new Drivers(collection)

    Some(collection(0)) shouldBe (drivers.get(0))
  }

  "Drivers#get" should "return empty for a non-existing index" in {
    val collection = Seq(
      new Driver(new Route(Seq(Stop(1)))),
      new Driver(new Route(Seq(Stop(1), Stop(2)))),
      new Driver(new Route(Seq(Stop(1), Stop(3))))
    )

    val drivers = new Drivers(collection)

    Option.empty[Driver] shouldBe (drivers.get(3))
  }

  "Drivers#first" should "return empty for an empty collection" in {
    val drivers = new Drivers(Seq())

    Option.empty[Driver] shouldBe (drivers.first)
  }

}
