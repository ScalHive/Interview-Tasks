All questions and discussion should be handled the project issues with corresponding TAG.

## Introduction

1. These tasks should be written using SQL (PostgreSQL 10.5)
2. Use your personal GitHub account to fork project and push your solution to it (current subdirectory).
3. Send link to your fork project with solution.
4. Task 1 and Task 2 are students practice or trainee level.
5. Task 3 is for job offer candidates (Task 1 and Task 2 are required too ).
6. All solutions should be in the same forked project with good code style, comments and SOLUTION.md description.



## The priorities for solutions are:
  1) being correct
  2) being readable and extensible




### Task-1 Design database for the model task that contains the next entities:

- The Company,  that can provide services for the customers.
- The Service - some service the company provides to one or several customers.
- The Customer - can use the services of the one or several companies.

Result: SQL script that create database and tables


### Task-2 Write SQL statements for the next queries:


1. Find all customers of the specified company.
2. Find all companies that provide services to the specified customer.
3. For the giving customer find all services and companies that provide them.
4. Find clients that do not consume any service.
5. Find all clients that consume S1 or S2 services.
6. Find all clients that consume S1 and S2 services.
7. Find all clients that consume only S1 and S2 services.
8. Find all clients that do not consume S1 service.
9. Find all clients that consume S1 service but do not consume S2 service.
10. Find all clients of the specified company who consume the same services of the company (but may use different services of other companies).
11. Find all clients who consume services provided only by one arbitrary company.
12. Find all clients who consume services provided by only two different companies.





### Task-3

Design RESTFul Service (using Python || Java || Scala || Go || Haskel) using
async patterns with implementation of querying previously designed SQL
model. It is not required for all statements but only for two the most
interesting on your opinion.
