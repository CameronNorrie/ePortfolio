Program: eStoreSearch
Class: CIS 2430
Assignment: A3
Author: Cameron Norrie 1046856
Date: November 30, 2020

Compilation and Execution:
./gradlew run

Package Name: eStoreSearch

Files Included: EStoreSearch.java, Book.java, Electronics.java, Product.java, App.java, GUI.java

Junit Test Files: none required for this assignment

Function: GUI.java creates a GUI and implements the search and add functions from eStoreSearch, this function 
(GUI.java) is called on in app.java and displayed.

Test Plan:

Book.java, Electronics.java, Product.java
- All of the testing for these files have already been completed in previous assignments JUnit tests

App.java
- make sure that this file calls GUI.java properly

GUI.java
- Make sure that all 3 pages(welcome, add, and search) are visible to the user and prperly formatted like in description
- Make sure that program quits when the quit button is pressed
- Make sure that it is able to go between the 3 pages successfully by making proper elements visible/invisible
- Make sure that a message is properly printed out to the user in the message box
- Make sure that authors and publishers dissappears when switching to Electronics
- To test input:
ProductID: 1456, description: a book, Price: 5.00, Year: 2016
- Then search for this product.

****NOTE****
This assignment was definitely not perfect, so sorry for the inconvenience of having to grade this. I hope you are 
staying safe and that you enjoy your winter break!