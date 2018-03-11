package task3

import scala.reflect.ClassTag

//Create an Array based stack, which doubles its size when one tries to push at the end of current Array size

class TSStack[A: ClassTag] {
  private var top = 0
  private var data = new Array[A](10)

  def push(obj:A ): Unit = {
    synchronized {
      if (top >= data.length) {
        val tmp = new Array[A](data.length * 2)
        Array.copy(data, 0, tmp, 0, data.length)
        data = tmp
      }

      data(top) = obj
      top += 1
    }
  }

  def pop():A ={
    assert(!isEmpty, "Pop called on an empty stack")
    top -= 1
    data(top)
  }

  def isEmpty: Boolean = top == 0

}
