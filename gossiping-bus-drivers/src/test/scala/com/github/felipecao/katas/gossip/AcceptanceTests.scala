package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

import scala.util.Random

class AcceptanceTests extends FlatSpec with Matchers {

  private val NEVER: String = "never"

  def getOutputForRoutesCollection(routesCollection: Seq[Seq[Int]]): String = {

    if (routesCollection.length == 1) {
      return NEVER
    }

    if (routesCollection(0).head == routesCollection(1).head) {
      return "1"
    }

    NEVER
  }

  "A collection of routes with just one driver" should "output 'never' regardless of the number of stops" in {
    def routesCollection = Seq(Seq.fill(Random.nextInt(100))(Random.nextInt(100)))
    def output = getOutputForRoutesCollection(routesCollection)

    output should be (NEVER)
  }

  "A collection of routes with two drivers with one stop and both have the same stop" should "output '1'" in {
    def busStop = 1
    def routesCollection = Seq(Seq(busStop), Seq(busStop))
    def output = getOutputForRoutesCollection(routesCollection)

    output should be ("1")
  }

  "A collection of routes with two drivers with one stop and they don't have the same stop" should "output 'never'" in {
    def routesCollection = Seq(Seq(1), Seq(2))
    def output = getOutputForRoutesCollection(routesCollection)

    output should be (NEVER)
  }

  "A collection of routes with two drivers with two stops and both start at the same stop" should "output '1'" in {
    def busStop = 1
    def routesCollection = Seq(Seq(busStop, Random.nextInt()), Seq(busStop, Random.nextInt()))
    def output = getOutputForRoutesCollection(routesCollection)

    output should be ("1")
  }

}
