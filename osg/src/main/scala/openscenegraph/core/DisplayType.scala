package openscenegraph.core

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.CEnum

/**
 *
 */
@CxxEnum("osg::DisplaySettings::DisplayType")
@include("<DisplayType>")
object DisplayType extends CEnum {
  val MONITOR = Value(0)
  val POWERWALL = Value(1)
  val REALITIY_CENTER = Value(2)
  val HEAD_MOUNTED_DISPLAY = Value(3)
}

