package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/DrawArrays>")
class DrawArrays extends PrimitiveSet {

}

object DrawArrays {
  @constructor
  def apply(mode: PrimitiveSetMode.Value): DrawArrays = extern
}