# 🧑‍💼 Employee Manager (Java Console Project)

![Java](https://img.shields.io/badge/Java-21-red?logo=openjdk&logoColor=white)  
![JUnit5](https://img.shields.io/badge/Testing-JUnit5-brightgreen?logo=java&logoColor=white)  
![Platform](https://img.shields.io/badge/Platform-Console-lightgrey)  
![License](https://img.shields.io/badge/License-MIT-blue)  

A simple **Java console-based Employee Management System** built for practicing **core Java, collections, and unit testing with JUnit 5**.  
The project demonstrates **CRUD operations** on employees, menu-driven user interaction, and testable business logic.

---

## 🚀 Features
- **Add Employee**  
  - Accept employee details and add them to an in-memory list.  
- **List Employees**  
  - Display all employees currently stored.  
- **Search Employee**  
  - Search by:
    - Employee ID
    - Employee Name
    - Department
    - Salary  
  - Results are printed or returned as a list (for testing).  
- **Remove Employee**  
  - Remove by ID with validation (handles empty list safely).  
- **Input Validation**  
  - Prevents invalid removals and searches.  
- **Menu-Driven Flow**  
  - Interactive console menu for user options.

---

## 🛠️ Tech Stack & Skills Demonstrated
- **Java 21** (compatible with Java 8+ features: Streams, Lambdas, etc.)
- **Collections Framework** (`List`, `ArrayList`, `Stream API`)
- **Java Time API** (`LocalDate`)
- **Exception & Edge Case Handling** (empty list checks, invalid removal)
- **JUnit 5** for unit testing:
  - `@BeforeEach` for test setup  
  - Assertions (`assertEquals`, `assertTrue`, `assertFalse`, `assertNotNull`, `assertThrows`)  
- **Clean Code Practices**
  - Separation of concerns (`Employee` model, `EmployeeManager` logic, `EmployeeTest` unit tests)
  - Static utility methods for menu options

---

## How to Run the Project

### Prerequisites

- Java Development Kit (JDK) 17 or higher installed  
- Command line terminal (CMD, PowerShell, or Terminal on Mac/Linux)

### Steps to Run

1. **Open a terminal** and navigate to the project directory:

```bash
cd path/to/EmployeeManagementSystem/src
javac com/employee/manager/EmployeeManager.java com/employee/model/Employee.java
java -cp . com.employee.manager.EmployeeManager
```
---

## Code in Action !
<img width="677" height="718" alt="image" src="https://github.com/user-attachments/assets/982f83e8-4c97-44e5-97a5-952c55f9f159" /><img width="682" height="402" alt="image" src="https://github.com/user-attachments/assets/e3ab055e-4c82-459d-880d-c207f70e8bc0" />
<img width="1087" height="742" alt="image" src="https://github.com/user-attachments/assets/4cb62408-88ed-4a9f-b26b-8e880b897655" />
<img width="692" height="918" alt="image" src="https://github.com/user-attachments/assets/71ffe49d-2aee-49bb-881c-722478546557" />


