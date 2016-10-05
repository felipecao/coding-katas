package com.github.felipecao.katas.gossip

case class Driver (route: Route) {
  def lastStop = route.lastStop
  def totalStops = route.totalStops
}
