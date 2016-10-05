package com.github.felipecao.katas.gossip

case class Route (stops: Seq[Int]) {
  def totalStops = stops.length
}
