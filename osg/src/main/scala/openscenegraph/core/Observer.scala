package openscenegraph.core

import scala.scalanative.cxx.Cxx
import scala.scalanative.unsafe._

@Cxx(namespace = "osg")
trait Observer {
  def objectDeleted(ptr: Ptr[Byte]): Unit
}
