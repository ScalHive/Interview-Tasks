abstract case class BaseUser(username: String, level: Int = 0, experience: Int = 0){
  require("[^a-zA-z0-9._]".r.findFirstIn(username).isEmpty, "username doesn't match. It has to use only [a-z][A-Z][0-9]-._ characters")
  require(level>=0, "level has to be higher than 0")
  require(experience>=0, "experience can't be lower than 0")

  def addExperience(amount: Int):BaseUser

  def pay(amount:Int):BaseUser

  def midnightUpdate: BaseUser
}
