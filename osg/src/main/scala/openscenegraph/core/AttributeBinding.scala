package openscenegraph.core

import openscenegraph.core.AttriButeBinding.Value

import scala.scalanative.cobj.CEnum
import scala.scalanative.cxx.CxxEnum


@CxxEnum("osg::Geometry::AttributeBinding")
object AttriButeBinding extends CEnum {
  val BIND_OFF = Value(0)
  val BIND_OVERALL = Value(1)
  val BIND_PER_PRIMITIVE_SET = Value(2)
  val BIND_PER_VERTEX = Value(4)
}