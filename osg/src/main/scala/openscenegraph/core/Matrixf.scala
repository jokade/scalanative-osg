package openscenegraph.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.annotation.alwaysinline
import scala.scalanative.cobj.CObjectWrapper

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Matrixf>")
class Matrixf extends {
  @cxxName("operator()")
  def apply(row: Int, col: Int): Float = extern
  @cxxBody("__p->operator()(row,col) = value;")
  def update(row: Int, col: Int, value: Float): Unit = extern

  def set(a00: Float, a01: Float, a02: Float, a03: Float,
          a10: Float, a11: Float, a12: Float, a13: Float,
          a20: Float, a21: Float, a22: Float, a23: Float,
          a30: Float, a31: Float, a32: Float, a33: Float): Unit = extern

  def makeIdentity(): Unit = extern
  def isIdentity(): Boolean = extern

  def makeScale(@ref scale: Vec3f): Unit = extern
  def makeScale(x: Float, y: Float, z: Float): Unit = extern

  def makeTranslate(@ref translate: Vec3f): Unit = extern
  def makeTranslate(x: Float, y: Float, z: Float): Unit = extern

  def makeRotate(@ref from: Vec3f, @ref to: Vec3f): Unit = extern
  def makeRotate(angle: Float, x: Float, y: Float, z: Float): Unit = extern

//  @cxxName("operator*")
//  @returnsValue
//  def *(@ref v: Vec4f): Vec4f = extern
}

object Matrixf {
  @constructor
  def apply(): Matrixf = extern

//  def scale(@ref v: Vec3f): Matrixf = extern
//  def scale(x: Float, y: Float, z: Float): Matrixf = scale(Vec3f.stackalloc(x,y,z))

//  def translate(@ref v: Vec3f): Matrixf = extern
//  def translate(x: Float, y: Float, z: Float): Matrixf = translate(Vec3f.stackalloc(x,y,z))

//  def rotate(@ref from: Vec3f, @ref to: Vec3f): Matrixf = extern

  @alwaysinline def stackalloc(implicit wrapper: CObjectWrapper[Matrixf]): Matrixf = wrapper.wrap(unsafe.stackalloc(__sizeof))

}