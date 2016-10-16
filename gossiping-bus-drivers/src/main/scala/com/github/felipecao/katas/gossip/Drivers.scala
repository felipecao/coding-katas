package com.github.felipecao.katas.gossip

class Drivers (allDrivers: Seq[Driver]) {

  val count: Int = {
    allDrivers.length
  }

  def everyoneHasAllGossips(): Boolean = {
    val gossipsFromAllDrivers = allDrivers.map(d => d.totalGossips()).distinct
    gossipsFromAllDrivers.size == 1 && gossipsFromAllDrivers.head == allDrivers.length
  }

  def notifyAllTimeWindowChangeHasStarted(): Unit = {
    allDrivers.foreach( d =>
      d.timeWindowChangeHasStarted()
    )
  }

  def notifyAllTimeWindowChangeIsFinished(): Unit = {
    allDrivers.foreach( d =>
      d.timeWindowChangeIsFinished()
    )
  }

}