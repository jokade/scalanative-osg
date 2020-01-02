package openscenegraph.viewer

import openscenegraph.core.{ArgumentParser, DisplaySettings, Node}

import scala.scalanative._
import scala.scalanative.cxx._
import scala.scalanative.unsafe._

@Cxx(namespace = "osgViewer")
@include("<osgViewer/Viewer>")
class Viewer extends ViewerBase with View {
  override def setSceneData(node: Node): Unit = extern
  override def setDisplaySettings(ds: DisplaySettings): Unit = extern
  override def setUpViewOnSingleScreen(screenNum: CUnsignedInt): Unit = extern
  override def setUpViewInWindow(x: CInt, y: CInt, width: CInt, height: CInt): Unit = extern
}
object Viewer {
  @constructor
  def apply(): Viewer = extern
  @constructor
  def apply(@ref parser: ArgumentParser): Viewer = extern
}
