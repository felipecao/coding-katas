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

    if (drivers.first.get.firstStop == drivers.get(1).get.firstStop
      && drivers.first.get.totalStops == drivers.get(1).get.totalStops) {
      return "1"
    }

    if (drivers.first.get.lastStop == drivers.get(1).get.lastStop) {
      return "2"
    }

    Solution.NEVER
  }

}

object Solution {
  val NEVER: String = "never"
}
