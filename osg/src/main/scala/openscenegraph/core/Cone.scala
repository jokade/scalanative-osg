package openscenegraph.core

import apple.laf.JRSUIState.TitleBarHeightState

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.ResultValue

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Shape>")
class Cone extends Shape {
  @returnsValue
  def getCenter()(implicit v: ResultValue[Vec3f]): Unit = extern
  def setCenter(@ref center: Vec3f): Unit = extern
  def getRadius(): Float = extern
  def setRadius(radius: Float): Unit = extern
  def getHeight(): Float = extern
  def setHeight(height: Float): Unit = extern
}

object Cone {
  @constructor
  def apply(): Cone = extern
  @constructor
  def apply(@ref center: Vec3f, radius: Float, height: Float): Cone = extern
  def apply(x: Float, y: Float, z: Float, radius: Float, height: Float): Cone = apply(Vec3f.stackalloc(x,y,z),radius,height)
}