package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.employee.manager.EmployeeManager;
import com.employee.model.Employee;

public class EmployeeTest {

	@BeforeEach
    void setup() {
        EmployeeManager.empList.clear(); // reset before each test
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


}
