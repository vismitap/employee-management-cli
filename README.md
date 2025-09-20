# 🧑‍💼 Employee Manager (Java Console Project)

![Java](https://img.shields.io/badge/Java-23-red?logo=openjdk&logoColor=white)  
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
