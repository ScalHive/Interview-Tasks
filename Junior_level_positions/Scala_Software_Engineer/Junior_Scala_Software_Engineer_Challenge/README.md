All questions and discussion in issues of this project.


## Introduction

1. These tasks could be written on your choose on Java or Scala in object-oriented or functional style.
2. Use your personal GitHub account to fork project and push your solution to it (current subdirectory).
3. Send link to your fork project with solution.
4. Task 1 and Task 2 are students practice or trainee level.
5. Task 3 is for job offer candidates (Task 1 and Task 2 are required too ).
6. All solutions should be in the same forked project with good code style, comments and SOLUTION.md description.



## The priorities for solutions are:
  1) being correct
  2) being readable and extensible




### Task-1

There is a string of characters. It is necessary to calculate the frequency of occurrence of each character of English alphabet in this string (large and small characters count as the same).



### Task-2

Design a class to represent and create a user
*  user has a username (could not be empty and can only consist of characters "[a-z][A-Z][0-9]-._")
*  user has a level (starts from level 0 and can only increase)
*  user has experience (starts from 0 and can't ever be negative)
*  user gets experience for actions over a day and experience transfers to levels at the end of the day
*  an user is either a free user or a paid user.
*  a free user has a limit to the amount of actions he do per day.
*  a paid user has a counter of the remaining paid days


Provide a method that will be run every day at midnight for every user. It should:
1.  Give a level for each 500exp, the remaining experience goes to the next day
2.  If a free user is under 3 actions refresh the number of actions to 3
3.  Paid users reduce their days remaining count


### Task-3

Implement class TSStack with behavior of the stack data structure (LIFO) and provide a test suite that checks for the correctness of implemented methods.
Proposed implementation should:
* always return correct values or throw corresponding exceptions 
* be able to work with different data types
* could be used in a multi-threaded scenario 
