package Task1

object Task1 {
  /**
   * Count the frequency only of english alphabet letters ignoring the case
   *
   * @param str String that contains different characters
   * @return map in which kye is a english alphabet letter and
   *         value is the appearing frequency of this letter in str string
   *         if string empty or doesn't contain any letter, you will receive empty map
   */
  def getFrequencyOfLetters(str: String): Map[Char, Int] =
    str.toCharArray.map(_.toLower).filter(_.isLetter).groupBy(x => x).map(x => (x._1, x._2.size))
}
