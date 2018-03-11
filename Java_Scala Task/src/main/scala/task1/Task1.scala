package task1

object Task1 {

  /*Create a Map: character -> frequency of occurence,
  considering only letters (making all lowercase), and then using foldLeft, initialized with an empty Map.
  */

  def countCharsFold(s: String) =
    s.filter(_.isLetter).toLowerCase.foldLeft(Map[Char, Int]())((m, c) => if (m.contains(c)) m + (c -> (m(c) + 1)) else m + (c -> 1))

  //Create the same Map, but using a different approach
  def countCharsGroup(s: String) =
    s.filter(_.isLetter).toLowerCase.groupBy(identity).mapValues(_.length)

}
