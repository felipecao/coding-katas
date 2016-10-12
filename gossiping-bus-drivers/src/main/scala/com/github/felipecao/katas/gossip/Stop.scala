package com.github.felipecao.katas.gossip

import scala.collection.mutable.ListBuffer

case class Stop (number: Int) {

  val driversAtStop = new ListBuffer[Driver]

  def arrive(driver: Driver): Unit = {
    driversAtStop += driver
  }

  def depart(driver: Driver): Unit = {
    driversAtStop -= driver
  }

  def drivers(): Seq[Driver] = {
    driversAtStop.toSeq
  }
}
