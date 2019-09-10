package com.stackroute.squad.services;

import com.stackroute.squad.domain.SubDomain;

import java.util.List;

public interface SubDomainService {
  public SubDomain save(SubDomain subDomain);

  public List<SubDomain> getAllSubDomains();

  public SubDomain deleteSubDomain(int id);

  public SubDomain updateSubDomain(SubDomain subDomain);

}
