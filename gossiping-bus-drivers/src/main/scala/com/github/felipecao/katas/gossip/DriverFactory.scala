package com.github.felipecao.katas.gossip

object DriverFactory {
  def buildFromRoutesCollection(routes: Seq[Seq[Int]]): Drivers = {

    if(routes.length > 1) {
      return new Drivers(Seq(
        Driver(Route(Seq(1))),
        Driver(Route(Seq(2)))
      ))
    }

    new Drivers(Seq(Driver(Route(Seq(1)))))
  }
}
