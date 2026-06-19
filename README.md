# Library Management System (LMS)
The Library Management System is a console based system to help librarians manage patron records through the CLI.
Librarians can perform various features such as import from text file, manually add a patron, remove patron by ID,
display all patrons, and exit program. 

SDLC_Part_2
## Features

- Import patron from text file
- Manually add patron
- Remove patron
- Display all patrons
- Patron ID number validation
- Overdue fine amount validation
- Executable JAR

<details>
<summary>Prerequisites</summary>

## Prerequisites
- IntelliJ IDEA to open project
- Java JDK
- IntelliJ terminal or Command Prompt
</details>

## Project Classes
- Main.java - Runs program
- Patron.java - Represents a patron
- LibraryManagementHelper.java - Manage patron, validate patron, add patron, remove patron, and display patrons.
- FileImport.java - Import patrons from .txt file.
- MenuControl.java - Handles CLI menu interaction

## How to Run
- Open project in IntelliJ
- Run main file:
- Main.java
- CLI menu interaction
- Run executable JAR through Command Prompt or IntelliJ terminal in project route where JAR is located.
- Enter: java -jar SDLC_Part_2.jar
- LMS will launch

## Importing Text File
- Enter full file path
- I.E. C:\Users\Name\Documents\patrons.txt
- If in same folder full file path is not required.
- Text File Format Example: 3256897-Mason Arby-6060 Saginaw St. Casselberry, FL 34852-0

## Patron Information
- unique 7-digit patron ID
- Name
- Address
- 0-250 Overdue fine amount
  
## Author
Nicholas Rini  
CEN 3024C
