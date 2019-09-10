package com.stackroute.squad.services;

import com.stackroute.squad.domain.Domain;


import java.util.List;

public interface DomainService {

  public Domain save(Domain domain);

  public List<Domain> getAllDomains();

  public Domain deleteDomain(int id);

  public Domain updateDomain(Domain domain);
}
