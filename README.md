# Library management system
#### Based on Spring+Spring MVC (built in Maven mode)
### Project Description
   This book management system is based on spring, spring mvc, and the database is mysql. 
The front end uses Bootstrap.
### System functions
   The system realizes the functions of readers and administrators logging in, adding, deleting,
modifying and checking books, borrowing and returning books, changing passwords, reporting loss of card numbers,
overdue reminders and other functions.
### how to use

## Preconditions
JDK 1.8+
maven 3.5+
MYSQL 5.7+

## Run Command
```
$ git clone https://github.com/withstars/Books-Management-System

$ cd Books-Management

$ mvn clean compile package install 

$ mvn jetty:run

http://localhost:9000
```

