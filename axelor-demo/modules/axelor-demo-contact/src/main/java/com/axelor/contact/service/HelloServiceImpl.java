package com.axelor.contact.service;

import java.util.Set;

import com.axelor.contact.db.Employee;
import com.axelor.contact.db.Project;

public class HelloServiceImpl implements HelloService {

  @Override
  public int calculate(Employee emp) {
    Set<Project> pr = emp.getProjectSet();
    int sum=0;
    for(Project p : pr) {
    	sum = sum + p.getProjectPrice();
    }
    return sum;
  }}
