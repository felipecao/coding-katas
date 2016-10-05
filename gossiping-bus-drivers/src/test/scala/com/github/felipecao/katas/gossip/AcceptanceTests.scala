package com.github.felipecao.katas.gossip

import org.scalatest.{BeforeAndAfter, Matchers, FlatSpec}

import scala.util.Random

class AcceptanceTests extends FlatSpec with Matchers with BeforeAndAfter {

  private var solution = Option.empty[Solution]

  before {
    solution = Some(new Solution)
  }

  private val NEVER: String = "never"

  def getOutputForRoutesCollection(routesCollection: Seq[Seq[Int]]): String = {

    solution.get.getOutputForRoutesCollection(routesCollection)
  }

  "A collection of routes with just one driver" should "output 'never' regardless of the number of stops" in {
    def routesCollection = Seq(Seq.fill(Random.nextInt(100))(Random.nextInt(100)))
    def output = getOutputForRoutesCollection(routesCollection)

    output shouldBe NEVER
  }

  "A collection of routes with two drivers with one stop where both have the same stop" should "output '1'" in {
    val busStop = 1
    def routesCollection = Seq(Seq(busStop), Seq(busStop))
    def output = getOutputForRoutesCollection(routesCollection)

    output shouldBe "1"
  }

  "A collection of routes with two drivers with one stop where they don't have the same stop" should "output 'never'" in {
    def routesCollection = Seq(Seq(1), Seq(2))
    def output = getOutputForRoutesCollection(routesCollection)

    output shouldBe NEVER
  }

  "A collection of routes with two drivers with two stops where both start at the same stop" should "output '1'" in {
    val busStop = 1
    def routesCollection = Seq(Seq(busStop, Random.nextInt()), Seq(busStop, Random.nextInt()))
    def output = getOutputForRoutesCollection(routesCollection)

    output shouldBe "1"
  }

  "A collection of routes with two drivers with two stops where they don't have a stop in common" should "output 'never'" in {
    def routesCollection = Seq(Seq(1, 2), Seq(3, 4))
    def output = getOutputForRoutesCollection(routesCollection)

    output shouldBe NEVER
  }

  "A collection of routes with 3 drivers with two stops where they have the last stop in common" should "output '2'" in {
    val lastStop = 2
    def routesCollection = Seq(
      Seq(1, lastStop),
      Seq(3, lastStop),
      Seq(5, lastStop)
    )
    def output = getOutputForRoutesCollection(routesCollection)

    output shouldBe "2"
  }

  "A collection of routes with 3 drivers with two stops where they have one stop in common and it's not the last stop" should "output 'never'" in {
    val stopInCommon = 2
    def routesCollection = Seq(
      Seq(1, stopInCommon),
      Seq(stopInCommon, 3),
      Seq(5, stopInCommon)
    )
    def output = getOutputForRoutesCollection(routesCollection)

    output shouldBe NEVER
  }

  "A collection of routes with 3 drivers with different route sizes where the first never meets the third" should "output 'never'" in {
    def routesCollection = Seq(
      Seq(5, 2),
      Seq(5, 6, 4),
      Seq(8, 6, 3, 8)
    )
    def output = getOutputForRoutesCollection(routesCollection)

    output shouldBe NEVER
  }

  "A collection of routes with 3 drivers with different route sizes where the first meets the second again" should "output '3'" in {
    def routesCollection = Seq(
      Seq(5, 2, 4),
      Seq(5, 6, 4),
      Seq(8, 6, 3, 8)
    )
    def output = getOutputForRoutesCollection(routesCollection)

    output shouldBe "3"
  }

}
