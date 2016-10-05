package com.github.felipecao.katas.gossip

case class Driver (route: Route) {
  def firstStop = route.firstStop
  def lastStop = route.lastStop
  def totalStops = route.totalStops
}
