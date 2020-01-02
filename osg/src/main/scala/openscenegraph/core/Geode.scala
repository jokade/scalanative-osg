package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 * A Geode is a "geometry node", that is, a leaf node on the scene graph that can have "renderable things" attached to it.
 */
@Cxx(namespace = "osg")
@include("<osg/Geode>")
class Geode extends Group {

  def addDrawable(drawable: Drawable): Boolean = extern
  def addDrawable(shape: Shape, hints: TessellationHints = null): Boolean = addDrawable(ShapeDrawable(shape,hints))

//  @inline final def +=(d: Drawable): Boolean = addDrawable(d)
}

object Geode {
  @constructor
  def apply(): Geode = extern
}