package com.github.felipecao.katas.gossip

class Clock (observers: Drivers) {

  private var currentMinute = 0

  def tick(): Unit = {

    observers.allDrivers.foreach( d =>
      d.timeWindowChangeHasStarted()
    )

    observers.allDrivers.foreach( d =>
      d.timeWindowChangeIsFinished()
    )

    currentMinute += 1
  }

  def isTimeUp(): Boolean = {
    currentMinute > Clock.MINUTES_IN_A_DAY
  }

  def currentTime(): Int = {
    currentMinute
  }
}

object Clock {
  val MINUTES_IN_A_DAY: Int = 480
}
