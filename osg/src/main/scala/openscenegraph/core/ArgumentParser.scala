package openscenegraph.core

import de.surfice.smacrotools.debug

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.interop.AutoReleasable

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/ArgumentParser>")
class ArgumentParser extends AutoReleasable {
  @delete
  override def free(): Unit = extern
}

object ArgumentParser {
  @constructor
  def apply(argc: Ptr[Int], argv: Ptr[CString]): ArgumentParser = extern

  def apply(args: Array[String])(implicit zone: Zone): ArgumentParser = {
    val argc = stackalloc[Int]
    !argc = 1 //args.length + 1
    val p = alloc[CString](4)
    p(0) = c"foo"
//    for(i <- 1 until !argc) {
//      p(i) = toCString(args(i-1))
//    }
    apply(argc,p)
  }
}