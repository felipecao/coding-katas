package com.github.felipecao.katas.gossip

class Drivers (collection: Seq[Driver]) {
  var allDrivers: Seq[Driver] = collection

  val count: Int = {
    allDrivers.length
  }
}
