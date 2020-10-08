class FreeUser(username:String, level:Int,experience:Int, val actionLimit:Int = 30) extends BaseUser(username, level,experience){
  override def addExperience(amount: Int) = if (actionLimit > 0) new FreeUser(username,level,experience,actionLimit) else this

  override def pay(amount: Int): ProUser = new ProUser(username,level,experience,amount)

  override def midnightUpdate: FreeUser = {
    if(actionLimit < 3)
      new FreeUser(username,level+experience/500, experience%500,3)
    else
      new FreeUser(username,level+experience/500, experience%500, actionLimit)
  }
}
