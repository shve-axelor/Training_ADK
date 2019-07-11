package com.axelor.contact.module;

import com.axelor.app.AxelorModule;
import com.axelor.contact.db.repo.ContactRepository;
import com.axelor.contact.db.repo.EmployeeRepository;
import com.axelor.contact.service.HelloService;
import com.axelor.contact.service.HelloServiceImpl;

public class ContactModule extends AxelorModule {

  @Override
  protected void configure() {
    bind(EmployeeRepository.class).to(ContactRepository.class);
    bind(HelloService.class).to(HelloServiceImpl.class);
  }
}
