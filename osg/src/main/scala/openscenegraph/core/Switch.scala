package openscenegraph.core

import scalanative._
import unsafe._
import cxx._

/**
 * Switch is a Group node that allows switching between children.
 */
@Cxx(namespace = "osg")
@include("<osg/Switch>")
class Switch extends Group {
  def setAllChildrenOff(): Boolean = extern
  def setAllChildrenOn(): Boolean = extern
  def addChild(node: Node, visible: Boolean): Unit = extern
  def setChildValue(child: Node, value: Boolean): Unit = extern
  def getChildValue(child: Node): Boolean = extern
  def setSingleChildOn(pos: CUnsignedInt): Unit = extern
}

object Switch {
  @constructor
  def apply(): Switch = extern
}