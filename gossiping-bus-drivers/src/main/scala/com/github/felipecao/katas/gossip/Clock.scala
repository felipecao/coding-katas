package com.github.felipecao.katas.gossip

class Clock (observers: Drivers) {

  def tick(): Unit = {
    observers.allDrivers.foreach( d =>
      d.clockHasTicked()
    )
  }
}
