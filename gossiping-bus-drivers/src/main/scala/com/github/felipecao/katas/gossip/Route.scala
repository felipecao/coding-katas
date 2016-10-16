package com.github.felipecao.katas.gossip

class Route (val stops: Seq[Stop]) {

  private var currentStopIndex: Int = 0

  def firstStop = stops.head

  def nextStop: Stop = {
    currentStopIndex = ((currentStopIndex + 1) % stops.size)
    stops(currentStopIndex)
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Route]

  override def equals(other: Any): Boolean = other match {
    case that: Route =>
      (that canEqual this) &&
        stops == that.stops
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(stops)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
