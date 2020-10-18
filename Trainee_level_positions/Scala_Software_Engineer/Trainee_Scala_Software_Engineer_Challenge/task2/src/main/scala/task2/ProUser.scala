package task2

class ProUser(username: String, level: Int = 0, experience: Int = 0, paymentCounter: Int = 0) extends BaseUser(username, level, experience) {
  override def addExperience(amount: Int): ProUser = new ProUser(username, level, experience + amount, paymentCounter)

  def pay(amount: Int): ProUser = new ProUser(username, level, experience, paymentCounter + amount)

  override def midnightUpdate(): BaseUser = {
    if (paymentCounter == 0) {
      new FreeUser(username, level + experience / 500, experience % 500)
    } else {
      new ProUser(username, level + experience / 500, experience % 500, paymentCounter - 1)
    }
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[ProUser]

  override def equals(o: Any): Boolean = o match {
    case o: FreeUser => o.canEqual(this) && o.hashCode() == this.hashCode()
    case _=> false
  }

  override def hashCode(): Int = super.hashCode() + paymentCounter.hashCode()
}

