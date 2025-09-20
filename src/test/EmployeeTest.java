package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.manager.EmployeeManager;
import com.employee.model.Employee;

public class EmployeeTest {

	@BeforeEach
    void setup() {
        EmployeeManager.empList.clear(); 
        EmployeeManager.empId = 0;
    }
	
	@Test
    void testEmployeeAddition() {
        Employee emp = new Employee(1, "Alice", "IT", 50000, LocalDate.now());
	    assertTrue(EmployeeManager.acceptEmpDetails(emp));
        assertEquals(1, EmployeeManager.empList.size(), "Employee list should have 1 entry");
        assertEquals("Alice", EmployeeManager.empList.get(0).getName(), "Employee name should match");
    }
	
	@Test
	void testEmployeeAdditionMultiple() {
	    Employee emp1 = new Employee(1, "Alice", "IT", 50000, LocalDate.now());
	    Employee emp2 = new Employee(2, "Bob", "HR", 60000, LocalDate.now());
	    assertTrue(EmployeeManager.acceptEmpDetails(emp1));
	    assertTrue(EmployeeManager.acceptEmpDetails(emp2));
	    assertEquals(2, EmployeeManager.empList.size());
	    assertEquals("Bob", EmployeeManager.empList.get(1).getName());
	}

	@Test
	void testRemoveFromEmptyList() {
	    boolean removed = EmployeeManager.removeEmpFromList(1);
	    assertFalse(removed, "Should return false when list is empty");
	    assertEquals(0, EmployeeManager.empList.size(), "List should remain empty");
	}
	
	@Test
	void testSearchByName() {
	    Employee emp1 = new Employee(1, "Alice", "IT", 50000, LocalDate.now());
	    Employee emp2 = new Employee(2, "Bob", "HR", 60000, LocalDate.now());
	    EmployeeManager.empList.add(emp1);
	    EmployeeManager.empList.add(emp2);
	    List<Employee> result = EmployeeManager.searchEmpByName("Alice");
	    assertEquals(1, result.size());
	    assertEquals("Alice", result.get(0).getName());
	}
	
	@Test
	void testSearchBySalary() {
	    Employee emp1 = new Employee(1, "Alice", "IT", 50000, LocalDate.now());
	    Employee emp2 = new Employee(2, "Bob", "HR", 60000, LocalDate.now());
	    EmployeeManager.empList.add(emp1);
	    EmployeeManager.empList.add(emp2);
	    List<Employee> result = EmployeeManager.searchEmpBySalary(60000);
	    assertEquals(1, result.size());
	    assertEquals("Bob", result.get(0).getName());
	}
	
	@Test
	void testSearchBySalaryMultiple() {
	    Employee emp1 = new Employee(1, "Alice", "IT", 60000, LocalDate.now());
	    Employee emp2 = new Employee(2, "Bob", "HR", 60000, LocalDate.now());
	    EmployeeManager.empList.add(emp1);
	    EmployeeManager.empList.add(emp2);
	    List<Employee> result = EmployeeManager.searchEmpBySalary(60000);
	    assertEquals(2, result.size());
	    boolean hasAlice = result.stream().anyMatch(e -> "Alice".equals(e.getName()));
	    assertTrue(hasAlice, "Result should contain an employee named Alice");
	}

	@Test
	void testSearchBySalary_NoMatch() {
	    Employee emp = new Employee(1, "Alice", "IT", 50000, LocalDate.now());
	    EmployeeManager.empList.add(emp);
	    List<Employee> result = EmployeeManager.searchEmpBySalary(100000);
	    assertTrue(result.isEmpty(), "Expected no employees with salary 100000");
	}
	
	@Test
	void testSearchById() {
	    Employee emp = new Employee(1, "Alice", "IT", 50000, LocalDate.now());
	    EmployeeManager.empList.add(emp);
	    List<Employee> result = EmployeeManager.searchEmpById(1);
	    assertEquals(1, result.size(), "Employee with id 1 exists!");
	}
	
	@Test
	void testSearchByDept() {
	    Employee emp = new Employee(1, "Alice", "IT", 50000, LocalDate.now());
	    EmployeeManager.empList.add(emp);
	    List<Employee> result = EmployeeManager.searchEmpByDept("IT");
	    assertEquals(1, result.size(), "Employee with dept as IT exists!");
	}



}
