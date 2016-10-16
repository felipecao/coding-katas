package com.github.felipecao.katas.gossip

class Solution {

  def timeToSpreadAllGossips(routesCollection: Seq[Seq[Int]]): String = {

    val drivers = DriverFactory.buildDriversFromRoutesCollection(routesCollection)
    val clock = new Clock(drivers)

    if (drivers.count == 1) {
      return Solution.NEVER
    }

    while (!clock.isTimeUp() && !drivers.everyoneHasAllGossips()) {
      clock.tick()
    }

    if (drivers.everyoneHasAllGossips()) {
      return clock.currentTime.toString
    }

    Solution.NEVER
  }

}

object Solution {
  val NEVER: String = "never"
}
