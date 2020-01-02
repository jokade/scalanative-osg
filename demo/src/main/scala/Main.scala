import openscenegraph.core.Observer
import openscenegraph.viewer.Viewer

import scala.scalanative.annotation.InlineSource
import scala.scalanative.cxx.{Cxx, constructor}
import scala.scalanative.interop.AutoreleasePool
import scala.scalanative.unsafe._
import scala.scalanative.unsigned._

object Main {
  def main(args: Array[String]): Unit = Zone{ implicit z =>
    AutoreleasePool{ implicit p =>
      val viewer = Viewer().autorelease
      viewer.setUpViewOnSingleScreen(1.toUInt)

//      val cessnaL3 = OsgDB.readNodeFile(CxxString(c"/Users/kastner/Downloads/OpenSceneGraph-Data/cessna.osg")).autorelease
//      val cessnafire = OsgDB.readNodeFile(CxxString(c"/Users/kastner/Downloads/OpenSceneGraph-Data/cessnafire.osg")).autorelease
//      val cow = OsgDB.readNodeFile(CxxString(c"/Users/kastner/Downloads/OpenSceneGraph-Data/cow.osg")).autorelease

      val root = scene.Shapes()
      viewer.setSceneData(root)

      viewer.run()
    }
    println("OK")
  }
}

@InlineSource("Cxx",
  """#include <osg/Observer>
     class MyObserver : osg::Observer {
       public:
       void objectDeleted(void * p);
    };
    void MyObserver::objectDeleted(void *p) { std::cout << "Deleted!"; } """)
@Cxx
class MyObserver extends Observer {
  override def objectDeleted(ptr: Ptr[CChar]): Unit = ???
}
object MyObserver {
  @constructor
  def apply(): MyObserver = extern

}
