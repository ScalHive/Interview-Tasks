object Task1 {
  def getFrequencyOfLetters(str: String) =
    str.toCharArray.map(_.toLower).filter(_.isLetter).groupBy(x => x).map(x => (x._1, x._2.size))
}
