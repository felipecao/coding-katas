package com.github.felipecao.katas.gossip

class Drivers (collection: Seq[Driver]) {
  var allDrivers: Seq[Driver] = collection

  val count: Int = {
    allDrivers.length
  }

  def everyoneHasAllGossips(): Boolean = {
    val gossipsFromAllDrivers = allDrivers.map(d => d.totalGossips()).distinct
    gossipsFromAllDrivers.size == 1 && gossipsFromAllDrivers(0) == allDrivers.length
  }

}