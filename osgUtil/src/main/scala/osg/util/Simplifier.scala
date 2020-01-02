package osg.util

import openscenegraph.core.NodeVisitor

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.annotation.alwaysinline
import scala.scalanative.cobj.CObjectWrapper

/**
 *
 */
@Cxx(namespace = "osgUtil")
@include("<osgUtil/Simplifier>")
class Simplifier extends NodeVisitor {
  def setSampleRatio(r: Float): Unit = extern
  def getSampleRatio(): Float = extern
}

object Simplifier {
  @constructor
  def apply(): Simplifier = extern

  @alwaysinline def stackalloc(implicit wrapper: CObjectWrapper[Simplifier]): Simplifier = {
    val p = unsafe.stackalloc[Byte](__sizeof)
    wrapper.wrap(p)
  }
}