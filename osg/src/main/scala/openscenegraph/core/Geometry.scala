package openscenegraph.core

import scalanative._
import unsafe._
import unsigned._
import cxx._
import scala.scalanative.cobj.CEnum

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Geometry>")
class Geometry extends Drawable {
  def addPrimitiveSet(set: PrimitiveSet): Boolean = extern
  def getNumPrimitiveSets(): CUnsignedInt = extern
  def getPrimitiveSet(pos: CUnsignedInt): PrimitiveSet = extern
  def insertPrimitiveSet(i: CUnsignedInt, set: PrimitiveSet): Boolean = extern
  def removePrimitiveSet(i: CUnsignedInt): Boolean = extern

  def setColorBinding(binding: AttriButeBinding.Value): Unit = extern
  def getColorBinding(): AttriButeBinding.Value = extern

  def setSecondaryColorBinding(binding: AttriButeBinding.Value): Unit = extern
  def getSecondaryColorBinding(): AttriButeBinding.Value = extern

  def setFogCoordBinding(binding: AttriButeBinding.Value): Unit = extern
  def getFogCoordBinding(): AttriButeBinding.Value = extern
}

object Geometry {
}

