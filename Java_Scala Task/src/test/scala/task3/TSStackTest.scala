package task3

import org.junit.Assert._
import org.junit._

class TSStackTest {
  var stack: TSStack[Int] = null

  @Before def initStack: Unit ={
    stack = new TSStack[Int]
  }

  @Test def emptyOnCreate: Unit ={
    assertTrue(stack.isEmpty)
  }

  @Test def nonEmptyOnPush: Unit ={
    stack.push(5)
    assertFalse(stack.isEmpty)
  }

  @Test def pushPop: Unit ={
    stack.push(5)
    assertEquals(5, stack.pop())
  }

  @Test def pushPopPushPop: Unit ={
    stack.push(5)
    assertEquals(5, stack.pop())
    stack.push(3)
    assertEquals(3, stack.pop())
  }

  @Test def pushPushPopPop: Unit ={
    stack.push(5)
    stack.push(3)
    assertEquals(3, stack.pop())
    assertEquals(5, stack.pop())
  }

  @Test def push100Pop100: Unit ={
    val nums = Array.fill(100)(util.Random.nextInt)
    nums.foreach(stack.push(_))
    nums.reverse.foreach(assertEquals(_, stack.pop))
  }

  @Test def parallelPush: Unit ={
    (1 to 1000).par.foreach(i => stack.push(i))
    assertFalse(stack.isEmpty)
    var len = 0
    while(!stack.isEmpty) {stack.pop; len+=1}
    assertTrue(len==1000)
  }
}
