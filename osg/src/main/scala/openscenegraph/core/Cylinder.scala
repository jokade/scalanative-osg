package openscenegraph.core

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.ResultValue

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Shape>")
class Cylinder extends Shape {
  def setCenter(@ref center: Vec3f): Unit = extern
  @returnsValue
  def getCenter()(implicit r: ResultValue[Vec3f]): Unit = extern

  def getRadius(): Float = extern
  def setRadius(r: Float): Unit = extern

  def getHeight(): Float = extern
  def setHeight(h: Float): Unit = extern
}

object Cylinder {
  @constructor
  def apply(): Cylinder = extern
  @constructor
  def apply(@ref center: Vec3f, radius: Float, height: Float): Cylinder = extern
  def apply(x: Float, y: Float, z: Float, radius: Float, height: Float): Cylinder = apply(Vec3f.stackalloc(x,y,z),radius,height)
}