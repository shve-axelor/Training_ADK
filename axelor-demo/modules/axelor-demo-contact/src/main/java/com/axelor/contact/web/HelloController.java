package com.axelor.contact.web;

import java.util.Set;

import javax.inject.Inject;

import com.axelor.contact.db.Employee;
import com.axelor.contact.db.Project;
import com.axelor.contact.db.Quotation;
import com.axelor.contact.service.HelloService;
import com.axelor.db.JpaSupport;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class HelloController extends JpaSupport {
	
	@Inject HelloService sr;

  public void onConfirm(ActionRequest request, ActionResponse response) {
    Employee employee = request.getContext().asType(Employee.class);

    response.setHidden("endDate", true);
  }

  public void note(ActionRequest request, ActionResponse response) {
    Employee employee = request.getContext().asType(Employee.class);
    Set<Project> project = employee.getProjectSet();
    if (project.size() == 0) {
      response.setValue("note", "Select Project");
    }
    String name = employee.getFirstName() + " " + employee.getLastName();
    name.toUpperCase();
    String message =
        "Hello "
            + name
            + " Welcome To The Axelor Famliy...\n You have assigned total-"
            + project.size()
            + " projects.\n";
    int count = 1;
    for (Project p : project) {
      message =
          message
              + "Project"
              + count
              + ":: ProjectName:-"
              + p.getProjectName()
              + " Project Head:-"
              + p.getProjectHead()
              + "\n";
      count++;
    }

    response.setValue("note", message);
  }
  
  public void calculate(ActionRequest request, ActionResponse response) {
	  Quotation qu = request.getContext().asType(Quotation.class);
	  Employee emp = qu.getEmployee();
	  int totalAmount = sr.calculate(emp);
	  
	  response.setValue("totalAmount", totalAmount);
  }
}
