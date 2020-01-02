package openscenegraph.db

import cxxlib.CxxString
import de.surfice.smacrotools.debug
import openscenegraph.core.Node

import scala.scalanative._
import scala.scalanative.cxx._
import scala.scalanative.unsafe._

@Cxx(namespace = "osgDB", isNamespaceObject = true)
@include("<osgDB/ReadFile>")
@debug
object OsgDB {
  def readNodeFile(@ref filename: CxxString): Node = extern
}