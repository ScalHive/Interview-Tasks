package task2

abstract case class BaseUser(username: String, level: Int = 0, experience: Int = 0) {
  require("[^a-zA-z0-9._]".r.findFirstIn(username).isEmpty, "username doesn't match. It has to use only [a-z][A-Z][0-9]-._ characters")

  require(level >= 0, "level has to be higher than 0")

  require(experience >= 0, "experience can't be lower than 0")

  val expForLevelUp = 500;

  /**
   * add experiance to user for some action
   *
   * @param amount Int the number of experiance that user will recive for action
   * @return User with updated experiance
   */
  def addExperience(amount: Int): BaseUser

  /**
   * for ProUsers increase payment counter and turns FreeUser to ProUser
   *
   * @param amount Int the number of days that will be added to payment counter
   * @return User with updated payment counter
   */
  def pay(amount: Int): BaseUser

  /**
   * midnight update will update users level, experiance, action limit and payment counter
   *
   * @return User with updated state
   */
  def midnightUpdate(): BaseUser
}
