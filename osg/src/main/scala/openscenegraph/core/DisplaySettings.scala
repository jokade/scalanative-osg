package openscenegraph.core

import cxxlib.CxxString

import scalanative._
import unsafe._
import cxx._
import scala.scalanative.cobj.ResultValue

/**
 *
 */
@Cxx(namespace = "osg")
@include("<osg/DisplaySettings>")
class DisplaySettings extends Referenced {
  def getScreenWidth(): Float = extern
  def setScreenWidth(w: Float): Unit = extern

  def getScreenHeight(): Float = extern
  def setScreenHeight(h: Float): Unit = extern

  def setDisplayType(dt: DisplayType.Value): Unit = extern
  def getDisplayType(): DisplayType.Value = extern

  def setStereoMode(m: StereoMode.Value): Unit = extern
  def getStereoMode(): StereoMode.Value = extern

  def getApplication()(implicit s: ResultValue[CxxString]): Unit = extern
  def setApplication(@ref name: CxxString): Unit = extern
}

object DisplaySettings {
  @constructor
  def apply(): DisplaySettings = extern
}