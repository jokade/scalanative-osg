package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 * Base class for all Shape types.
 */
@Cxx(namespace = "osg")
@include("<osg/Shape>")
class Shape extends OsgObject {

}

object Shape {
}