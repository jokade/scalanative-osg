package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/ShapeDrawable>")
class ShapeDrawable extends Geometry {
  def setColor(@ref color: Color): Unit = extern
  def setTessellationHints(hints: TessellationHints): Unit = extern
}

object ShapeDrawable {
  @constructor
  def apply(): ShapeDrawable = extern
  def apply(shape: Shape, hints: TessellationHints = null): ShapeDrawable = {
    val d = apply()
    d.setShape(shape)
    if(hints != null)
      d.setTessellationHints(hints)
    d
  }
}