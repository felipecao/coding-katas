package com.github.felipecao.katas.gossip

case class Driver (route: Route) {
  def firstStop = route.firstStop
  def lastStop = route.lastStop
  def totalStops = route.totalStops
  var currentStop = route.firstStop

  private var gossips = Set(new Gossip)

  def exchangeGossips(): Unit = {
    currentStop.drivers().foreach( d =>
      d.exchangeGossip(this)
    )
  }

  def moveToNextStop(): Unit = {
    currentStop.depart(this)

    currentStop = route.nextStop
    currentStop.arrive(this)
  }

  def exchangeGossip(driver: Driver): Unit = {
    gossips = gossips ++ driver.allGossips
  }

  private def allGossips: Set[Gossip] = {
    gossips
  }

  def totalGossips(): Int = {
    gossips.size
  }
}
