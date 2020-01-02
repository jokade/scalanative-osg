package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Shape>")
class InfinitePlane extends Shape {
  def set(@ref norm: Vec3f, @ref point: Vec3f): Unit = extern
}

object InfinitePlane {
  @constructor
  def apply(): InfinitePlane = extern
  def apply(norm: Vec3f, point: Vec3f): InfinitePlane = {
    val p = apply()
    p.set(norm,point)
    p
  }
}