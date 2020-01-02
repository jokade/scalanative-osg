package openscenegraph.core

import openscenegraph.core

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.annotation.alwaysinline
import scala.scalanative.cobj.{CObjectWrapper, ResultValue}
import scala.scalanative.interop.AutoReleasable

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Vec3f>")
class Vec3f extends CxxObject with AutoReleasable {
  def x(): Float = extern
  def y(): Float = extern
  def z(): Float = extern
  def set(x: Float, y: Float, z: Float): Unit = extern
  def length(): Float = extern
  def length2(): Float = extern
  def normalize(): Float = extern
  @delete
  override def free(): Unit = extern
}

object Vec3f {
//  lazy val pool: ObjectPool[Vec3fShared] = new ObjectPool[Vec3fShared](Zone.open(),__sizeof)(Vec3fShared.__wrapper)

  @constructor
  def apply(): Vec3f = extern
  @constructor
  def apply(x: Float, y: Float, z: Float): Vec3f = extern

//  @alwaysinline def shared(): Vec3f = pool.get()
//  @alwaysinline def shared(x: Float, y: Float, z: Float): Vec3f = {
//    val v = shared()
//    v.set(x,y,z)
//    v
//  }

  def alloc(implicit z: Zone): Vec3f = new Vec3f(unsafe.alloc(__sizeof))
  @alwaysinline def stackalloc(implicit wrapper: CObjectWrapper[Vec3f]): Vec3f = wrapper.wrap(unsafe.stackalloc(__sizeof))
  @alwaysinline def stackalloc(x: Float, y: Float, z: Float)(implicit wrapper: CObjectWrapper[Vec3f]): Vec3f = {
    val v = stackalloc
    v.set(x,y,z)
    v
  }

}

//@Cxx(cxxType = "osg::Vec3f")
//class Vec3fShared extends Vec3f {
//  override def free(): Unit = Vec3f.pool.release(this)
//}

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/Vec4f>")
class Vec4f extends CxxObject with AutoReleasable {
  def x(): Float = extern
  def y(): Float = extern
  def z(): Float = extern
  def w(): Float = extern
  def r(): Float = extern
  def g(): Float = extern
  def b(): Float = extern
  def a(): Float = extern
  def set(x: Float, y: Float, z: Float, w: Float): Unit = extern
  def length(): Float = extern
  def length2(): Float = extern
  def normalize(): Float = extern
  @delete
  override def free(): Unit = extern
}

object Vec4f {

  @constructor
  def apply(): Vec4f = extern
  @constructor
  def apply(x: Float, y: Float, z: Float, w: Float): Vec4f = extern

  @alwaysinline def stackalloc(implicit wrapper: CObjectWrapper[Vec4f]): Vec4f = wrapper.wrap(unsafe.stackalloc(__sizeof))
  @alwaysinline def stackalloc(x: Float, y: Float, z: Float, w: Float)(implicit wrapper: CObjectWrapper[Vec4f]): Vec4f = {
    val v = stackalloc
    v.set(x,y,z,w)
    v
  }

}

