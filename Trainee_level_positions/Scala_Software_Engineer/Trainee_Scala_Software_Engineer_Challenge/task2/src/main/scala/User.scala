case class User(username: String, level: Int = 0, experience: Int = 0, actionLimit: Int = 30, payment: Boolean = false, paymentCounter: Int = 0){
  require("[^a-zA-z0-9._]".r.findFirstIn(username).isEmpty, "username doesn't match. It has to use only [a-z][A-Z][0-9]-._ characters")
  require(level>=0, "level has to be higher than 0")
  require(experience>=0, "experience can't be lower than 0")

  def addExperience(amount: Int): User = {
    if(payment)   this.copy(experience = this.experience + amount)
    else if (actionLimit > 0) this.copy(experience = this.experience + amount, actionLimit = this.actionLimit - 1)
    else this
  }

  def pay: User = this.copy(payment = true, paymentCounter = this.paymentCounter + 30)

  def midnightUpdate: User = {
    if(payment)
      if (paymentCounter == 1)
        User(username,level+experience/500, experience%500,actionLimit,false,paymentCounter-1)
       else
        this.copy(level = this.level+experience/500, experience = this.experience%500, paymentCounter = this.paymentCounter-1)
    else
      if(actionLimit < 3)
        this.copy(level = this.level+experience/500, experience = this.experience%500)
      else
        this.copy(level = this.level+experience/500, experience = this.experience%500, actionLimit = 3)
  }
}
