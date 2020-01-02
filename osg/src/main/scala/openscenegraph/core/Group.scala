package openscenegraph.core

import openscenegraph.core.Group.ChildSeq

import scalanative._
import unsafe._
import cxx._
import scala.collection.mutable
import scala.scalanative.unsigned._

/**
 * General group node whichmaintains a list of children.
 */
@Cxx(namespace = "osg")
@include("<osg/Group>")
class Group extends Node {
  def getNumChildren(): CUnsignedInt = extern
  def addChild(child: Node): Boolean = extern
  def insertChild(index: CUnsignedInt, child: Node): Boolean = extern
  def removeChild(child: Node): Boolean = extern
  def setChild(index: CUnsignedInt, node: Node): Boolean = extern
  def getChild(index: UInt): Node = extern
  def replaceChild(origChild: Node, newChild: Node): Boolean = extern
  lazy val children: mutable.Seq[Node] = new ChildSeq(this)
}

object Group {
  @constructor
  def apply(): Group = extern

  final class ChildSeq(g: Group) extends mutable.AbstractSeq[Node] with mutable.IndexedSeq[Node] {
    override def update(idx: CInt, elem: Node): Unit = g.setChild(idx.toUInt,elem)
    override def length: CInt = g.getNumChildren().toInt
    override def apply(idx: CInt): Node = g.getChild(idx.toUInt)
  }
}