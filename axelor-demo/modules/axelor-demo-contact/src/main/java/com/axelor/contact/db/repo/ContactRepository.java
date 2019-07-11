package com.axelor.contact.db.repo;

import java.util.Map;

import com.axelor.contact.db.Employee;

public class ContactRepository extends EmployeeRepository {
	
	@Override
	public Map<String, Object> populate(Map<String, Object> json, Map<String, Object> context){
		if(!context.containsKey("json-enhance")) {
			return json;
		}
		try {
			Long id = (Long) json.get("id");
		      Employee employee = find(id);

			json.put("address", employee.getAddressList().get(0));
		}
		catch (Exception e) {
    	// TODO: handle exception
    }
    return json;
	}
}
