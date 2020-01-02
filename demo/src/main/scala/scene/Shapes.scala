package scene

import openscenegraph.core._

object Shapes {
  def apply(): Node = createShapes()

  def createShapes(radius: Float = 0.8F, height: Float = 1F): Geode = {
    val geode = Geode()

    val hints = TessellationHints()
    hints.setDetailRatio(0.5F)

    geode.addDrawable(Sphere(0,0,0,radius),hints)
    geode.addDrawable(Box(2,0,0,2*radius),hints)
    geode.addDrawable(Cone(4,0,0,radius,height),hints)
    geode.addDrawable(Cylinder(6,0,0,radius,height),hints)
    geode.addDrawable(Capsule(8,0,0,radius,height),hints)

    geode
  }
}

