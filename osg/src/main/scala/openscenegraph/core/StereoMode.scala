package openscenegraph.core

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.CEnum

/**
 *
 */
@CxxEnum("osg::DisplaySettings::StereoMode")
object StereoMode extends CEnum {
  val QUAD_BUFFER = Value(0)
  val ANAGLYPHIC = Value(1)
  val HORIZONTAL_SPLIT = Value(2)
  val VERTICAL_SPLIT = Value(3)
  val LEFT_EYE = Value(4)
  val RIGHT_EYE = Value(5)
  val HORIZONTAL_INTERLACE = Value(6)
  val VERTICAL_INTERLACE = Value(7)
  val CHECKERBOARD = Value(8)
}

