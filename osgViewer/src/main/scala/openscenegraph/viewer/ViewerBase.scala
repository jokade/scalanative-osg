package openscenegraph.viewer

import openscenegraph.core.{Node, OsgObject}

import scalanative._
import unsafe._
import cxx._

/**
 * @see [[]]
 */
@Cxx(namespace = "osgViewer")
@include("<osgViewer/ViewerBase>")
class ViewerBase extends OsgObject {
  /// Execute the main frame loop
  def run(): Int = extern
}

object ViewerBase {

}

