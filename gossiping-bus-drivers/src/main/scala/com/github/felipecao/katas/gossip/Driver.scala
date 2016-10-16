package com.github.felipecao.katas.gossip

class Driver (val route: Route) {

  private var gossips = Set(new Gossip)
  private var currentStop = route.firstStop

  currentStop.arrive(this)

  def timeWindowChangeHasStarted(): Unit = {
    currentStop.drivers().foreach( d =>
      d.exchangeGossip(this)
    )
  }

  def timeWindowChangeIsFinished(): Unit = {
    currentStop.depart(this)

    currentStop = route.nextStop
    currentStop.arrive(this)
  }

  def exchangeGossip(driver: Driver): Unit = {
    gossips = gossips ++ driver.gossips
  }

  def totalGossips(): Int = {
    gossips.size
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Driver]

  override def equals(other: Any): Boolean = other match {
    case that: Driver =>
      (that canEqual this) &&
        route == that.route
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(route)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
