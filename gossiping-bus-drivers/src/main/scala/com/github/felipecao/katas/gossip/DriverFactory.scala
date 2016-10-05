package com.github.felipecao.katas.gossip

object DriverFactory {
  def buildFromRoutesCollection(routesOfEachDriver: Seq[Seq[Int]]): Drivers = {
    new Drivers(
      routesOfEachDriver
        .map(routesOfOneDriver => new Driver(Route(routesOfOneDriver)))
    )
  }
}
