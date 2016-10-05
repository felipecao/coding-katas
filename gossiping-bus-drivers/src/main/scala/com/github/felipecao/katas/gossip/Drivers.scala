package com.github.felipecao.katas.gossip

class Drivers (collection: Seq[Driver]) {
  var allDrivers: Seq[Driver] = collection

  val count: Int = {
    allDrivers.length
  }

  def get(index: Int): Option[Driver] = {

    if(index < 0 || index >= count) {
      return Option.empty[Driver]
    }

    Some(allDrivers(index))
  }

  def first = get(0)

}