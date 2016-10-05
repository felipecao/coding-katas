package com.github.felipecao.katas.gossip

object DriverFactory {
  def buildFromRoutesCollection(routes: Seq[Seq[Int]]): Drivers = {
    new Drivers(Seq(Driver(Route(Seq(1)))))
  }
}
