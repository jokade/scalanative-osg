package openscenegraph.core

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.CEnum

/**
 *
 */
@CxxEnum("osg::PrimitiveSet::Mode")
object PrimitiveSetMode extends CEnum {
  val POINTS                       = Value(0x0000)
  val LINES                        = Value(0x0001)
  val LINE_LOOP                    = Value(0x0002)
  val LINE_STRIP                   = Value(0x0003)
  val TRIANGLES                    = Value(0x0004)
  val TRIANGLE_STRIP               = Value(0x0005)
  val TRIANGLE_FAN                 = Value(0x0006)
  val QUADS                        = Value(0x0007)
  val QUAD_STRIP                   = Value(0x0008)
  val POLYGON                      = Value(0x0009)
  val LINES_ADJACENCY              = Value(0x000A)
  val LINE_STRIP_ADJACENCY         = Value(0x000B)
  val TRIANGLES_ADJACENCY          = Value(0x000C)
  val TRIANGLE_STRIP_ADJACENCY     = Value(0x000D)
}

