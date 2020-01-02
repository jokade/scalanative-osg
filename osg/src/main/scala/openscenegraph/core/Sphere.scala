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
class Sphere extends Shape {
  @returnsValue
  def getCenter()(implicit v: ResultValue[Vec3f]): Unit = extern
  def setCenter(@ref center: Vec3f): Unit = extern
  def getRadius(): Float = extern
  def setRadius(radius: Float): Unit = extern
}

object Sphere {
  @constructor
  def apply(): Sphere = extern
  @constructor
  def apply(@ref center: Vec3f, radius: Float): Sphere = extern

  def apply(x: Float, y: Float, z: Float, radius: Float): Sphere =
    apply(Vec3f.stackalloc(x,y,z),radius)
//  def apply(x: Float, y: Float, z: Float, radius: Float): Sphere = {
//    val v = Vec3f.shared(x,y,z)
//    val s = apply(v,radius)
//    v.free()
//    s
//  }
}