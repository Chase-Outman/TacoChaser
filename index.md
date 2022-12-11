# *chase-outman.github.io*
## Software Engineering ePortfolio
### *CS499 Computer Science Capstone*

```
```

### *Professional Self-Assessment*

My start in computer science started in early 2019, where waking up one morning after working in retail for 10 years at the time and realizing that I didn’t want to continue on that path, so after that day I decided to enroll in the computer science program at Southern New Hampshire University. I was drawn to computer science because I love to work with technology and I love to solve problems, but I knew from the start that this would be a challenge to complete, since I had no prior experience with any type of programming. After completing this ePortfolio, it was great to see the progress that I have made, from learning my first language with Python, to now knowing how to code with Python, C++, and Java and learning critical skills, including collaborating in a team environment, communicating to stakeholders, data structures and algorithms, software engineering and databases, and secure coding. 
  
My time spent as SNHU wasn’t just working on solo projects, but also working in collaboration with my classmates to create a jukebox program during the course CS-310 Collaboration and Team Project. This course introduced me to using git by teaching me how to clone a repository from git, then create a new branch to add a new feature, and then merge that branch back into the main branch. Also, during the course I got to experience what happens if someone doesn’t retrieve the most updated version of the project before merging their branch back into the main, this was a great learning experience since it gave me the knowledge on how to recover code that was accidentally removed. 
  
By taking the course CS-250 Software Development Lifecycle, I learned about the agile development cycle and the waterfall development cycle, and then compared the pros and cons of both methods. During the course I got to experience each role of a scrum team, from leading the development team as the scrum master, creating code as the developer, testing the use cases as the tester, and then working with stakeholders as the product owner.
My knowledge in data structures and algorithms can be attributed to taking the course CS-250 Data Structures and Algorithms. During this class I learned about space and time complexity with big O notation and how choosing the correct data structure or algorithm can improve the efficiency of an application. One of my projects in this ePortfolio demonstrates this by comparing the time it takes to fill and search a binary search tree verse a HashMap. This course also taught me how to create some basic search algorithms like quick sort and merge sort and analyze their time complexity to determine the most efficient algorithm. 

Until I took the course DAD-220 Introduction to Structed Database Environments I had no knowledge of databases or what SQL even was. During the course I learned the basics of creating a database and the tables within the database, how to how to alter the database with CRUD (Create, Read, Update, Delete), and how to create queries with the JOIN statement to gather data from multiple tables within a database. My experience with databases isn’t just with SQL, but also with MongoDB, this knowledge came from course CS-340 Client/Server Development. This course revolved around creating a MongoDB database and designing a program with Python to interact with the database that allowed a user CRUD functionality to the MongoDB database. 
  
During my time here at SNHU I learned the importance of creating secure code and how to plan and create a security policy, and after going through a code review of older projects to enhance for my ePortfolio, I discovered how unsecure my code really was. This development of a security mindset came from course CS-405 Secure Coding, throughout this course I learned how to secure my code with data validation to protect my program from unwanted or unexpected user inputs, how to design code to prevent a buffer overflow, and how to project your database from an SQL injection attack. 
  
For my ePortfolio I took two artifacts from my data structures and algorithms course (CS-260) and enhance those artifacts to demonstrate by abilities in software engineering, data structures and algorithms, and databases. The first artifact is an application written in C++ that imports data from a CSV file into a binary search tree and the second artifact is similar except that is loads the data into a hash map instead. The following sections will go over in more depth on why I choose these certain artifacts and how enhancing these artifacts will showcase my abilities.

```
```

```
```

### *Code Review*

In this code review I will go over the original artifacts by explaining what each artifact does, next I will analysis the code to determine the code struct and the efficiencies of the code and last I will explain my enhancement plan for each artifact.

[Link to video](https://youtu.be/V_Y9_Kr2jh8)

```
```

### *Software Engineering/Design*

The artifact I chose to demonstrate my abilities with software engineering is an enhancement of two projects from CS-260(Data Structures and Algorithms), the first project was to finish a program that was written in C++, that would take data from a CSV file and store that data in a binary search tree. Once the data was loaded into the tree the user could perform search and remove functions to find and remove certain items from the tree. The second project is the same as the first, but instead of a binary search tree it uses a HashMap instead. 

I chose these artifacts because I saw lots of opportunities to enhance the code that would display my competence with software engineering. The first enhancement I wanted to do was to rewrite the entire program in Java to showcase my abilities in using different languages, the next opportunity I saw was to make the code more readable and manageable since the original code was over 400 lines long, so my next enhancement was to break the program into sperate classes to make the code more maintainable. The last enhancement I made was to combine the two programs together to allow the user to compare the binary search tree method and HashMap method. 

To reflect, the process of changing the application from C++ to Java was a fun learning experience, doing so has showed me how different languages deal with certain problems and how the two languages are also similar in certain areas. I think my biggest challenge was learning how to read data from a CSV file since the original project had a separate file that did that work for me, but after spending some time researching, I was able to solve the problem. 

```
```

### *Data Structures and Algorithms*

The artifact I chose to show my knowledge of data structures and algorithms are the same two projects from CS-260(Data Structures and Algorithms) from the software engineering section (binary search tree and HashMap projects), but with further enhancements. 

I chose this artifact again because I found more opportunities for enhancements that would demonstrate my knowledge of data structures and algorithms. The additional enhancement I made to the artifact was to upgrade the standard binary search tree to an AVL binary search tree, which is a tree that checks the heights of each sub tree to determine if they are out of balanced every time a new object is added to the tree. If the tree is out of balance the algorithm will then rotate the nodes either clockwise or counterclockwise depending on if the tree is left or right heavy. Adding this enhancement would make the searching function of the tree more consistent since the tree would be always balanced, making the AVL tree search function operate at an average and worse case time complexity of O (log n), which is more efficient that a binary search tree worse case of O (n).

To reflect the process of implementing an AVL tree was a great learning experience, while it is easy to find guides on how to create an AVL tree it is another story to create code and get the tree to work correctly. One challenge I faced was getting the delete and search function working correctly, but luckily the issue was simple in that I was comparing the search item backwards to the current root, was using ‘<’ where ‘>’ was needed and vice versa.

```
```

### *Databases*

The artifact I selected to show my abilities with databases is a program that takes the concept of the previous artifacts from CS-260 by taking and reading data from a CSV file and inserting the data into a local MySQL database. 

I chose this artifact not only to put my skills of databases on display, but also to learn how to connect to a database through an application. To get the program to work with Java required using the external library JDBC, this library allows a Java program to connect to a database and to perform a variety of queries, like search for a specific item, adding a new item to the database, and removing an item from the database. I designed the program to be able to take data from a CSV file that contains data from eBay bids and add each row from the file into a table on the database, the program can also output all the data from the table as well as searching for a specific bid. 

To reflect, the process on learning how to connect to a MySQL database was challenge at first, the first hurdler I had to overcome was to link the JDBC external library to allow my program to connect to the database. Some simple Google searches would give me plenty of resources on how to link the library, so this hurdle was easy to overcome. The next challenge was to figure out how to initialize the database at the start of the program, the best way I figured to solve this problem was to create a SQL script that would run at the start of the program that would create a new database and create a new table with the correct column names. To solve this problem, I had to research on how to execute a SQL script file and learn that another external library was needed, the ibatis library from Apache would allow me to run and execute my SQL file.

SQL script file
```
DROP DATABASE IF EXISTS ebay_records;
CREATE DATABASE ebay_records;
USE ebay_records;

CREATE TABLE ebay_records.ebay_bids (
             bid_id INT NOT NULL,
             title VARCHAR(100) NULL,
             fund VARCHAR(45) NULL,
             bid_amount VARCHAR(15) NULL,
             PRIMARY KEY (bid_id));
```

```
```

[Link to Enchanced Applications](https://github.com/Chase-Outman/tacochaser/tree/main/Enhanced)
[Link to Original Applications](https://github.com/Chase-Outman/tacochaser/tree/main/Original)


