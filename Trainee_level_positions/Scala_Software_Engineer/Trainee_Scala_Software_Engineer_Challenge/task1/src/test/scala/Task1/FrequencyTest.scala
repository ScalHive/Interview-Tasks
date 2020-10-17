package Task1

import org.scalatest._

class FrequencyTest extends FlatSpec with Matchers {
  it should "Check correctness" in {
    Task1.getFrequencyOfLetters("aaaa") should be(Map[Char,Int](('a',4)))
    Task1.getFrequencyOfLetters("aaaa1313 _! test") should be(Map[Char,Int](('a',4),('t',2),('e',1),('s',1)))
    Task1.getFrequencyOfLetters("") should be(Map[Char,Int]())
    Task1.getFrequencyOfLetters("!!1!??7?") should be(Map[Char,Int]())
    Task1.getFrequencyOfLetters("aaAAaaAA") should be(Map[Char,Int](('a',8)))
  }
}
