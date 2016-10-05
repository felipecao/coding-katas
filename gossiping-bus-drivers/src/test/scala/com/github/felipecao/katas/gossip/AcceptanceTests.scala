package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

import scala.util.Random

class AcceptanceTests extends FlatSpec with Matchers {

  def getOutputForRoutesCollection(routesCollection: Seq[Seq[Int]]): String = {
    if (routesCollection.length > 1) {
      return "1"
    }
    "never"
  }

  "A collection of routes with just one driver" should "output 'never' regardless of the number of stops" in {
    def routesCollection = Seq(Seq.fill(Random.nextInt(100))(Random.nextInt(100)))
    def output = getOutputForRoutesCollection(routesCollection)

    output should be ("never")
  }

  "A collection of routes with two drivers with one stop and both have the same stop" should "output '1'" in {
    def busStop = 1
    def routesCollection = Seq(Seq(busStop), Seq(busStop))
    def output = getOutputForRoutesCollection(routesCollection)

    output should be ("1")
  }

}
