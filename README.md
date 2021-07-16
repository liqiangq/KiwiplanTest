# KiwiplanTest
Aaron
Task:  take a list of employees as input, and display the employee relationships in a required format.
The result: input the employees information and print the employees tree, and end by input empty
three files:
1. com.kiwiplan.recruitment.Employee.java
 * @classs Employee  Entity
 * @field: 
 *   int id 
 *   int managerId 
 *   String name
 
2. com.kiwiplan.recruitment.Management.java
 * @method: 
        addEmployee(Employee)
 *      sortRelationship()
 *      displayManagementTree()
 *      checkManager()

3. com.kiwiplan.recruitment.Application.java
 * 
 * input the employees information and print the employees tree
 * input  ID  ManagerID name
 * end empty input

Input:
10 Tom 0
2 Mickey 10
3 Jerry 10
7 John 2
5 Sarah 10


Print:
->Tom
->->Jerry
->->Mickey
->->->John
->->Sarah


The print employee tree is sorted by employee's name.


© 2021 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
