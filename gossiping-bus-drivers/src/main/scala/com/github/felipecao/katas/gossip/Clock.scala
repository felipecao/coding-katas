package com.github.felipecao.katas.gossip

class Clock (observers: Drivers) {

  private var currentMinute = 1;

  def tick(): Unit = {

    observers.allDrivers.foreach( d =>
      d.clockHasTicked()
    )

    observers.allDrivers.foreach( d =>
      d.allObserversHaveBeenNotified()
    )

    currentMinute += 1
  }

  def isTimeUp(): Boolean = {
    currentMinute > Clock.MINUTES_IN_A_DAY
  }
}

object Clock {
  val MINUTES_IN_A_DAY: Int = 480
}
