package openscenegraph.core

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.ResultValue

@Cxx(namespace = "osg")
@include("<osg/Shape>")
class Box extends Shape {
  @returnsValue
  def getCenter()(implicit v: ResultValue[Vec3f]): Unit = extern
  def setCenter(@ref center: Vec3f): Unit = extern
  @returnsValue
  def getHalfLengths()(implicit v: ResultValue[Vec3f]): Unit = extern
  def setHalfLengths(@ref halfLengths: Vec3f): Unit = extern
}

object Box {
  @constructor
  def apply(): Box = extern
  @constructor
  def apply(@ref center: Vec3f, lengthX: Float, lengthY: Float, lengthZ: Float): Box = extern
  @constructor
  def apply(@ref center: Vec3f, width: Float): Box = extern
  def apply(x: Float, y: Float, z: Float, width: Float): Box = apply(Vec3f.stackalloc(x,y,z),width)
}