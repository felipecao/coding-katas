package com.github.felipecao.katas.gossip

object DriverFactory {
  def buildDriversFromRoutesCollection(routesOfEachDriver: Seq[Seq[Int]]): Drivers = {
    val routes = RoutesFactory.buildFromRoutesCollection(routesOfEachDriver)

    new Drivers(
      routes
        .map(routesOfOneDriver => new Driver(routesOfOneDriver))
    )
  }
}
