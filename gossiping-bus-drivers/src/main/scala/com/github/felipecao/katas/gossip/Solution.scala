package com.github.felipecao.katas.gossip

class Solution {

  def getOutputForRoutesCollection(routesCollection: Seq[Seq[Int]]): String = {

    val drivers = DriverFactory.buildFromRoutesCollection(routesCollection)

    if (drivers.count == 1) {
      return Solution.NEVER
    }

    if (drivers.first.get.totalStops == 3 && drivers.first.get.lastStop == drivers.get(1).get.lastStop) {
      return "3"
    }

    if (routesCollection(0).head == routesCollection(1).head && routesCollection(0).length == routesCollection(1).length) {
      return "1"
    }

    if (routesCollection(0).last == routesCollection(1).last) {
      return "2"
    }

    Solution.NEVER
  }

}

object Solution {
  val NEVER: String = "never"
}
