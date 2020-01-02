package openscenegraph

import scala.scalanative.annotation.alwaysinline

package object core {
  type Color = Vec4f
  object Color {
    @alwaysinline def stackalloc(r: Float, g: Float, b: Float, a: Float): Vec4f = Vec4f.stackalloc(r,g,b,a)
  }
}
