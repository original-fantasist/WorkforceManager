package com.fantasist.wfm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fantasist.wfm.entity.EmployeeEntity;
import com.fantasist.wfm.service.EmployeeService;

@Controller
public class EmployeeController 
{
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listEmployees(ModelMap map)
    {
        map.addAttribute("employee", new EmployeeEntity());
        map.addAttribute("employeeList", employeeService.getAllEmployees());
        return "editEmployeeList";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute(value="employee") EmployeeEntity employee, BindingResult result)
    {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }
    @RequestMapping("/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/";
    }
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}