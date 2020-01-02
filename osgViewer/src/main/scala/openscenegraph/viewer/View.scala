package openscenegraph.viewer

import openscenegraph.core.{DisplaySettings, Node}

import scalanative._
import unsafe._
import cxx._

/**
 * @see [[]]
 */
@Cxx(namespace = "osgViewer")
@include("<osgViewer/View>")
trait View extends openscenegraph.core.View {
  def setSceneData(node: Node): Unit
  def setDisplaySettings(ds: DisplaySettings): Unit
  def setUpViewOnSingleScreen(screenNum: CUnsignedInt): Unit
  def setUpViewInWindow(x: Int, y: Int, width: Int, height: Int): Unit
}

object View {
}