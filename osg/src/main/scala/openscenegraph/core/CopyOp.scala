package openscenegraph.core

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.CEnum

/**
 *
 */
@CxxEnum("osg::CopyOp::Options")
object CopyOp extends CEnum {
  val SHALLOW_COPY                = Value(0)
  val DEEP_COPY_OBJECTS           = Value(1<<0)
  val DEEP_COPY_NODES             = Value(1<<1)
  val DEEP_COPY_DRAWABLES         = Value(1<<2)
  val DEEP_COPY_STATESETS         = Value(1<<3)
  val DEEP_COPY_STATEATTRIBUTES   = Value(1<<4)
  val DEEP_COPY_TEXTURES          = Value(1<<5)
  val DEEP_COPY_IMAGES            = Value(1<<6)
  val DEEP_COPY_ARRAYS            = Value(1<<7)
  val DEEP_COPY_PRIMITIVES        = Value(1<<8)
  val DEEP_COPY_SHAPES            = Value(1<<9)
  val DEEP_COPY_UNIFORMS          = Value(1<<10)
  val DEEP_COPY_CALLBACKS         = Value(1<<11)
  val DEEP_COPY_USERDATA          = Value(1<<12)
  val DEEP_COPY_ALL               = Value(0x7FFFFFFF)
}

