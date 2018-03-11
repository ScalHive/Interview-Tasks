These are the solutions to three interview tasks, written in Scala.

###Task 1

Has two solutions using Scala foldLeft and groupBy methods, with other combinators to do the job. Both produce Map[Char,Int], giving
number of occurences for each character.

###Task 2

Includes abstract class User, and two classes FreeUser and PaidUser. The last two extend the abstract one, adding
number of actions and remaining paid days respectively. midnightAction is what is supposed to be done every midnight for each user.

###Task 3

Implements the Array based stack. Initial Array size is 10, and it doubles its size every time one tries to push to the end of
current Array. There is syncronized in push method to prevent race conditions for multiple threads (though it can make the stack slow).
There are simple unit tests in test/ directory, implemented using JUnit.
