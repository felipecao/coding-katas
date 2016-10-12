package com.github.felipecao.katas.gossip

case class Driver (route: Route) {
  def firstStop = route.firstStop
  def lastStop = route.lastStop
  def totalStops = route.totalStops
  var currentStop = route.firstStop

  def clockHasTicked(): Unit = {
    currentStop = route.nextStop
  }

  def allObserversHaveBeenNotified(): Unit = {

  }
}
