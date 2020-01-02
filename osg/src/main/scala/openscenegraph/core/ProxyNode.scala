package openscenegraph.core

import cxxlib.CxxString

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.ResultValue

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/ProxyNode>")
class ProxyNode extends Group {
  def addChild(child: Node, @ref filename: CxxString): Boolean = extern

  def setFileName(childNo: CUnsignedInt, @ref path: CxxString): Unit = extern
  @returnsValue
  def getFileName(childNo: CUnsignedInt)(implicit r: ResultValue[CxxString]): Unit = extern
}

object ProxyNode {
  @constructor
  def apply(): ProxyNode = extern
}