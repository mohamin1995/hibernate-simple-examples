package hibernate.simple.examples.dao.common;

import java.util.List;

import hibernate.simple.examples.entity.Employee;

public interface EmployeeManager {
	
	public void saveEmployee(Employee employee);
	public Employee getEmployee(Integer id);
	public List<Employee> getEmployees();
	public void updateEmployee(Employee employee);

}
