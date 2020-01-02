package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Shape>")
class TessellationHints extends OsgObject {
  def getDetailRatio(): Float = extern
  def setDetailRatio(r: Float): Unit = extern
}

object TessellationHints {
  @constructor
  def apply(): TessellationHints = extern
}