package com.github.felipecao.katas.gossip

import org.scalatest.{BeforeAndAfter, Matchers, FlatSpec}

import scala.util.Random

class AcceptanceTests extends FlatSpec with Matchers with BeforeAndAfter {

  private var solution = Option.empty[Solution]

  before {
    solution = Some(new Solution)
  }

  "A collection of routes with just one driver" should "output 'never' regardless of the number of stops" in {
    def routesCollection = Seq(Seq.fill(Random.nextInt(100))(Random.nextInt(100)))
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe Solution.NEVER
  }

  "A collection of routes with two drivers with one stop where both have the same stop" should "output '1'" in {
    val busStop = 1
    def routesCollection = Seq(Seq(busStop), Seq(busStop))
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe "1"
  }

  "A collection of routes with two drivers with one stop where they don't have the same stop" should "output 'never'" in {
    def routesCollection = Seq(Seq(1), Seq(2))
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe Solution.NEVER
  }

  "A collection of routes with two drivers with two stops where both start at the same stop" should "output '1'" in {
    val busStop = 1
    def routesCollection = Seq(Seq(busStop, Random.nextInt()), Seq(busStop, Random.nextInt()))
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe "1"
  }

  "A collection of routes with two drivers with two stops where they don't have a stop in common" should "output 'never'" in {
    def routesCollection = Seq(Seq(1, 2), Seq(3, 4))
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe Solution.NEVER
  }

  "A collection of routes with 3 drivers with two stops where they have the last stop in common" should "output '2'" in {
    val lastStop = 2
    def routesCollection = Seq(
      Seq(1, lastStop),
      Seq(3, lastStop),
      Seq(5, lastStop)
    )
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe "2"
  }

  "A collection of routes with 3 drivers with two stops where they have one stop in common and it's not the last stop" should "output 'never'" in {
    val stopInCommon = 2
    def routesCollection = Seq(
      Seq(1, stopInCommon),
      Seq(stopInCommon, 3),
      Seq(5, stopInCommon)
    )
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe Solution.NEVER
  }

  "A collection of routes with 3 drivers with different route sizes where the first never meets the third" should "output '7'" in {
    def routesCollection = Seq(
      Seq(5, 2),
      Seq(5, 6, 4),
      Seq(8, 6, 3, 8)
    )
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe "7"
  }

  "A collection of routes with 3 drivers with different route sizes where drivers only meet at station 3" should "output '5'" in {
    def routesCollection = Seq(
      Seq(3, 1, 2, 3),
      Seq(3, 2, 3, 1),
      Seq(4, 2, 3, 4, 5)
    )
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe "5"
  }

  "Example 1" should "output '5'" in {
    def routesCollection = Seq(
      Seq(5, 2, 4),
      Seq(5, 6, 4),
      Seq(8, 6, 3, 8)
    )
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe "3"
  }

  "Example 2" should "output 'never'" in {
    def routesCollection = Seq(
      Seq(2, 1, 2),
      Seq(5, 2, 8)
    )
    def output = solution.get.timeToSpreadAllGossips(routesCollection)

    output shouldBe Solution.NEVER
  }

}
