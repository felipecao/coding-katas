package com.github.felipecao.katas.gossip

case class Route (stops: Seq[Int]) {
  def lastStop = stops.last
  def totalStops = stops.length
}
