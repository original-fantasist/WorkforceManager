package com.fantasist.wfm.service;

import java.util.List;

import com.fantasist.wfm.entity.EmployeeEntity;

public interface EmployeeService {
	public void addEmployee(EmployeeEntity employee);
	public List<EmployeeEntity> getAllEmployees();
	public void deleteEmployee(Integer employeeId);
}
