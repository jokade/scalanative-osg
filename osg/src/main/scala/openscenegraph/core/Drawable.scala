package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Drawable>")
class Drawable extends Node {
  def setShape(shape: Shape): Unit = extern
}

object Drawable {
}