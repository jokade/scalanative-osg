package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 * Maintains a master camera view and a list of slave cameras that are relative to this master camera.
 */
@Cxx(namespace = "osg")
@include("<osg/View>")
trait View extends OsgObject {
}

