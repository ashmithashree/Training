package account.driver;

import java.time.LocalDate;
import java.util.List;

import account.dao.EmployeeDao;
import account.dao.EmployeeDaoImpl;
import account.dto.Employee;
import account.service.EmployeeService;
import account.service.EmployeeServiceImpl;

public class EmployeeDriver {
	public static void main(String[] args) {
		EmployeeDao employeeDao=new EmployeeDaoImpl();
		EmployeeService employeeService =new EmployeeServiceImpl(employeeDao);
		//static call
//		List<Employee>emplist=employeeService.getEmployees();
//		System.out.println("Back with Employee List - "+emplist.size());
//		for(Employee employee:emplist)
//		{
//			System.out.println(employee);
//		}
		//dynamic call
		Employee emp=new Employee();
		emp.setEmpNo(6);
		emp.setEmpName("Rajni");
		emp.setJob("Accountant");
		emp.setHireDate(LocalDate.of(2019, 6, 23));
		emp.setSalary(25000);
		emp.setMgr(2);
		emp.setDeptno(2);
		emp.setComm(1);
		employeeService.insertEmployeeWithValues(emp);
		List<Employee> emplist=employeeService.getEmployees();
		System.out.println("Back with Employee List - "+emplist.size());
		for(Employee employee:emplist)
		{
			System.out.println(employee);
		}
		System.out.println("\nFind By ID "+employeeService.findEmloyeeById(1));
		
	}
}
