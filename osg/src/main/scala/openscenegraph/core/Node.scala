package openscenegraph.core

import cxxlib.CxxString
import openscenegraph.core.Node.ParentSeq

import scalanative._
import unsafe._
import unsigned._
import cxx._
import scala.collection.AbstractSeq
import scala.scalanative.cobj.ResultValue

/**
 * Base class for all internal nodes in the scene graph.
 */
@Cxx(namespace = "osg")
@include("<osg/Node>")
class Node extends OsgObject {
  def accept(@ref nv: NodeVisitor): Unit = extern

  def getNumParents(): CUnsignedInt = extern
  def getParent(i: CUnsignedInt): Node = extern
  lazy val parents: Seq[Node] = new ParentSeq(this)

  def getNumDescriptions(): CUnsignedInt = extern
  def addDescription(@ref desc: CxxString): Unit = extern
  @returnsValue
  def getDescription(i: CUnsignedInt)(implicit s: ResultValue[CxxString]): Unit = extern
}

object Node {
  @constructor
  def apply(): Node = extern

  final class ParentSeq(node: Node) extends AbstractSeq[Node] with IndexedSeq[Node] {
    override def length: CInt = node.getNumParents().toInt
    override def apply(idx: CInt): Node = node.getParent(idx.toUInt)
  }
}