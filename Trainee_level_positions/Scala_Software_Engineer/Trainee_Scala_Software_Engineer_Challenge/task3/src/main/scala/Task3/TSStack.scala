package Task3

case class TSStack[T](node: List[T] = List()){

  def clear = this.synchronized(TSStack[T]())

  def isEmpty = this.synchronized(node.isEmpty)

  def pop = this.synchronized{if(!isEmpty) TSStack[T](node.tail) else TSStack[T]()}

  def push(elem: T) = this.synchronized { TSStack(elem :: node) }

  def size = this.synchronized(node.length)

  def top = this.synchronized(node.headOption)

  override def toString= this.synchronized(node.toString())
}
