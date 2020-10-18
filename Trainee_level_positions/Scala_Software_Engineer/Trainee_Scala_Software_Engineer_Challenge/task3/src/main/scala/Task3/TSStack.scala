package Task3

case class TSStack[T](node: List[T] = List()) {
  /**
   * make stack empty
   *
   * @return an empty stack
   */
  def clear = this.synchronized(TSStack[T]())

  /**
   * check is stack empty
   *
   * @return true if stack is empty and false if not
   */
  def isEmpty = this.synchronized(node.isEmpty)

  /**
   * delete the top element of a stack
   *
   * @return new stack without top element
   */
  def pop = this.synchronized {
    if (!isEmpty) TSStack[T](node.tail) else TSStack[T]()
  }

  /**
   * add element to top of stack
   *
   * @param elem T is an element that will be added to stack
   * @return new stack with new top element
   */
  def push(elem: T) = this.synchronized {
    TSStack(elem :: node)
  }

  /**
   * get the number of elements in stack
   *
   * @return number of elements in stack
   */
  def size = this.synchronized(node.length)

  /**
   * get the top element of stack
   *
   * @return the top element of stack
   */
  def top = this.synchronized(node.headOption)

  /**
   * get the string variant of stack
   *
   * @return string variant of stack
   */
  override def toString = this.synchronized(node.toString())
}
