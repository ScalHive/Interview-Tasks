package Task3

import org.scalatest._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

class Task3TSStack extends FlatSpec with Matchers {

  it should "check concurrent push" in {
    var pushStack: TSStack[Int] = (TSStack())

    (1 to 10000).foreach { _ =>
      var f1 = Future {
        pushStack = pushStack.push(1)
      }
      Await.result(f1, Duration.Inf)
    }

    (1 to 10000).foreach { _ => pushStack = pushStack.push(0) }
    pushStack.size should be(20000)
  }

  it should "Check pop method" in {
    var stack: TSStack[Int] = TSStack()
    stack = stack.push(0)
    stack = stack.push(1)
    stack = stack.push(2)
    stack = stack.pop
    stack should be(new TSStack[Int](List(1, 0)))
    stack = stack.pop
    stack should be(new TSStack[Int](List(0)))
    stack = stack.pop
    stack should be(new TSStack[Int](List()))
    stack = stack.pop
    stack should be(new TSStack[Int](List()))
  }

  it should "Check top method" in {
    var stack: TSStack[Int] = TSStack()
    stack = stack.push(0)
    stack = stack.push(1)
    stack = stack.push(2)
    stack.top should be(Some(2))
    stack = stack.pop
    stack.top should be(Some(1))
    stack = stack.pop
    stack.top should be(Some(0))
    stack = stack.pop
    stack.top should be(None)

  }
}
