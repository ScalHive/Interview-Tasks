All questions and discussion at  
[![Join the chat at https://gitter.im/dataengi/crm-seed](https://badges.gitter.im/dataengi/crm-seed.svg)](https://gitter.im/ScalHive/Java_Scala_Task?utm_source=share-link&utm_medium=link&utm_campaign=share-link)

## Introduction

1. These tasks should be written on Scala.
2. Use your personal GitHub account to fork project and push your solution to it (current subdirectory).
3. Send link to your fork project with solution.
4. The solution should be in the same forked project with good code style, comments and SOLUTION.md description.

## Challenge description
1. Write Scala application to generate a CSV file with 100.000 rows, each row is: firstname, lastname, city, date of birth, is_male.
Each row should be different, e.g. name with a counter, dob is some date between 10 and 100 years ago, is_male boolean and random.
2. Write Akka Streams project using a Streaming File source to read CSV file
3. Add Flow Stage to Akka Streams project transform each row:
    * _incoming row_: firstname, lastname, city, date of birth, is_male
    * _outgoing row_: name, city, age, is_male (join lastname and firstname, calculate years from today-dob)
4. Add unit test to make sure code is correct
5. Add Sink to Akka Streams project to save results
     * _easy_: to CSV file
     * _better_: local DB (your choice: PostgreSQL, MySQL, Cassandra, etc.)
6. Add one more Flow to the previous Graph to collect 100 rows and calculate average age for group of 100.
Results should be stored in the separate CSV file.
(As a result Graph with one Source and to Sinks should be implemented.)
7. Add integration test suite to make sure code is correct
