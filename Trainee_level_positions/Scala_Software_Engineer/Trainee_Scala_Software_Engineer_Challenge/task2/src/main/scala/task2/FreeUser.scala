package task2

class FreeUser(username: String, level: Int = 0, experience: Int = 0, val actionLimit: Int = 30) extends BaseUser(username, level, experience) {
  override def addExperience(amount: Int): FreeUser = if (actionLimit > 0) new FreeUser(username, level, experience + amount, actionLimit - 1) else this

  override def pay(amount: Int): ProUser = new ProUser(username, level, experience, amount)

  override def midnightUpdate(): FreeUser = {
    if (actionLimit < 3)
      new FreeUser(username, level + experience / 500, experience % 500, 3)
    else
      new FreeUser(username, level + experience / 500, experience % 500, actionLimit)
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[FreeUser]

  override def equals(o: Any): Boolean = o match {
    case o: FreeUser => o.canEqual(this) && o.hashCode() == this.hashCode()
    case _ => false
  }

  override def hashCode(): Int = super.hashCode() + actionLimit.hashCode()

}

