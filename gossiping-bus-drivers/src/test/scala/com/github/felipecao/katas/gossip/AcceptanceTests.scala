package com.github.felipecao.katas.gossip

import org.scalatest.{Matchers, FlatSpec}

import scala.util.Random

class AcceptanceTests extends FlatSpec with Matchers {

  def getOutputForRoutesCollection(routesCollection: Seq[Int]): String = ???

  "A collection of routes with just one driver" should "output 'never' regardless of the number of stops" in {
    def routesCollection = Seq.fill(Random.nextInt(100))(Random.nextInt(100))
    def output = getOutputForRoutesCollection(routesCollection)

    output should be ("never")
  }

}
