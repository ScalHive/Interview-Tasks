package task2

//Extend to Free user type
class FreeUser(name:String) extends User(name){

  private var _numActions = 3
  def numActions = _numActions
  def numActions_=(n:Int) = _numActions = n

  override def midnightAction:Unit = {
    super.midnightAction
    if(_numActions<3) _numActions = 3
  }
}