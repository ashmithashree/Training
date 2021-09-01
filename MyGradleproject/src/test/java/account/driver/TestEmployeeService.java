package account.driver;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import account.dao.DBUtil;
import account.dao.EmployeeDao;
import account.dto.Employee;
import account.service.EmployeeService;
import account.service.EmployeeServiceImpl;

class TestEmployeeService {
static EmployeeService employeeService = null;
static EmployeeDao mockEmployeeDao =null;
private static Employee emp1;
private static Employee emp2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mockEmployeeDao = Mockito.mock(EmployeeDao.class);
		employeeService = new EmployeeServiceImpl(mockEmployeeDao);
//		emp1=new Employee();
//		emp1.setEmpNo(1);
//		emp1.setEmpName("Hemant");
//		emp1.setHireDate(LocalDate.of(2018,11,22));
//		emp1.setSalary(8000);
//		emp1.setJob("Developer");
//		emp2=new Employee();
//		emp2.setEmpNo(2);
//		emp2.setEmpName("Varsha");
//		emp2.setHireDate(LocalDate.of(2018,12,02));
//		emp2.setSalary(9000);
//		emp2.setJob("Tester");
		Connection conn=null;
		try {
			conn= DBUtil.getDBConnection();
			Statement stmt=conn.createStatement();
			int count=stmt.executeUpdate("insert into public.emp(\r\n"
					+ "	empno, ename, sal, deptno, job, \"Hiredate\", comm, mgr)\r\n"
					+ "	VALUES (5, 'sachin', 12000, 2, 'sales', '2012-01-20', 2, 2)");
			System.out.println("Records is inserted successfully");
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			if(conn!=null)
			{
				try {
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		Mockito.when(mockEmployeeDao.getEmployees()).thenReturn(Arrays.asList(emp1,emp2));
		
	}

	@Test
	void getAllEmployeetest() {
		List<Employee> allEmployee=employeeService.getEmployees();
		assertNotNull(allEmployee);
		assertEquals(2,allEmployee.size());
		assertNotEquals(3, allEmployee.size());
		
	}

}
