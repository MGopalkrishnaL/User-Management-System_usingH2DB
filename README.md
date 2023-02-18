# Project : User-Management-System_usingH2DB

## Frameworks and languages used
* SpringBoot
* Java

## Data flow in the project
1. Controller ( getAllUser(), getUserbyId(), addUser(), UpdateUser(), deleteUser()).
2. Services   ( getAll(), getUsingId(), saveUser(), Update(), deleteUser()).
3. Repository ( We extend the JPA repository to get the predefined function).
4. DataBase Design (In this we have Used H2-DB (which is a in memory database)).


## Data Structure Used in Project
* ArrayList
## Project Summary
User Management System is project where We used to store the data of User in a H2 Database.
In this project we had used MVC(Model View Controller) Design.
* When ever we click on the link the action takes place in the Contoller.
* Then it goes to Service layer to perform some business operation and according to the request we had given it will perform.
* Then it goes to the dao layer which is known as Repository layer to store and manipulate the date of user.

## API's
### User
#### Get : fetch data
* Get All Users 
```
http://localhost:8080/api/User/getAllUser
```
* Get User by their Id :- required Id in integer format.
* it is Path variable so we just provide the value in the path. 
```
http://localhost:8080/api/User/getuser/{userid}
```
#### Post : add data
* Add User
```
http://localhost:8080/api/User/adduser
```
#### Delete : delete data
* Delete User by their Id :- required Id in integer format.
```http
http://localhost:8080/api/User/deleteUser/{UserId}
```
#### Put : Update data
* Update Student by their Id :- required Id in integer format.
* we need to provide the param of UserId 
```http
http://localhost:8080/api/User/updateUserInfo
```
#### The above Links are used to perform CRUD operation on the User.
