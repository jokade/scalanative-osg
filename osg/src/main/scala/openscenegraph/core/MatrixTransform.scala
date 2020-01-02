package openscenegraph.core

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.ResultValue

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/MatrixTransform>")
class MatrixTransform extends Transform {
  def setMatrix(@ref mat: Matrixf): Unit = extern
  @returnsValue
  def getMatrix()(implicit r: ResultValue[Matrixf]): Unit = extern

  def preMult(@ref mat: Matrixf): Unit = extern
  def postMult(@ref mat: Matrixf): Unit = extern
}

object MatrixTransform {
  @constructor
  def apply(): MatrixTransform = extern
  @constructor
  def apply(@ref mat: Matrixf): MatrixTransform = extern

  def scale(x: Float, y: Float, z: Float): MatrixTransform = {
    val m = Matrixf.stackalloc
    m.makeTranslate(x,y,z)
    apply(m)
  }

  def translate(x: Float, y: Float, z: Float): MatrixTransform = {
    val m = Matrixf.stackalloc
    m.makeTranslate(x,y,z)
    apply(m)
  }
}