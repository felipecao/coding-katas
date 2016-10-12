package com.github.felipecao.katas.gossip

object RoutesFactory {
  def buildFromRoutesCollection(routesOfEachDriver: Seq[Seq[Int]]): Seq[Route] = {
    val stops = indexesAndStops(routesOfEachDriver)

    routesOfEachDriver.map( r =>
      new Route(r.map( i => stops(i)))
    )
  }

  private def indexesAndStops(routesOfEachDriver: Seq[Seq[Int]]): Map[Int, Stop] = {
    routesOfEachDriver.flatten.distinct.map(element => element -> Stop(element)).toMap
  }
}
