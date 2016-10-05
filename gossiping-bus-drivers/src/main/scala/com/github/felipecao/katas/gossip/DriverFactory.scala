package com.github.felipecao.katas.gossip

import scala.collection.mutable.ListBuffer

object DriverFactory {
  def buildFromRoutesCollection(routesOfEachDriver: Seq[Seq[Int]]): Drivers = {

    var drivers = new ListBuffer[Driver]()
    
    routesOfEachDriver.foreach( routesOfOneDriver =>
      drivers += new Driver(Route(routesOfOneDriver))
    )

    return new Drivers(drivers)
  }
  
}
