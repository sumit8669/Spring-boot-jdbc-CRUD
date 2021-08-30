package com.sumit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sumit.app.dao.EmployeeDao;
import com.sumit.app.dao.impl.EmployeeDaoImpl;
import com.sumit.app.model.Employee;

@SpringBootApplication
public class SpringBootJdbcCrudExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootJdbcCrudExampleApplication.class, args);
		
		EmployeeDao employeeDao =  applicationContext.getBean(EmployeeDaoImpl.class);
		//employeeDao.createEmployee(getEmployee());
		Employee employee = employeeDao.fetchEmployeeById(1);
		System.out.println(employee);
		System.out.println("---------------------------------------");
		employeeDao.fetchAllEmployees().forEach(System.out::println);
		System.out.println("---------------------------------------");
		//employeeDao.updateEmployeeEmailById("kk.cs2021@gmail.com", 1);
		//employeeDao.deleteEmployeeById(3);
		
	}
	
	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Sean");
		employee.setEmail("sean.cs@gmail.com");
		employee.setGender("Male");
		employee.setSalary(99000.00);
		return employee;
	}
}
