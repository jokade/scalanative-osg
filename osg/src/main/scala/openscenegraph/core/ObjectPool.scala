package openscenegraph.core

import scala.collection.mutable
import scala.scalanative.cobj.CObjectWrapper
import scala.scalanative.interop.{AutoReleasable, Releasable}
import scala.scalanative.unsafe._

class ObjectPool[T<:Releasable](zone: Zone, objSize: CSize, initPoolSize: Int = 10)(implicit wrapper: CObjectWrapper[T]) extends AutoReleasable {
  private var _totalPoolSize = 0
  private var _freePoolSize = 0
  private val _allObjects = new mutable.UnrolledBuffer[Releasable]()
  private val _freeObjects = new mutable.UnrolledBuffer[Releasable]()

  def totalSize: Int = _totalPoolSize
  def freeSize: Int = _freePoolSize

  def resize(newSize: Int): Unit =
    if(newSize < _totalPoolSize) ???
    else if(newSize > _totalPoolSize) {
      val incSize = newSize - _totalPoolSize
      val p = zone.alloc(objSize * incSize)
      for(i <- 0 until incSize) {
        val obj = wrapper.wrap(p + (i*objSize))
        _allObjects += obj
        _freeObjects += obj
      }
      _freePoolSize += incSize
      _totalPoolSize = newSize
    }

  def get(): T = {
    if(_totalPoolSize==0)
      resize(initPoolSize)
    else if(_freePoolSize==0)
      resize(_totalPoolSize * 2)
    _freeObjects.remove(0).asInstanceOf[T]
  }

  def release(obj: T): Unit = {
    _freeObjects += obj
  }

  def free(): Unit = {
    _allObjects.foreach(_.free())
    _allObjects.clear()
    _freeObjects.clear()
    _totalPoolSize = 0
    _freePoolSize = 0
  }
}
