package task2

//Extend to Paid user type
class PaidUser(name:String) extends User(name){

  private var _daysRemain = 5
  def daysRemain = _daysRemain
  def daysRemain_=(n:Int) = _daysRemain = n

  override def midnightAction:Unit = {
    super.midnightAction
    if (_daysRemain>0) _daysRemain -= 1
  }
}