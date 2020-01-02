package openscenegraph.core

import scalanative._
import unsafe._
import cxx.{CxxObject, _}
import scala.scalanative.interop.AutoRetainable

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Referenced>")
class Referenced extends CxxObject with AutoRetainable {
  def ref(): Int = extern
  def unref(): Int = extern
  def referenceCount(): Int = extern
  def addObserver(o: Observer): Unit = extern

  @inline final override def retain(): this.type = {
    ref()
    this
  }
  @inline final override def free(): Unit = unref()
}

object Referenced {
}