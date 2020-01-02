package openscenegraph.core

import scala.scalanative._
import scala.scalanative.cobj.{CObject, CObjectWrapper}
import scala.scalanative.cxx._
import scala.scalanative.interop.AutoRetainable
import scala.scalanative.unsafe._

/**
 * @see [[]]
 */
@Cxx(namespace = "osg", classname = "Object")
@include("<osg/Object>")
class OsgObject extends Referenced {
  @cxxName("clone")
  def cloneAs[T<:OsgObject](op: CopyOp.Value)(implicit wrapper: CObjectWrapper[T]): T = extern
  @inline final def deepCloneAs[T<:OsgObject](implicit wrapper: CObjectWrapper[T]): T = cloneAs(CopyOp.DEEP_COPY_ALL)
}

