package task2

import org.scalatest._

class UserTest extends FlatSpec with Matchers {
  it should "throw an IllegalArgumentException for incorrect username" in {
    an[IllegalArgumentException] should be thrownBy new FreeUser("nickname check!")
    an[IllegalArgumentException] should be thrownBy new ProUser("tester123+4")
  }

  it should "throw an IllegalArgumentException for incorrect experience and level" in {
    an[IllegalArgumentException] should be thrownBy new FreeUser("nickname", -1)
    an[IllegalArgumentException] should be thrownBy new FreeUser("nickname", 0, -1)
  }

  it should "update experience to users from add method" in {
    val freeUser = new FreeUser("Username", 0, 1, 3)
    val proUser = new ProUser("Username", 0, 2, 2)

    freeUser.addExperience(100).equals(new FreeUser("Username", 0, 101, 2))
    proUser.addExperience(100).equals(new ProUser("Username", 0, 102, 2))

    val noActionUser = new FreeUser("Username", 0, 3, 0)

    noActionUser.addExperience(100).equals(new FreeUser("Username", 0, 3, 0))

    val zeroExpAdd = new FreeUser("Username", 0, 4, 1)

    zeroExpAdd.addExperience(0).equals((new FreeUser("Username", 0, 4, 0)))
  }

  it should "update payment from pay method" in {
    val freeUser = new FreeUser("Username", 0, 1, 3)
    val proUser = new ProUser("Username", 0, 2, 2)

    freeUser.pay(30).equals(new ProUser("Username", 0, 1, 30))
    proUser.pay(30).equals(new ProUser("Username", 0, 2, 32))
  }

  it should "make correct midnight update" in {
    val freeUser = new FreeUser("Username", 1, 1400, 1)
    val proUser = new ProUser("Username", 0, 500, 0)

    freeUser.midnightUpdate().equals(new FreeUser("Username", 3, 400, 3))
    proUser.midnightUpdate().equals(new FreeUser("Username", 1, 0, 30))
  }
}
