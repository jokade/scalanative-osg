package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/LOD>")
class LOD extends Group {
  def addChild(child: Node, rmin: Float, rmax: Float): Boolean = extern
}

object LOD {
  @constructor
  def apply(): LOD = extern
}