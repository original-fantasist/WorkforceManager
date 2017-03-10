package com.fantasist.wfm.dao;

import java.util.List;

import com.fantasist.wfm.entity.EmployeeEntity;

public interface EmployeeDAO
{
    public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}