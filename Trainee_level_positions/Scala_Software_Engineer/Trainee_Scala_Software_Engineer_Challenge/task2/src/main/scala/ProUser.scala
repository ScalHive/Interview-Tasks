class ProUser (username:String, level:Int,experience:Int, paymentCounter: Int) extends BaseUser(username, level,experience){
  override def addExperience(amount: Int) = new ProUser(username,level,experience,paymentCounter)

  def pay(amount:Int)= new ProUser(username,level,experience,paymentCounter + amount)

  override def midnightUpdate: BaseUser = {
    if (paymentCounter == 0)
      new FreeUser(username,level+experience/500, experience%500)
    else
      new ProUser(username,level+experience/500, experience%500,paymentCounter-1)
  }
}
