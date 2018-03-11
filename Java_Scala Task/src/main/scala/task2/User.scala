package task2

//An abstract class of task2.User (so one could not make instances, can only instantiate Free or Paid users)
abstract class User(val name:String){
  private val extraChars = Array('-','.','_')
  private var _experience = 0
  private var _level = 0
  private def isCorrectStr(s:String):Boolean = s.forall(c => c.isLetterOrDigit || extraChars.contains(c))

  def experience = _experience
  def experience_=(e:Int) = if (e>=0) _experience = e else throw new IllegalArgumentException("Experience can be non-negative only!")
  def level = _level

  //Default action, recalculating level and experience for both user types
  def midnightAction: Unit ={
    _level += (_experience / 500)
    _experience = _experience % 500
  }

  //Require username to include specific chars
  require(isCorrectStr(name))

}